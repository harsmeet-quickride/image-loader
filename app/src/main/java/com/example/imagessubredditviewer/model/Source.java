package com.example.imagessubredditviewer.model;

import com.google.gson.annotations.SerializedName;

public class Source{

	@SerializedName("width")
	private Integer width;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private Integer height;

	public Integer getWidth(){
		return width;
	}

	public String getUrl(){
		return url;
	}

	public Integer getHeight(){
		return height;
	}
}