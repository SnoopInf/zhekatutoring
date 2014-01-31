package com.sevenwonders.server.entity.city;

import java.io.Serializable;

import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.card.Resource;
import com.sevenwonders.server.entity.card.SGMpoints;

public interface City extends Serializable {

	//?????????????????? ???? ?????????????? ????????????
	int getWarPoints();
	
	int getWarPointsWin();
	int getWarPointsLose();
	
	void setWarPointsWin(int points);
	void setWarPointsLose(int points);
	
	String getImageUrl();
	String getName();

	void setResources(Resource res , int value);
	void build(Card card);
	void setBugs(SGMpoints bugs , int value);
	int getAmount (Resource res);
	 
}
