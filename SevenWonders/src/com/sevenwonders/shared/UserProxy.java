package com.sevenwonders.shared;

import java.io.Serializable;
import java.util.List;


public class UserProxy implements Serializable {
	private static final long serialVersionUID = 1578171251412539103L;
	private String name;
	private CityProxy city;
	private List<CardProxy> cards;
	
	public UserProxy() {
		
	}
	
	public UserProxy(String name, CityProxy city, List<CardProxy> cards) {
		this.name = name;
		this.city = city;
		this.cards = cards;
	}
	
	public String getName() {
		return name;
	}
	public CityProxy getCity() {
		return city;
	}
	public List<CardProxy> getCards() {
		return cards;
	}
	
   

}
