package com.sevenwonders.server.entity.city;

public class Giza extends AbstractCity {

	public Giza(Mode mode) {
		super(mode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getWarPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWarPointsWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWarPointsLose() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWarPointsWin(int points) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWarPointsLose(int points) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getImageUrl() {
		return "images/cities/A/Giza.jpg";
	}

	@Override
	public String getName() {
		return "Giza";
	}

}
