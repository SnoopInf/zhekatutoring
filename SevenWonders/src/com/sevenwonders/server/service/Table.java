package com.sevenwonders.server.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.city.Mode;
import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.server.repository.CardFactory;
import com.sevenwonders.server.repository.XMLCardFactory;



public class Table implements Serializable {
	
	
	private List<Card> cards; // cards of current epoch
	private List<User> users;
	private int epoch;
	private int move;
	private int turn;
	private List<Total> total;
	private List<Card> discardPile;
	
// set cards to all players from epoch 1
// set neighbors
	public void startGame(Mode mode) {
		setNeighbors();
		CardFactory factory = new XMLCardFactory();
		cards.addAll(factory.getCards(users.size() ,epoch));
		giveCards();
		epoch = 1;
		turn = 1;
		turn();
	}
	
// send cards to next player
	
	private void reSendCards(){
		List<Card> temp = new ArrayList();
		int num = users.size() ;
		temp = users.get(0).getCards();
		for(int i = num-1; i >= 0; i--){
			(users.get(i).getLeftNeighbor()).setCards(users.get(i).getCards());;
			if (i == 0){
				(users.get(i).getLeftNeighbor()).setCards(temp);
			}
		}
	}
	
 
	// add card sold or droped by players to discard pile in table
 	public void addDropedCard(Card card){
		discardPile.add(card);
	}
	
//give cards to players
	private void giveCards(){
		for (int i = 0; i < users.size(); i++){
			users.get(i).setCards(cards.subList(i*7, (i+1)*7));
		}
	}
//set neighbors	
	private void setNeighbors() {
		int num = users.size();		
		for (int i = 0; i < num; i++) {
			users.get(i).setLeftNeighbor(users.get( (i + num - 1) % num));
			users.get(i).setRightNeighbor(users.get( (i+1) % num ));

		}
	}
	
	// turn logic
	public void turn() {
		// here is would be turn of each player
		for (int i = 0; i < users.size() ; i++){
			users.get(i).action();
		}
		// resend cards to neighbors
		reSendCards();
		// end of epoch
		if (turn == 6){
			war();
			nextEpoch();
			return;
		}
		turn++;
		//TODO turn logic
	}
	
	public void war() {
		// TODO get users military points and counts their difference within their neighbors
	}
	
	public void nextEpoch() {
		turn = 1;
		epoch++;
		if (epoch == 4){
			getResult();
			return;
		}
		CardFactory factory = new XMLCardFactory();
		cards.clear();
		cards.addAll(factory.getCards(users.size() ,epoch));
		giveCards();
	}
	
	public void getResult() {
		// TODO count points from all users.
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
