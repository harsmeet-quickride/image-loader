package com.example.imagessubredditviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.imageloader.ImageLoader;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("imageUrl");

        if (url != null) {
            ImageView imageView = findViewById(R.id.imageView);
            ImageLoader.get(this).loadUrl(url).target(imageView).execute();
        }
    }
}
