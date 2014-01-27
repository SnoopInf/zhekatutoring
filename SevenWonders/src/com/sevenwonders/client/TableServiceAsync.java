package com.sevenwonders.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sevenwonders.shared.TableProxy;

public interface TableServiceAsync {

	void getTable(AsyncCallback<TableProxy> callback);

}
