package com.sevenwoders.server.entity.city;

public interface City {

	//посчитать по красным картам
	int getWarPoints();
	
	int getWarPointsWin();
	int getWarPointsLose();
	
	void setWarPointsWin(int points);
	void setWarPointsLose(int points);
}
