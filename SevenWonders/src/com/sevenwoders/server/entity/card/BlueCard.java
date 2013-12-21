package com.sevenwoders.server.entity.card;


public class BlueCard extends AbstractCard {
	
	public BlueCard(String nm, int ep, int pln) {
		super(nm, ep, pln);
	}
	private int Glory;
	
	public int getGlory() {
		return Glory;
	}
	public void setGlory(int glory) {
		this.Glory = glory;
	}
}
