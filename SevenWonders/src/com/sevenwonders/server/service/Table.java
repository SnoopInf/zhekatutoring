package com.sevenwonders.server.service;

import java.io.Serializable;
import java.util.List;

import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.city.Mode;
import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.server.repository.CardFactory;
import com.sevenwonders.server.repository.XMLCardFactory;



public class Table implements Serializable {
	
	private List<Card> cards;
	private List<User> users;
	private int epoch;
	private int move;
	private List<Total> total;
	

	public void startGame(Mode mode) {
		setNeighbors();
		
		//take cards stack from CardFactory
		
		CardFactory factory = new XMLCardFactory();
		cards.addAll(factory.getCards(users.size()));
		
		// give cards to all players to first epoch
		
		for (int i = 0; i < users.size(); i++){
			users.get(i).setCards(cards.subList(i*7, (i+1)*7));
		}
	}

	private void setNeighbors() {
		int num = users.size();		
		for (int i = 0; i < num; i++) {
			users.get(i).setLeftNeighbor(users.get( (i + num - 1) % num));
			users.get(i).setRightNeighbor(users.get( (i+1) % num ));

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
