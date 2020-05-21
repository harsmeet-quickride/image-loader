package com.example.imagessubredditviewer.network;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rajat Sangrame on 26/11/19.
 * http://github.com/rajatsangrame
 */
public class RetrofitClient {

    private static final String BASE_URL = "https://www.reddit.com";
    private static final Object LOCK = new Object();
    private static RedditApi redditApi;
    private static RetrofitClient sInstance;

    public static RedditApi getInstance(Context context) {

        if (sInstance == null || redditApi == null) {
            synchronized (LOCK) {

                Cache cache = new Cache(context.getApplicationContext().getCacheDir(), 5 * 1024 * 1024);

                Interceptor networkInterceptor = new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // set max-age and max-stale properties for cache header
                        CacheControl cacheControl = new CacheControl.Builder()
                                .maxAge(1, TimeUnit.HOURS)
                                .maxStale(3, TimeUnit.DAYS)
                                .build();
                        return chain.proceed(chain.request())
                                .newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", cacheControl.toString())
                                .build();
                    }
                };

                // Building OkHttp client
                OkHttpClient client = new OkHttpClient.Builder()
                        .cache(cache)
                        .addNetworkInterceptor(networkInterceptor)
                        .build();


                // Retrofit Builder
                Retrofit.Builder builder =
                        new Retrofit
                                .Builder()
                                .baseUrl(BASE_URL)
                                .client(client)
                                .addConverterFactory(GsonConverterFactory.create(new Gson()));

                // Set NewsApi instance
                redditApi = builder.build().create(RedditApi.class);
                sInstance = new RetrofitClient();
            }
        }
        return redditApi;
    }


    // Make sure this class never initialize
    private RetrofitClient() {
    }
}
