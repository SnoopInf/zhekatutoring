package com.sevenwonders.server.service;

import java.util.List;

import com.sevenwonders.server.entity.user.User;

public class Table {
	
	private List<User> users;
	private int epoch;
	private int move;
	private List<Total> total;
	
	public void startGame() {
		
	}
	
	public void turn() {
		
	}
	
	public void war() {
		
	}
	
	public void nextEpoch() {
		
	}
	
	public void getResult() {
		
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
