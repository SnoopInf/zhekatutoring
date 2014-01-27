package com.sevenwonders.shared;

import java.io.Serializable;

public class CardProxy implements Serializable {
	
	private static final long serialVersionUID = -7647976718859443563L;
	
	private String imageUrl;
	private String id;
	

	public CardProxy() {
		
	}
	
	public CardProxy(String id, String imageUrl) {
		this.imageUrl = imageUrl;
		this.id = id;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public String getId() {
		return id;
	}
	
}
