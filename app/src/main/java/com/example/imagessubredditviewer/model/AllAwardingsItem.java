package com.example.imagessubredditviewer.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AllAwardingsItem{

	@SerializedName("icon_url")
	private String iconUrl;

	@SerializedName("icon_width")
	private Integer iconWidth;

	@SerializedName("end_date")
	private Object endDate;

	@SerializedName("award_sub_type")
	private String awardSubType;

	@SerializedName("is_new")
	private Boolean isNew;

	@SerializedName("days_of_drip_extension")
	private Integer daysOfDripExtension;

	@SerializedName("coin_reward")
	private Integer coinReward;

	@SerializedName("icon_height")
	private Integer iconHeight;

	@SerializedName("count")
	private Integer count;

	@SerializedName("description")
	private String description;

	@SerializedName("resized_icons")
	private List<ResizedIconsItem> resizedIcons;

	@SerializedName("coin_price")
	private Integer coinPrice;

	@SerializedName("subreddit_coin_reward")
	private Integer subredditCoinReward;

	@SerializedName("icon_format")
	private Object iconFormat;

	@SerializedName("award_type")
	private String awardType;

	@SerializedName("subreddit_id")
	private Object subredditId;

	@SerializedName("giver_coin_reward")
	private Object giverCoinReward;

	@SerializedName("is_enabled")
	private Boolean isEnabled;

	@SerializedName("penny_price")
	private Object pennyPrice;

	@SerializedName("penny_donate")
	private Object pennyDonate;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("days_of_premium")
	private Integer daysOfPremium;

	@SerializedName("start_date")
	private Object startDate;

	public String getIconUrl(){
		return iconUrl;
	}

	public Integer getIconWidth(){
		return iconWidth;
	}

	public Object getEndDate(){
		return endDate;
	}

	public String getAwardSubType(){
		return awardSubType;
	}

	public boolean isIsNew(){
		return isNew;
	}

	public Integer getDaysOfDripExtension(){
		return daysOfDripExtension;
	}

	public Integer getCoinReward(){
		return coinReward;
	}

	public Integer getIconHeight(){
		return iconHeight;
	}

	public Integer getCount(){
		return count;
	}

	public String getDescription(){
		return description;
	}

	public List<ResizedIconsItem> getResizedIcons(){
		return resizedIcons;
	}

	public Integer getCoinPrice(){
		return coinPrice;
	}

	public Integer getSubredditCoinReward(){
		return subredditCoinReward;
	}

	public Object getIconFormat(){
		return iconFormat;
	}

	public String getAwardType(){
		return awardType;
	}

	public Object getSubredditId(){
		return subredditId;
	}

	public Object getGiverCoinReward(){
		return giverCoinReward;
	}

	public boolean isIsEnabled(){
		return isEnabled;
	}

	public Object getPennyPrice(){
		return pennyPrice;
	}

	public Object getPennyDonate(){
		return pennyDonate;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public Integer getDaysOfPremium(){
		return daysOfPremium;
	}

	public Object getStartDate(){
		return startDate;
	}
}