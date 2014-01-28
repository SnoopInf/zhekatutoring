package com.sevenwonders.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sevenwonders.client.view.CardSet;
import com.sevenwonders.client.view.CityWidget;
import com.sevenwonders.client.view.InformationPanel;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class TableView extends Composite {

	private static TableViewUiBinder uiBinder = GWT.create(TableViewUiBinder.class);
	
	private TableProxy table;
	private final String MY_NAME = "Test"; //TODO get current user from session
	
	@UiField
    HTMLPanel infoPanel;
	@UiField
	SplitLayoutPanel mainPanel;
	@UiField
	HTMLPanel cardSetPanel;
	

	interface TableViewUiBinder extends UiBinder<Widget, TableView> {
	}

	public TableView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void build(TableProxy table) {
		this.table = table;
		buildMainLayout();
	}
	
	private void buildMainLayout() {
		addStyleName("sw-giza");
		CardSet cardSet = new CardSet(this);
		int i = 0;
		
		//mainPanel.setSpacing(4);
		
		FlowPanel northPanel = new FlowPanel();
		northPanel.addStyleName("sw-cities-north");
		
		FlowPanel westPanel = new FlowPanel();
		westPanel.addStyleName("sw-cities-west");
		
		FlowPanel eastPanel = new FlowPanel();
		eastPanel.addStyleName("sw-cities-east");
		
		SimplePanel southPanel = new SimplePanel();
		southPanel.addStyleName("sw-cities-south");
		
		Dictionary info = Dictionary.getDictionary("info");
		String email = info.get("email");
		
		for(UserProxy user: table.getUsers()) {
			if(MY_NAME.equals(user.getName())) {
				CityWidget city = new CityWidget();
				city.setCity(user.getCity());
				cardSet.setCards(user.getCards());
				southPanel.add(city);
				//southPanel.setCellHorizontalAlignment(city, HorizontalPanel.ALIGN_CENTER);
			} else {
				CityWidget city = new CityWidget();
				city.setCity(user.getCity());
				switch(i%3) {
					case 0:  northPanel.add(city);
					//northPanel.setCellHorizontalAlignment(city, HorizontalPanel.ALIGN_CENTER);
					break;
					case 1: eastPanel.add(city); 
					break;
					case 2: westPanel.add(city); 
					break;
				}
				i++;
			}
		}
		
		InformationPanel panel = new InformationPanel();
		panel.add(new Label(email));
		infoPanel.add(panel);
		mainPanel.addSouth(cardSet, 300);
		mainPanel.addWest(westPanel, 250);
		mainPanel.addEast(eastPanel, 250);
		mainPanel.addNorth(northPanel, 150);
		mainPanel.animate(10);
		mainPanel.add(southPanel);
		//cardSetPanel.add(cardSet);

	}
}
