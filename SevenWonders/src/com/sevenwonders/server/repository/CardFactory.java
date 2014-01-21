package com.sevenwonders.server.repository;

import java.util.List;

import com.sevenwonders.server.entity.card.Card;

public interface CardFactory {
	List<Card> getCards(int playersNum);
}
