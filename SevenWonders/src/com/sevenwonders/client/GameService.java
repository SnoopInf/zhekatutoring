package com.sevenwonders.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

@RemoteServiceRelativePath("game")
public interface GameService extends RemoteService {
	TableProxy getTable(String userId);
	List<TableProxy> getActiveTables();
	void buildCard(UserProxy user, CardProxy card );
	void sellCard(UserProxy user, CardProxy card);
	void buildWonderStage(UserProxy user, CardProxy card);
	TableProxy getUpdates(TableProxy table, int move);
	TableProxy createTable(String userId);
	TableProxy joinTable(String userId, TableProxy table);
	TableProxy startGame(String userId, TableProxy table);
}
