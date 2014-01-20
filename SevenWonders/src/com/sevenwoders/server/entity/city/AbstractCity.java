package com.sevenwoders.server.entity.city;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sevenwoders.server.entity.card.GameCard;
import com.sevenwoders.server.entity.card.Resource;

public abstract class AbstractCity implements City {
	
	protected int[] wonderStages;
	protected List<GameCard> cards;
	protected Map<Resource , Integer> resources;
	protected int gloryPoints;
	protected Mode mode;
	protected int warPointsWin;
	protected int warPointsLose;
	
	public void init(Mode mode){
		this.mode = mode;
	}
	
	public void build(GameCard card){
		
	}
	
	public int getAmount (Resource res){
		return this.resources.get(res);
	}
	
	public int getWarPoints(){
		return warPointsWin - warPointsLose;
	}
	
	public void setCards(List<GameCard> cards){
		this.cards = cards;
	}
	
	public void buyFrom(){
		
	}
	
}
