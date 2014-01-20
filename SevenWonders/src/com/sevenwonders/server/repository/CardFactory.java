package com.sevenwonders.server.repository;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sevenwonders.server.entity.card.Card;

public interface CardFactory {
	List<Card> getCards(int playersNum) throws ParserConfigurationException, SAXException, IOException;

}
