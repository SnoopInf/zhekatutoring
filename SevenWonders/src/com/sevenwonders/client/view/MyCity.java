package com.sevenwonders.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sevenwonders.shared.CityProxy;

public class MyCity extends VerticalPanel {
	private CityProxy city;

	private Image cityImage;
	private Label cityName;
	
	@Override
	protected void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
		initMainLayout();
	}
	
	private void initMainLayout() {
		if(city != null) {
			cityName = new Label(city.getName());
			cityImage = new Image();
			cityImage.setUrl(city.getImageUrl());
			
			add(cityName);
			add(cityImage);
		}
		
	}

	public CityProxy getCity() {
		return city;
	}

	public void setCity(CityProxy city) {
		this.city = city;
	}
	
}