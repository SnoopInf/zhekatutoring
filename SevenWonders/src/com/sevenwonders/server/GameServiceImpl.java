package com.sevenwonders.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sevenwonders.client.GameService;
import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class GameServiceImpl extends RemoteServiceServlet implements GameService {
	private static final long serialVersionUID = 5328469424874242304L;
	
	private GamesRegistry registry = GamesRegistry.getInstance();

	@Override
	public TableProxy getTable(String userId) {	
		return TableConverter.getTableProxy(registry.getTable(userId));
	}

	@Override
	public List<TableProxy> getActiveTables() {
		return TableConverter.getTableProxies(registry.getCurrentGames());
	}

	@Override
	public void buildCard(UserProxy userProxy, CardProxy card) {
		User user = registry.getUser(userProxy.getName());		
	}

	@Override
	public void sellCard(UserProxy user, CardProxy card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildWonderStage(UserProxy user, CardProxy card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TableProxy getUpdates(TableProxy table, int move) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableProxy createTable(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableProxy joinTable(String userId, TableProxy table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableProxy startGame(String userId, TableProxy table) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
