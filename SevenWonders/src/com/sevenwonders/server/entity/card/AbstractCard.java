package com.sevenwonders.server.entity.card;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCard implements Card {
	
	protected String name;
	protected String prev;
	protected String next;
	protected String imageUrl;

	protected int ID;
	protected int epoch;
	protected int playersNum;
	
	protected Map<SGMpoints , Integer> buns; 
	protected Map<Resource, Integer> resources;
	

	// constructor for dif card

	public AbstractCard() {
		this(null, 0, 0);
	}
	
	public AbstractCard(String name, int epoch, int players) {
		this(name, epoch, players, null, null);
	}

	public AbstractCard(String name, int epoch, int players, String prev,
			String next) {
		this.name = name;
		this.prev = prev;
		this.next = next;
		this.epoch = epoch;
		this.playersNum = players;
		this.resources = new HashMap<>();
		this.imageUrl = "/images/cards/" + name + ".jpg";
	}

	// set all resources to our created card;
	
	
	public void setRes(Resource res, int quantity) {
		this.resources.put(res, quantity);
	}

	public Integer getResource(Resource res) {
		return this.resources.get(res);
	}
	
	public void addAll(Map map1, Map map2){
		int var;
		if (map1.size() == map2.size())
		for(Object key: map1.keySet()){
			var = (int)map1.get(key) + (int)map2.get(key);
			map1.put(key , var ); 
		}
	}
	
	public void setBuns(SGMpoints buns , int quntity){
		this.buns.put(buns , quntity);
	}
	
	public Integer getBuns(SGMpoints buns){
		return this.buns.get(buns);
		
	}
	//TODO this is second variant for getBuns
	// this can be global metod
	public void getSmtng (Map buns1, Map buns2){
		addAll(buns1 , buns2);
	}
	
	
	@Override
	public Map<Resource, Integer> getNecessaryResources() {
		return resources;
	}

	// get for everything

	public String getName() {
		return name;
	}

	public String getPrev() {
		return prev;
	}

	public String getNext() {
		return next;
	}

	public int getEpoch() {
		return epoch;
	}

	public int getPlayers() {
		return playersNum;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
