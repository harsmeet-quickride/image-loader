package com.example.imagessubredditviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.imagessubredditviewer.adapter.RedditAdapter;
import com.example.imagessubredditviewer.model.ApiResponse;
import com.example.imagessubredditviewer.model.ChildrenItem;
import com.example.imagessubredditviewer.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RedditAdapter redditAdapter;
    RedditAdapter.ItemClickListener listener = new RedditAdapter.ItemClickListener() {
        @Override
        public void onItemClick(ChildrenItem item) {
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", item.getData().getUrl());
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        if (isPermissionGranted()) {
            makeServerCall();
        }
    }

    private void initData() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        redditAdapter = new RedditAdapter(listener);
        recyclerView.setAdapter(redditAdapter);

    }

    private void makeServerCall() {
        RetrofitClient.getInstance(this).getHeadlines().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                Log.i(TAG, "onResponse: ");

                if (response.body() != null) {

                    redditAdapter.setList(response.body().getData().getChildren());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

                Log.i(TAG, "onFailure: ");
            }
        });
    }

    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission is granted");
                return true;
            } else {
                Log.i(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else {
            Log.i(TAG, "Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            makeServerCall();
        }
    }
}
