package com.example.imagessubredditviewer.network;

import com.example.imagessubredditviewer.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rajat Sangrame on 26/11/19.
 * http://github.com/rajatsangrame
 */
public interface RedditApi {

    @GET("/r/images/hot.json")
    Call<ApiResponse> getHeadlines();

}