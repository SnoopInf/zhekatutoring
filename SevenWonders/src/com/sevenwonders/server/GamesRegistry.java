package com.sevenwonders.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sevenwonders.server.entity.card.BlueCard;
import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.city.Alexandria;
import com.sevenwonders.server.entity.city.City;
import com.sevenwonders.server.entity.city.Ephesus;
import com.sevenwonders.server.entity.city.Giza;
import com.sevenwonders.server.entity.city.Mode;
import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.server.service.Table;

public class GamesRegistry {
	private List<Table> waitingGames;
	private Map<String, User> users; //FIXME temp list while we have no DB with users
	private Map<User, Table> usersToTableMap;
	
	private static GamesRegistry instance;
	
	private GamesRegistry() {
		waitingGames = new ArrayList<>();
		users = new HashMap<>();
		usersToTableMap = new HashMap<>();
	}
	
	public static GamesRegistry getInstance() {
		if(instance == null) {
			instance = new GamesRegistry();
		}
		return instance;
	}
	
	public List<Table> getCurrentGames() {
		return waitingGames;
	}
	
	public Table getTable(String userId) {
		return testTable();
		/*
		User user = users.get(userId);
		if(user != null) {
			return usersToTableMap.get(user);
		}
		return null;
		*/
	}
	
	public void registerNewGame(Table table, User user) {
		usersToTableMap.put(user, table);
		users.put(user.getName(), user);
		waitingGames.add(table);
	}
	
	public void joinGame(Table table, User user) {
		users.put(user.getName(), user);
		usersToTableMap.put(user, table);
	}
	
	public void startGame(Table table) {
		waitingGames.remove(table);
	}
	
	public void gameEnded(Table table) {
		for(User user: table.getUsers()) {
			usersToTableMap.remove(user);
		}
	}
	
	private Table testTable() {
		Table table = new Table();
		List<User> users = new ArrayList<>();
		
		User user1 = new User();
		user1.setName("Test");
		
		City user1City = new Giza(Mode.A);
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
		
		City user2City = new Alexandria(Mode.A);
		user2.setCity(user2City);
		
		users.add(user2);

		User user3 = new User();
		user3.setName("Test3");
		
		City user3City = new Ephesus(Mode.A);
		user3.setCity(user3City);
		
		users.add(user3);
		
		User user4 = new User();
		user4.setName("Test4");
		
		City user4City = new Ephesus(Mode.A);
		user4.setCity(user4City);
		
		users.add(user4);
		
		User user5 = new User();
		user5.setName("Test5");
		
		City user5City = new Ephesus(Mode.A);
		user5.setCity(user5City);
		
		users.add(user5);
		
		User user6 = new User();
		user6.setName("Test6");
		
		City user6City = new Ephesus(Mode.A);
		user6.setCity(user6City);
		
		users.add(user6);
		
		User user7 = new User();
		user7.setName("Test7");
		
		City user7City = new Ephesus(Mode.A);
		user7.setCity(user7City);
		
		users.add(user7);
		
		table.setUsers(users);
		System.out.println("data reloaded");
		return table;
	}
}
