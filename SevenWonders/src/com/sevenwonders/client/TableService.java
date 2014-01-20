package com.sevenwonders.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sevenwonders.shared.TableProxy;

@RemoteServiceRelativePath("table")
public interface TableService extends RemoteService {
	TableProxy getTable();
}
