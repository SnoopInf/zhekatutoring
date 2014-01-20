package com.sevenwonders.client;

import com.sevenwonders.shared.TableProxy;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SevenWonders implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private TableServiceAsync tableService = GWT.create(TableService.class);
	
	private TableView tableView;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Initialize the service proxy.
	    if (tableService == null) {
	    	tableService = GWT.create(TableService.class);
	    }

	    // Set up the callback object.
	    AsyncCallback<TableProxy> callback = new AsyncCallback<TableProxy>() {
	      public void onFailure(Throwable caught) {
	        // TODO: Do something with errors.
	      }

	      public void onSuccess(TableProxy result) {
	        startGame(result);
	      }
	    };

	    // Make the call to the stock price service.
	    tableService.getTable(callback);
	    
	    tableView = new TableView();
		RootPanel.get().add(tableView);   
	}
	
	private void startGame(TableProxy table) {
		tableView.startGame(table);
	}
}
