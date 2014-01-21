package com.sevenwonders.server.entity.city;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.card.Resource;

public abstract class AbstractCity implements City {
	private static final long serialVersionUID = -200669157881713074L;
	
	String name;
	String imageUrl;
	
	
	protected int[] wonderStages;
	protected List<Card> cards;
	protected Map<Resource, Integer> resources;
	protected int gloryPoints;
	protected Mode mode;
	protected int warPointsWin;
	protected int warPointsLose;
	
	public AbstractCity(Mode mode) {
		this.mode = mode;
		resources = new HashMap<>();
		cards = new ArrayList<>();
		
	}
	
	public void build(Card card){
		cards.add(card);
		//TODO actions with resources
	}
	
	public int getAmount (Resource res){
		return this.resources.get(res);
	}
	
	public int getWarPoints() {
		return warPointsWin - warPointsLose;
	}
	
	public void buyFrom() {
		
	}
	
}
