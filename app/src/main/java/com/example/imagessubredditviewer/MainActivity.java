package com.example.imagessubredditviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askPermission();
        initData();
        makeServerCall();

    }

    private void initData() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        redditAdapter = new RedditAdapter(listener);
        recyclerView.setAdapter(redditAdapter);

    }

    private void askPermission() {

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

}
