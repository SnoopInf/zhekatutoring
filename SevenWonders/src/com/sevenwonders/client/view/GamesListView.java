package com.sevenwonders.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sevenwonders.client.GameService;
import com.sevenwonders.client.GameServiceAsync;
import com.sevenwonders.shared.TableProxy;

public class GamesListView extends VerticalPanel {

	private GameServiceAsync gameService = GWT.create(GameService.class);
    
	
	
	@Override
	protected void onLoad() {
		super.onLoad();
		addStyleName("sw-games-list");
		
		 // Set up the callback object.
	    AsyncCallback<List<TableProxy>> callback = new AsyncCallback<List<TableProxy>>() {
	      public void onFailure(Throwable caught) {
	        // TODO: Do something with errors.
	      }

	      public void onSuccess(List<TableProxy> result) {
	    	showGames(result);
	      }
	    };
		gameService.getActiveTables(callback);
	}
	
	private void showGames(List<TableProxy> result) {
		for(TableProxy table: result) {
			HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label(table.toString()));
			panel.add(new Button("Start Game"));
			panel.add(new Button("Join Game"));	
			add(panel);		
		}
		Button create = new Button("Create Game");
		create.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				///gameService.
			}
		});
		add(create);
		
	}
}
