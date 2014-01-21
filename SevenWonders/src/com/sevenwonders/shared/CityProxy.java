package com.sevenwonders.shared;

import java.io.Serializable;

public class CityProxy implements Serializable {
	private static final long serialVersionUID = 8375971744152100760L;
	
	private String name;
	private String imageUrl;
	
	public CityProxy() {
		
	}
	
	public CityProxy(String name, String imageUrl) {
		this.name = name;
		this.imageUrl = imageUrl;
	}
	
	public String getName() {
		return name;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	
}
