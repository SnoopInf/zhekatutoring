package com.sevenwonders.server.entity.card;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCard implements Card {
	protected String name;
	protected String prev;
	protected String next;
	protected String imageUrl;

	protected int epoch;
	protected int playersNum;
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
