package com.sevenwonders.server.entity.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sevenwonders.server.entity.city.City;
import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.card.Resource;
import com.sevenwonders.server.service.Table;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5618449130584820206L;
	
	private User rightNeighbor;
	private User leftNeighbor;
	private City city;
	private String name;
	private List<Card> cards = new ArrayList<>();
	private Table table;
	private Card selectCard;
	private String action;
	
	
	public void action(){
		switch (action) {
		case "build Card" :
			city.build(selectCard);
			break;
		case "sell" :
			sellCard(selectCard);
			break;
		case "build wonder stage" :
			// TODO logic
			break;
		}
		
		// TODO KIR HERE I NEED SOME HELP xD
	}
	
	// void for checking is enough resources to build
	
	private Map<Resource , Integer> isEnough (Card card){
		Map<Resource , Integer> need = new HashMap<>();
		boolean isOk = true;
		for(Resource key: card.getNecessaryResources().keySet()){
			need.put(key, (int)card.getNecessaryResources().get(key) - (int)city.getAmount(key)) ;
		if (need.get(key) >= 0)	 isOk = false;
		}
		if (!(isOk)) return need;
		else return null;
		
	}
	
	private void sellCard(Card card){
		this.city.setResources(Resource.Money , 3);
		dropCard(card);
	}
	
	private void dropCard(Card card){
		table.addDropedCard(card);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
