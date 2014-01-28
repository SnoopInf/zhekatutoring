package com.sevenwonders.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sevenwonders.shared.CityProxy;

public class CityWidget extends Composite {

	private static CityWidgetUiBinder uiBinder = GWT.create(CityWidgetUiBinder.class);

	interface CityWidgetUiBinder extends UiBinder<Widget, CityWidget> {
	}

	public CityWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField 
	HorizontalPanel info;
	@UiField 
	FlowPanel resources;
	@UiField 
	FlowPanel money;
	@UiField 
	Image wonders;

	private CityProxy city;
	
	@Override
	protected void onLoad() {
		super.onLoad();
		initMainLayout();
		addStyleName("sw-city-view");
		info.addStyleName("sw-city-info");
		resources.addStyleName("sw-city-resources");
		money.addStyleName("sw-city-money");
		wonders.addStyleName("sw-city-wonders");
	}
	
	private void initMainLayout() {
		if(city != null) {
			addStyleName(city.getName().toLowerCase());
		}
	}

	public CityProxy getCity() {
		return city;
	}

	public void setCity(CityProxy city) {
		this.city = city;
	}

}
