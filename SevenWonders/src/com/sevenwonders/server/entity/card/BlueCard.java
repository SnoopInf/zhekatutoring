package com.sevenwonders.server.entity.card;


public class BlueCard extends AbstractCard {
	
	public BlueCard(String nm, int ep, int pln) {
		super(nm, ep, pln);
	}
	private int glory;
	
	public int getGlory() {
		return glory;
	}
	public void setGlory(int glory) {
		this.glory = glory;
	}
}
