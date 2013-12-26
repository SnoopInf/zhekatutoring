package com.sevenwoders.server.entity.user;

import com.sevenwoders.server.entity.city.City;

public class User {

	private User rightNeighbor;
	private User leftNeighbor;
	private City city;
	
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
}
