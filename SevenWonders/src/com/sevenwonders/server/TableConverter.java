package com.sevenwonders.server;

import java.util.ArrayList;
import java.util.List;

import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.server.service.Table;
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.CityProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class TableConverter {
	
	public static TableProxy getTableProxy(Table table) {
		List<UserProxy> users = new ArrayList<>();
		for(User user: table.getUsers()){
			CityProxy city = new CityProxy(user.getCity().getName(), user.getCity().getImageUrl());
			List<CardProxy> cards = new ArrayList<>();
			for(Card card: user.getCards()) {
				cards.add(new CardProxy(card.getName(), card.getImageUrl()));
			}
			users.add(new UserProxy(user.getName(), city, cards));
		}
		return new TableProxy(users);
	}
	
	public static List<TableProxy> getTableProxies(List<Table> tables) {
		List<TableProxy> tableProxies = new ArrayList<>(tables.size());
		for(Table table: tables) {
			tableProxies.add(getTableProxy(table));
		}
		return tableProxies;
	}
}
