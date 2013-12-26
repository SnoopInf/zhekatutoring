package com.sevenwonders.server.repository;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLCardFactory {
	public static void main(String argv[]) {
	try {
		 
		File fXmlFile = new File("D:/workspaceE/zhekatutoringO/SevenWonders/src/com/sevenwonders/server/repository/Cards.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	 
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
	 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName("card");
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				System.out.println("card id : "+ eElement.getAttribute("id"));
				System.out.println("type : " + eElement.getElementsByTagName("type").item(0).getTextContent());
				System.out.println("epoch : " + eElement.getElementsByTagName("epoch").item(0).getTextContent());
				System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("cost gold : " + eElement.getElementsByTagName("costgold").item(0).getTextContent());
				System.out.println("glory amount : " + eElement.getElementsByTagName("gloryamount").item(0).getTextContent());
	 
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
}
}
