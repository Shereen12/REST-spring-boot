package com.example.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;



public class Restaurant {

	@JsonProperty
	private String uuid;

	private ResData data;

	public Restaurant() {
	}
 
	public Restaurant(String uuid, String enName, String arName, String state, String routingMethod,String logo, String coverPhoto, String enDescription,String arDescription,
			String shortNumber,String facebookLink,String twitterLink,String youtubeLink,String website,boolean onlinePayment,boolean client,boolean pendingInfo,
			boolean pendingMenu, boolean closed) {
		this.uuid = uuid;
		this.data = new ResData(enName, arName, state, routingMethod, logo, coverPhoto, enDescription, arDescription,
				shortNumber, facebookLink, twitterLink, youtubeLink, website, onlinePayment, client, pendingInfo,
				pendingMenu, closed);

	}

	@JsonProperty
	public String getId() {
		return this.uuid;
	}

	public boolean IsClosed() {
		return data.isClosed();
	}

	public ResData getData() {
		return this.data;
	}
}