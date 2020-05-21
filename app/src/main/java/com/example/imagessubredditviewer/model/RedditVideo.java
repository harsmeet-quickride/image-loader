package com.example.imagessubredditviewer.model;

import com.google.gson.annotations.SerializedName;

public class RedditVideo{

	@SerializedName("duration")
	private Integer duration;

	@SerializedName("is_gif")
	private Boolean isGif;

	@SerializedName("dash_url")
	private String dashUrl;

	@SerializedName("fallback_url")
	private String fallbackUrl;

	@SerializedName("width")
	private Integer width;

	@SerializedName("scrubber_media_url")
	private String scrubberMediaUrl;

	@SerializedName("hls_url")
	private String hlsUrl;

	@SerializedName("transcoding_status")
	private String transcodingStatus;

	@SerializedName("height")
	private Integer height;

	public Integer getDuration(){
		return duration;
	}

	public boolean isIsGif(){
		return isGif;
	}

	public String getDashUrl(){
		return dashUrl;
	}

	public String getFallbackUrl(){
		return fallbackUrl;
	}

	public Integer getWidth(){
		return width;
	}

	public String getScrubberMediaUrl(){
		return scrubberMediaUrl;
	}

	public String getHlsUrl(){
		return hlsUrl;
	}

	public String getTranscodingStatus(){
		return transcodingStatus;
	}

	public Integer getHeight(){
		return height;
	}
}