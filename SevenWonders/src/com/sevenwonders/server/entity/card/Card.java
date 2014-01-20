package com.sevenwonders.server.entity.card;

import java.io.Serializable;
import java.util.Map;

public interface Card extends Serializable {
	Map<Resource, Integer> getNecessaryResources();
	String getName();
	String getPrev();
	String getNext();
	int getEpoch();
	int getPlayers();
	String getImageUrl();
}
