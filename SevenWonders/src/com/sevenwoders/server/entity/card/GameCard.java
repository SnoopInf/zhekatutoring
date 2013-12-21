package com.sevenwoders.server.entity.card;

import java.util.Map;

public interface GameCard {
	Map<Resource, Integer> getNecessaryResources();
	String getName();
	String getPrev();
	String getNext();
	int getEpoch();
	int getPlayers();
}
