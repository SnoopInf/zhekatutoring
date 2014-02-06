package com.sevenwonders.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public interface GameServiceAsync {

	void getTable(String userId, AsyncCallback<TableProxy> callback);
	void getActiveTables(AsyncCallback<List<TableProxy>> callback);
	
	void buildCard(UserProxy user, CardProxy card, AsyncCallback<Void> callback );
	void sellCard(UserProxy user, CardProxy card, AsyncCallback<Void> callback);
	void buildWonderStage(UserProxy user, CardProxy card, AsyncCallback<Void> callback);
	void getUpdates(TableProxy table, int move, AsyncCallback<TableProxy> callback);
	void createTable(String userId, AsyncCallback<TableProxy> callback);
	void joinTable(String userId, TableProxy table,
			AsyncCallback<TableProxy> callback);
	void startGame(String userId, TableProxy table,
			AsyncCallback<TableProxy> callback);
}
