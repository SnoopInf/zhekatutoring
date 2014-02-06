package com.sevenwonders.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.sevenwonders.client.CardValidator;
import com.sevenwonders.client.GameService;
import com.sevenwonders.client.GameServiceAsync;
import com.sevenwonders.client.TableView;
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class CardSet extends HorizontalPanel {
	private List<CardProxy> cards = new ArrayList<CardProxy>();
	private TableView table;
	private UserProxy user;
	private CardValidator validator;

	public CardSet(TableView table) {
		this.table = table;
		this.validator = new CardValidator();
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		addStyleName("sw-card-set");
		setHorizontalAlignment(ALIGN_CENTER);
		setSpacing(20);
		update();
	}

	public List<CardProxy> getCards() {
		return cards;
	}

	public void setCards(List<CardProxy> cards) {
		this.cards = cards;
		setWidth(150 * cards.size() + "px");
	}

	public UserProxy getUser() {
		return user;
	}

	public void setUser(UserProxy user) {
		this.user = user;
	}

	public void update() {
		for (final CardProxy card : cards) {
			DisclosurePanel cardWidget = new DisclosurePanel();

			Image cardImage = new Image();
			cardImage.setUrl(card.getImageUrl());
			cardWidget.setHeader(cardImage);
			cardWidget.setAnimationEnabled(true);
			cardImage.addStyleName("sw-card");

			Panel optionsPanel = new HorizontalPanel();

			Button build = new Button("Build");
			build.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					buildCard( card );
				}
			});
			Button buildWonder = new Button("Build Wonder");
			buildWonder.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					buildWonderStage(card);
				}
			});
			Button sell = new Button("Sell");
			sell.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					sellCard(card);
				}
			});
			optionsPanel.add(build);
			optionsPanel.add(buildWonder);
			optionsPanel.add(sell);

			cardWidget.setContent(optionsPanel);

			add(cardWidget);
		}
	}
	
	private void buildCard(CardProxy card) {
		System.out.println("Clicked build " + card.getId());
		if(this.validator.validate(card, user.getCity())) {
			table.buildCard(user, card);
		} else {
			table.openTradePopup(user, card);
		}
	}
	
	private void sellCard(CardProxy card) {
		System.out.println("Clicked sell " + card.getId());
		table.sellCard(user, card);
	}
	
	private void buildWonderStage(CardProxy card) {
		System.out.println("Clicked sell " + card.getId());
		table.buildWonderStage(user, card);
	}

}
