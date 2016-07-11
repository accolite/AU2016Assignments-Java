package com.accolite.jayesh.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinTest {
	Coin coin1 = new Coin("PENNY");
	Coin coin2 = new Coin("NICKEL");
	Coin coin3 = new Coin("DIME");
	Coin coin4 = new Coin("QUARTER");
	Coin coin5 = new Coin("HALFDOLLAR");
	Coin coin6 = new Coin("SILVERDOLLAR");
	Coin coin7 = new Coin("INVALID");

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

		assertEquals("PENNY must be 1", 1, coin1.getValue());
		assertEquals("NICKEL must be 5", 5, coin2.getValue());
		assertEquals("DIME must be 10", 10, coin3.getValue());
		assertEquals("QUARTER must be 25", 25, coin4.getValue());
		assertEquals("HALFDOLLAR must be 50", 50, coin5.getValue());
		assertEquals("SILVERDOLLAR must be 100", 100, coin6.getValue());
		assertEquals("INVALID must be 0", 0, coin7.getValue());
		assertEquals("NICKEL must be 5", 5, coin2.getValue());

		// fail("Not yet implemented");
	}

	@Test
	public void testGetValue() {
		assertEquals(1, coin1.getValue());
		assertEquals(5, coin2.getValue());
		assertEquals(10, coin3.getValue());
		assertEquals(25, coin4.getValue());
		assertEquals(50, coin5.getValue());
		assertEquals(100, coin6.getValue());
		assertEquals("INVALID must be ", 0, coin7.getValue());

		// fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		// fail("Not yet implemented");
		assertEquals(coin5.toString() + "must be 50", 50, coin5.getValue());
		Coin coin8 = new Coin(coin1.toString());
		assertEquals(coin8.toString() + "must be 1",1,coin8.getValue());

		
	}

}
