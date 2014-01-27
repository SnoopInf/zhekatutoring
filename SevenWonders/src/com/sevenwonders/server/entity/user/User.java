package com.sevenwonders.server.entity.user;

import java.util.ArrayList;
import java.util.List;

import com.sevenwonders.server.entity.city.City;
import com.sevenwonders.server.entity.card.Card;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5618449130584820206L;
	
	private User rightNeighbor;
	private User leftNeighbor;
	private City city;
	private String name;
	private List<Card> cards = new ArrayList<>();
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public User getRightNeighbor() {
		return rightNeighbor;
	}
	public void setRightNeighbor(User rightNeighbor) {
		this.rightNeighbor = rightNeighbor;
	}
	public User getLeftNeighbor() {
		return leftNeighbor;
	}
	public void setLeftNeighbor(User leftNeighbor) {
		this.leftNeighbor = leftNeighbor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}
