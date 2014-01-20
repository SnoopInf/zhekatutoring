package com.sevenwonders.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sevenwonders.client.TableService;
import com.sevenwonders.server.entity.card.BlueCard;
import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.city.Alexandria;
import com.sevenwonders.server.entity.city.City;
import com.sevenwonders.server.entity.city.Ephesus;
import com.sevenwonders.server.entity.city.Giza;
import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.server.service.Table;
import com.sevenwonders.shared.CardProxy;
import com.sevenwonders.shared.CityProxy;
import com.sevenwonders.shared.TableProxy;
import com.sevenwonders.shared.UserProxy;

public class TableServiceImpl extends RemoteServiceServlet implements TableService {
	private static final long serialVersionUID = 5328469424874242304L;

	@Override
	public TableProxy getTable() {	
		Table table = initSampleData();
		
		return toTableProxy(table);
	}
	
	private TableProxy toTableProxy(Table table) {
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

	private Table initSampleData() {
		Table table = new Table();
		List<User> users = new ArrayList<>();
		
		User user1 = new User();
		user1.setName("Test");
		
		City user1City = new Giza();
		user1.setCity(user1City);
		
		Card card1 = new BlueCard("test1", 0 , 5);
		Card card2 = new BlueCard("test2", 0 , 5);
		Card card3 = new BlueCard("test3", 0 , 5);
		Card card4 = new BlueCard("test4", 0 , 5);
		Card card5 = new BlueCard("test5", 0 , 5);
		Card[] cards = new Card[]{card1, card2, card3, card4, card5};
		user1.setCards(Arrays.asList(cards));
		users.add(user1);
		
		User user2 = new User();
		user2.setName("Test2");
		
		City user2City = new Alexandria();
		user2.setCity(user2City);
		
		users.add(user2);

		User user3 = new User();
		user3.setName("Test3");
		
		City user3City = new Ephesus();
		user3.setCity(user3City);
		
		users.add(user3);
		
		table.setUsers(users);
		return table;
	}

}
