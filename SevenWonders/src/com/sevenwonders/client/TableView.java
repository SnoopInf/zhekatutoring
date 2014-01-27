package com.sevenwonders.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sevenwonders.client.view.CardSet;
import com.sevenwonders.client.view.InformationPanel;
import com.sevenwonders.client.view.MyCity;
import com.sevenwonders.client.view.PlayerCity;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class TableView extends Composite {

	private static TableViewUiBinder uiBinder = GWT.create(TableViewUiBinder.class);
	
	private TableProxy table;
	private final String MY_NAME = "Test"; //TODO get current user from session
	
	@UiField
    HTMLPanel infoPanel;
	@UiField
	HTMLPanel mainPanel;
	@UiField
	HTMLPanel cardSetPanel;
	

	interface TableViewUiBinder extends UiBinder<Widget, TableView> {
	}

	public TableView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void startGame(TableProxy table) {
		this.table = table;
		MyCity myCity = new MyCity();
		CardSet cardSet = new CardSet();
		for(UserProxy user: table.getUsers()) {
			if(MY_NAME.equals(user.getName())) {
				myCity.setCity(user.getCity());
				cardSet.setCards(user.getCards());
			} else {
				PlayerCity city = new PlayerCity();
				city.setCity(user.getCity());
				mainPanel.add(city);
			}
		}
		infoPanel.add(new InformationPanel());
		cardSetPanel.add(cardSet);
		mainPanel.add(myCity);
	}
}
