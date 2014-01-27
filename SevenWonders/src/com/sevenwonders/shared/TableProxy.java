package com.sevenwonders.shared;

import java.io.Serializable;
import java.util.List;

public class TableProxy implements Serializable {
	private static final long serialVersionUID = -3303327682650569559L;
	private List<UserProxy> users;
	
	public TableProxy() {
		
	}
	
	public TableProxy(List<UserProxy> users) {
		this.users = users;
	}
	
	public List<UserProxy> getUsers() {
		return users;
	}
	public void setUsers(List<UserProxy> users) {
		this.users = users;
	}
	
	

}
