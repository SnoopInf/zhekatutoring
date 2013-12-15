package edu.zheka.functions;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MathFunTest {

MathFun math;
	
	@Before
	public void init() {
		math = new MathFun();
	}
	
	@Test
	public void testFactorial() {
		assertEquals(math.factorial(0), 1);
		assertEquals(math.factorial(1), 1);
		
		assertEquals(math.factorial(7), 5040);
	}
	
	@Test
	public void testFibonachi() {
		assertEquals(math.fibonachi(0), 0);
		assertEquals(math.fibonachi(1), 1);
		
		assertEquals(math.fibonachi(7), 13);
	}

}
