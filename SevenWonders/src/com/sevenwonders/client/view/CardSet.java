package com.sevenwonders.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.sevenwonders.shared.CardProxy;

public class CardSet extends HorizontalPanel {
	private List<CardProxy> cards = new ArrayList<CardProxy>();
	
	@Override
	protected void onLoad() {
		super.onLoad();
		update();
	}

	public List<CardProxy> getCards() {
		return cards;
	}

	public void setCards(List<CardProxy> cards) {
		this.cards = cards;
	}
	
	public void update() {
		for(CardProxy card: cards) {
			DisclosurePanel cardWidget = new DisclosurePanel();
			Image cardImage = new Image();
			cardImage.setUrl(card.getImageUrl());
			cardWidget.setHeader(cardImage);
			cardWidget.setAnimationEnabled(true);
			
			Panel optionsPanel = new HorizontalPanel();
			
			Button build = new Button("Build");
			Button buildWonder = new Button("Build Wonder");
			Button sell = new Button("Sell");

			optionsPanel.add(build);
			optionsPanel.add(buildWonder);
			optionsPanel.add(sell);
						
			cardWidget.setContent(optionsPanel);
			
			add(cardWidget);
		}
	}
	
	

}
