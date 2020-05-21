package com.example.imagessubredditviewer.model;

import com.google.gson.annotations.SerializedName;

public class ChildrenItem{

	@SerializedName("data")
	private Data data;

	@SerializedName("kind")
	private String kind;

	public Data getData(){
		return data;
	}

	public String getKind(){
		return kind;
	}
}