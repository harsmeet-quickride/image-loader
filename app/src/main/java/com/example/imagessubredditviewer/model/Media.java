package com.example.imagessubredditviewer.model;

import com.google.gson.annotations.SerializedName;

public class Media{

	@SerializedName("reddit_video")
	private RedditVideo redditVideo;

	public RedditVideo getRedditVideo(){
		return redditVideo;
	}
}