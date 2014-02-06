package com.sevenwonders.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class TableView extends Composite {

	private static TableViewUiBinder uiBinder = GWT
			.create(TableViewUiBinder.class);

	private GameServiceAsync gameService = GWT.create(GameService.class);

	private AsyncCallback<Void> callback;
	private AsyncCallback<TableProxy> updateCallback;

	private Timer timer;

	private TableProxy table;
	private final String MY_NAME = "Test"; // TODO get current user from session

	@UiField
	HTMLPanel infoPanel;
	@UiField
	SplitLayoutPanel mainPanel;
	@UiField
	HTMLPanel cardSetPanel;

	private CardSet cardSet;

	private Map<UserProxy, CityWidget> cities = new HashMap<UserProxy, CityWidget>();
	private UserProxy currentUserProxy;

	private static final int NORTH = 0;
	private static final int SOUTH = 1;
	private static final int WEST = 2;
	private static final int EAST = 3;
	


	interface TableViewUiBinder extends UiBinder<Widget, TableView> {
	}

	public TableView() {
		initWidget(uiBinder.createAndBindUi(this));

		updateCallback = new AsyncCallback<TableProxy>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors.
			}

			public void onSuccess(TableProxy result) {
				if (result != null) {
					update(result);
				}
			}
		};

		callback = new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				// TODO: Do something with errors.
			}

			public void onSuccess(Void result) {
				startPolling();
			}
		};
		this.timer = new Timer() {
			@Override
			public void run() {
				poll();
			}
		};
	}

	public void build(TableProxy table) {
		this.table = table;
		buildMainLayout();
	}

	private void buildMainLayout() {
		addStyleName("sw-giza");
		cardSet = new CardSet(this);

		// mainPanel.setSpacing(4);

		FlowPanel northPanel = new FlowPanel();
		northPanel.addStyleName("sw-cities-north");

		FlowPanel westPanel = new FlowPanel();
		westPanel.addStyleName("sw-cities-west");

		FlowPanel eastPanel = new FlowPanel();
		eastPanel.addStyleName("sw-cities-east");

		SimplePanel southPanel = new SimplePanel();
		southPanel.addStyleName("sw-cities-south");
		int i = 0;
		for (UserProxy user : table.getUsers()) {
			if (MY_NAME.equals(user.getName())) {
				CityWidget city = new CityWidget();
				city.setCity(user.getCity());
				cardSet.setCards(user.getCards());
				southPanel.add(city);
				currentUserProxy = user;
				break;
				// southPanel.setCellHorizontalAlignment(city,
				// HorizontalPanel.ALIGN_CENTER);
			} else {
				CityWidget city = new CityWidget();
				city.setCity(user.getCity());
				switch (i % 3) {
				case 0:
					northPanel.add(city);
					// northPanel.setCellHorizontalAlignment(city,
					// HorizontalPanel.ALIGN_CENTER);
					break;
				case 1:
					eastPanel.add(city);
					break;
				case 2:
					westPanel.add(city);
					break;
				}
			}
			i++;
		}

		InformationPanel panel = new InformationPanel();
		infoPanel.add(panel);
		mainPanel.addSouth(cardSet, 300);
		mainPanel.addWest(westPanel, 250);
		mainPanel.addEast(eastPanel, 250);
		mainPanel.addNorth(northPanel, 150);
		mainPanel.animate(10);
		mainPanel.add(southPanel);
		// cardSetPanel.add(cardSet);

	}

	public void update(TableProxy table) {
		stopPolling();
		for (UserProxy user : table.getUsers()) {
			cities.get(user).setCity(user.getCity());
			if (currentUserProxy.equals(user)) {
				cardSet.setCards(user.getCards());
				// southPanel.setCellHorizontalAlignment(city,
				// HorizontalPanel.ALIGN_CENTER);
			}
		}

	}

	public void openTradePopup(UserProxy user, CardProxy card) {
		// opens trade window
	}

	private int calcMove(TableProxy table) {
		return 1;
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
		gameService.getUpdates(this.table, calcMove(table), updateCallback);
	}

	public void buildCard(UserProxy user, CardProxy card) {
		gameService.buildCard(user, card, callback);
	}

	public void sellCard(UserProxy user, CardProxy card) {
		gameService.sellCard(user, card, callback);
	}

	public void buildWonderStage(UserProxy user, CardProxy card) {
		gameService.buildWonderStage(user, card, callback);
	}

}
