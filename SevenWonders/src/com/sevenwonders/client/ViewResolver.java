package com.sevenwonders.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sevenwonders.client.view.GamesListView;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

/**
 * Resolves currently visible view for the user. 
 * Keeps track of running games.
 * @author kirilldavidenko
 *
 */

public class ViewResolver {
	
	private GameServiceAsync tableService = GWT.create(GameService.class);
	
	private TableView tableView;
	private GamesListView listView;
	private SimplePanel mainLayout;
	
	public ViewResolver() {
		 tableView = new TableView();
		 listView = new GamesListView();
		 mainLayout = new SimplePanel();
	}
	
	public Widget getView() {
	    // Set up the callback object.
	    AsyncCallback<TableProxy> callback = new AsyncCallback<TableProxy>() {
	      public void onFailure(Throwable caught) {
	        // TODO: Do something with errors.
	      }

	      public void onSuccess(TableProxy result) {
	    	if(result == null) {
	    		showGamesListView();
	    	}
	    	showActiveTable(result);
	      }
	    };
		tableService.getTable(getUserId(), callback);
		return mainLayout;
	}
	
	private void showActiveTable(TableProxy table) {
		tableView.build(table);
		mainLayout.add(tableView);
	}
	
	private void showGamesListView() {
		mainLayout.add(listView);
	}
	
	private String getUserId() {
		Dictionary info = Dictionary.getDictionary("info");
		return info.get("email");
	}
}
