package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ResData {

	@JsonProperty
	private String enName;
	@JsonProperty
	private String arName;
	@JsonProperty
	private String state;
	@JsonProperty
	private String routingMethod;
	@JsonProperty
	private String logo;
	@JsonProperty
	private String coverPhoto;
	@JsonProperty
	private String enDescription;
	@JsonProperty
	private String arDescription;
	@JsonProperty
	private String shortNumber;
	@JsonProperty
	private String facebookLink;
	@JsonProperty
	private String twitterLink;
	@JsonProperty
	private String youtubeLink;
	@JsonProperty
	private String website;
	@JsonProperty
	private boolean onlinePayment;
	@JsonProperty
	private boolean client;
	@JsonProperty
	private boolean pendingInfo;
	@JsonProperty
	private boolean pendingMenu;
	
	private boolean closed;
	
	public ResData() {
	}

	public ResData(String enName, String arName, String state, String routingMethod, String logo, String coverPhoto,
			String enDescription, String arDescription, String shortNumber, String facebookLink, String twitterLink,
			String youtubeLink, String website, boolean onlinePayment, boolean client, boolean pendingInfo,
			boolean pendingMenu, boolean closed) {

		this.enName = enName;
		this.arName = arName;
		this.state = state;
		this.routingMethod = routingMethod;
		this.logo = logo;
		this.coverPhoto = coverPhoto;
		this.enDescription = enDescription;
		this.shortNumber = shortNumber;
		this.facebookLink = facebookLink;
		this.twitterLink = twitterLink;
		this.youtubeLink = youtubeLink;
		this.website = website;
		this.onlinePayment = onlinePayment;
		this.client = client;
		this.pendingInfo = pendingInfo;
		this.pendingMenu = pendingMenu;
		this.closed = closed;

	}

	

	public boolean isClosed() {
		// TODO Auto-generated method stub
		return this.closed;
	}

}
