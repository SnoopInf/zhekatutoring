package com.sevenwonders.server.entity.card;

public class RedCard extends AbstractCard{

	public RedCard() {
		super();
	}
	
	public int getMillitary(){
		return super.buns.get(SGMpoints.millitary);
	}
	
	public void setMillitary(int millitary){
		super.buns.put(SGMpoints.millitary, millitary);
	}

}
