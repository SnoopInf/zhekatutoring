package com.sevenwonders.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sevenwonders.client.GameService;
import com.sevenwonders.shared.TableProxy;

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

}
