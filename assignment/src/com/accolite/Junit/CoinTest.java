package com.accolite.Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(MockitoJUnitRunner.class)
public class CoinTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCoin() {
		Coin c = new Coin("xyz");
		assertEquals(c.getValue(),0);
		//if(c.getValue() != 0)
			//fail("It has failed,the value should be 0 and it is returning" + c.getValue());
		
	}

	@Test
	public void testGetValue() {
		
		Coin test = Mockito.mock(Coin.class);
		when(test.getValue()).thenReturn(45);
		assertEquals(test.getValue(),45);
		
		Coin c = new Coin("penny");
		assertEquals(c.getValue(),1);
	    c = new Coin("nickel");
		assertEquals(c.getValue(),5);
		c = new Coin("dime");
		assertEquals(c.getValue(),10);
		c = new Coin("quarter");
		assertEquals(c.getValue(),25);
		c = new Coin("halfdollar");
		assertEquals(c.getValue(),50);
		c = new Coin("silverdollar");
		assertEquals(c.getValue(),100);
		c = new Coin("kartik");
		assertEquals(c.getValue(),0);
	}

	@Test
	public void testToString() {
		Coin c = new Coin("penny");
		assertEquals(c.toString(),"1");
	    c = new Coin("nickel");
		assertEquals(c.toString(),"5");
		c = new Coin("dime");
		assertEquals(c.toString(),"10");
		c = new Coin("quarter");
		assertEquals(c.toString(),"25");
		c = new Coin("halfdollar");
		assertEquals(c.toString(),"50");
		c = new Coin("silverdollar");
		assertEquals(c.toString(),"100");
	}

}
