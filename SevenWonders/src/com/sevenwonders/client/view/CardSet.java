package com.sevenwonders.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.sevenwonders.client.GameService;
import com.sevenwonders.client.GameServiceAsync;
import com.sevenwonders.client.TableView;
import com.sevenwonders.shared.CardProxy;

public class CardSet extends HorizontalPanel {
	private List<CardProxy> cards = new ArrayList<CardProxy>();
	private GameServiceAsync gameService = GWT.create(GameService.class);
	private Timer timer;
	private TableView table;

	public CardSet(TableView table) {
		this.timer = new Timer() {
			@Override
			public void run() {
				poll();
			}
		};
		this.table = table;
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
					System.out.println("Clicked build " + card.getId());
					startPolling();
				}
			});
			Button buildWonder = new Button("Build Wonder");
			buildWonder.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					System.out.println("Clicked build wonder " + card.getId());
					startPolling();
				}
			});
			Button sell = new Button("Sell");
			sell.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					System.out.println("Clicked sell " + card.getId());
					startPolling();
				}
			});
			optionsPanel.add(build);
			optionsPanel.add(buildWonder);
			optionsPanel.add(sell);

			cardWidget.setContent(optionsPanel);

			add(cardWidget);
		}
	}

	public void startPolling() {
		timer.scheduleRepeating(10000);

		System.out.println("Started polling");
	}

	public void stopPolling() {
		timer.cancel();

		System.out.println("Stopped polling");
	}

	public void poll() {
		// updateGameStatus
		System.out.println("Update Game Status");
		addStyleName("sw-polled");
		stopPolling();
	}

}
