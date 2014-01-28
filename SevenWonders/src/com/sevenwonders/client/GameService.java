package com.sevenwonders.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sevenwonders.shared.TableProxy;

@RemoteServiceRelativePath("game")
public interface GameService extends RemoteService {
	TableProxy getTable(String userId);
	List<TableProxy> getActiveTables();
}
