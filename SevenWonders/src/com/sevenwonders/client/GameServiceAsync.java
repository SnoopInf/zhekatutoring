package com.sevenwonders.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sevenwonders.shared.TableProxy;

public interface GameServiceAsync {

	void getTable(String userId, AsyncCallback<TableProxy> callback);
	void getActiveTables(AsyncCallback<List<TableProxy>> callback);
}
