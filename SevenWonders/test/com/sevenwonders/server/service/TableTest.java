package com.sevenwonders.server.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.sevenwonders.server.entity.user.User;
import com.sevenwonders.server.exceptions.EpochOutOfBoundsException;
import com.sevenwonders.server.service.Table;
import com.sevenwonders.server.entity.city.City;
import com.sevenwonders.server.entity.city.Mode;


public class TableTest {
	User user1;
	User user2;
	User user3;
	
	City city1;
	City city2;
	City city3;
	
	Table table;
	
	@Before
	public void setup() {
		user1 = mock(User.class);
		user2 = mock(User.class);
		user3 = mock(User.class);
		

		city1 = mock(City.class);
		city2 = mock(City.class);
		city3 = mock(City.class);
		
		when(user1.getRightNeighbor()).thenReturn(user2);
		when(user1.getLeftNeighbor()).thenReturn(user3);

		when(user2.getRightNeighbor()).thenReturn(user3);
		when(user2.getLeftNeighbor()).thenReturn(user1);

		when(user3.getRightNeighbor()).thenReturn(user1);
		when(user3.getLeftNeighbor()).thenReturn(user2);
		
		when(user1.getCity()).thenReturn(city1);
		when(user2.getCity()).thenReturn(city2);
		when(user3.getCity()).thenReturn(city3);
		
		

		table = new Table();
	}
	
	@Test
	public void testStartGame() {
		user1 = new User();
		user2 = new User();
		user3 = new User();
		
		List<User> users  = new ArrayList<>(3);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		table.setUsers(users);
		
		table.startGame(Mode.A);
		
		assertNotNull(user1.getLeftNeighbor());
		assertNotNull(user1.getRightNeighbor());
		assertNotNull(user1.getCity());
		
		assertNotNull(user2.getLeftNeighbor());
		assertNotNull(user2.getRightNeighbor());
		assertNotNull(user2.getCity());
		
		assertNotNull(user3.getLeftNeighbor());
		assertNotNull(user3.getRightNeighbor());
		assertNotNull(user3.getCity());
		
	}
	//Simple
	@Test
	public void testTurn() {
		table.setMove(1);
		table.turn();
		assertEquals(2, table.getMove());
	}
	
	//Simple - new epoch
	@Test
	public void testTurnLast() {
		table.setEpoch(0);
		table.setMove(6);
		table.turn();
		assertEquals(0, table.getMove());
		assertEquals(1, table.getEpoch());
	}
	
	@Test
	public void testWarWithOneLeader() {
		when(city1.getWarPoints()).thenReturn(1);
		when(city2.getWarPoints()).thenReturn(0);
		when(city3.getWarPoints()).thenReturn(0);
		
		table.setEpoch(0);
		table.war();
		
		verify(city1).setWarPointsWin(1);
		verify(city2).setWarPointsLose(1);
		verify(city3).setWarPointsLose(1);
		
		table.setEpoch(1);
		table.war();
		
		verify(city1).setWarPointsWin(3);
		verify(city2).setWarPointsLose(1);
		verify(city3).setWarPointsLose(1);
		
		table.setEpoch(2);
		table.war();
		
		verify(city1).setWarPointsWin(5);
		verify(city2).setWarPointsLose(1);
		verify(city3).setWarPointsLose(1);
		
	}
	
	@Test
	public void testWarWithTwoLeaders() {
		when(city1.getWarPoints()).thenReturn(1);
		when(city2.getWarPoints()).thenReturn(1);
		when(city3.getWarPoints()).thenReturn(0);
		
		table.setEpoch(0);
		table.war();
		
		verify(city1).setWarPointsWin(1);
		verify(city2).setWarPointsWin(1);
		verify(city3).setWarPointsLose(1);
		
		table.setEpoch(1);
		table.war();
		
		verify(city1).setWarPointsWin(3);
		verify(city2).setWarPointsWin(3);
		verify(city3).setWarPointsLose(1);
		
		table.setEpoch(2);
		table.war();
		
		verify(city1).setWarPointsWin(5);
		verify(city2).setWarPointsWin(5);
		verify(city3).setWarPointsLose(1);
		
	}
	
	@Test
	public void testWarWithDifferentForces() {
		when(city1.getWarPoints()).thenReturn(2);
		when(city2.getWarPoints()).thenReturn(1);
		when(city3.getWarPoints()).thenReturn(0);
		
		table.setEpoch(0);
		table.war();
		
		verify(city1).setWarPointsWin(1);
		verify(city2).setWarPointsWin(1);
		verify(city2).setWarPointsLose(1);
		verify(city3).setWarPointsLose(1);
		
		table.setEpoch(1);
		table.war();
		
		verify(city1).setWarPointsWin(3);
		verify(city2).setWarPointsWin(3);
		verify(city2).setWarPointsLose(1);
		verify(city3).setWarPointsLose(1);
		
		table.setEpoch(2);
		table.war();
		
		verify(city1).setWarPointsWin(5);
		verify(city2).setWarPointsWin(5);
		verify(city2).setWarPointsLose(1);
		verify(city3).setWarPointsLose(1);
		
	}
	
	//Simple
	@Test
	public void testNextEpoch() {
		table.setEpoch(1);
		table.nextEpoch();
		assertEquals(2, table.getEpoch());
	}
	
	//Simple - epoch out of bounds
	@Test(expected = EpochOutOfBoundsException.class)
	public void testNextEpochOutOfBounds() {
		table.setEpoch(2);
		table.nextEpoch();
		assertEquals(2, table.getEpoch());
	}
	
	@Test
	public void testGetResult() {
		assertEquals(1, 1);
	}


}
