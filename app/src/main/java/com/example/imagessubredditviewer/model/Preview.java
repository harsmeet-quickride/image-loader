package com.example.imagessubredditviewer.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Preview{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("enabled")
	private Boolean enabled;

	public List<ImagesItem> getImages(){
		return images;
	}

	public boolean isEnabled(){
		return enabled;
	}
}