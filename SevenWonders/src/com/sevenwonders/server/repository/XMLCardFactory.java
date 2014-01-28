package com.sevenwonders.server.repository;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sevenwonders.server.entity.card.BlueCard;
import com.sevenwonders.server.entity.card.Card;
import com.sevenwonders.server.entity.card.Resource;
import com.sevenwonders.server.exceptions.CardsGenerationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



public class XMLCardFactory implements CardFactory {
	private static String cardName;
	private static int epoch;
	private static int glory;
	private static int goldCost;
	private static int players;
	List<Card> cardList = new ArrayList<Card>();

	public void TestWay() {
		File f = new File("cards.xml");
		System.out.println(f.getAbsolutePath());
	}

	public List<Card> getCards(int playersNum , int epoch) {
		
		// D:/workspaceE/zhekatutoringO/SevenWonders/src/com/sevenwonders/server/repository/
		
		try {
		File fXmlFile = new File("Cards.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		dBuilder = dbFactory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("card");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
			 

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				cardName = eElement.getElementsByTagName("name").item(0).getTextContent();
				epoch = Integer.parseInt(eElement.getElementsByTagName("epoch").item(0).getTextContent());
				goldCost = Integer.parseInt(eElement.getElementsByTagName("costgold").item(0).getTextContent());
				glory = Integer.parseInt(eElement.getElementsByTagName("gloryamount").item(0).getTextContent());

				if ((players <= playersNum)&(this.epoch == epoch)){
				BlueCard singleCard = new BlueCard(cardName , epoch , 3);
				singleCard.setGlory(glory);
				singleCard.setRes(Resource.Money, goldCost);
				cardList.add(singleCard);
				}
			}
		}
	// TODO shuffle	
		}catch (ParserConfigurationException | SAXException | IOException e) {
			throw new CardsGenerationException(e.getMessage(), e);
		}
		Collections.shuffle(cardList);
		return cardList;
	}

}
