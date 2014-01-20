package com.sevenwonders.server.entity.city;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.card.Resource;

public abstract class AbstractCity implements City {
	
	String name;
	String imageUrl;
	
	
	protected int[] wonderStages;
	protected List<Card> cards;
	protected Map<Resource , Integer> resources;
	protected int gloryPoints;
	protected Mode mode;
	protected int warPointsWin;
	protected int warPointsLose;
	
	public void init(Mode mode){
		this.mode = mode;
	}
	
	public void build(Card card){
		
	}
	
	public int getAmount (Resource res){
		return this.resources.get(res);
	}
	
	public int getWarPoints(){
		return warPointsWin - warPointsLose;
	}
	
	public void setCards(List<Card> cards){
		this.cards = cards;
	}
	
	public void buyFrom(){
		
	}
	
}
