package com.sevenwoders.server.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sevenwoders.server.entity.card.GameCard;
import com.sevenwoders.server.entity.user.User;
import com.sevenwonders.server.repository.XMLCardFactory;

public class Table {
	
	private List<GameCard> cards;
	private List<User> users;
	private int epoch;
	private int move;
	private List<Total> total;
	
	public void startGame() throws ParserConfigurationException, SAXException, IOException {
		
		//set Neighbors to all users
		int num = users.size();
		
		users.get(0).setLeftNeighbor(users.get(num));
		users.get(0).setRightNeighbor(users.get(1));
		
		for (int i = 0; i< num-1; i++){
			users.get(i).setLeftNeighbor(users.get(i-1));
			users.get(i).setRightNeighbor(users.get(i+1));
		}
		users.get(num).setLeftNeighbor(users.get(num - 1));
		users.get(num).setRightNeighbor(users.get(0));
		
		//take cards stack from CardFactory
		
		XMLCardFactory factory = new XMLCardFactory();
		cards.addAll(factory.getCards(num));
		
		// give cards to all players to first epoch
		
		for (int i = 0; i < num; i++){
			List<GameCard> cardsForPlayer = cards.subList(i*7, i*7-1);
			
		}
	}
	
	public void turn() {
		
	}
	
	public void war() {
		
	}
	
	public void nextEpoch() {
		
	}
	
	public void getResult() {
		
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getEpoch() {
		return epoch;
	}

	public void setEpoch(int epoch) {
		this.epoch = epoch;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public List<Total> getTotal() {
		return total;
	}

	public void setTotal(List<Total> total) {
		this.total = total;
	}
	
	

}
