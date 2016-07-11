package com.accolite.Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinTest {
	COIN coin01 = new COIN("Penny");
	COIN coin02 = new COIN("Nickel");
	COIN coin03 = new COIN("Dime");
	COIN coin04 = new COIN("Quarter");
	COIN coin05 = new COIN("Halfdollar");
	COIN coin06 = new COIN("Silverdollar");
	COIN coin07 = new COIN("CHELSEA");

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
	public void test() {
		
		assertEquals("Penny should be 1",1,coin01.getValue());
		assertEquals("Nickel should be 5",5,coin02.getValue());
		assertEquals("Dime should be 10",10,coin03.getValue());
		assertEquals("Quarter should be 25",25,coin04.getValue());
		assertEquals("Halfdollar should be 50",50,coin05.getValue());
		assertEquals("Silverdollar should be 100",100,coin06.getValue());
		assertEquals("CHELSEA should be invalid",0,coin07.getValue());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void getValuetest(){
		assertEquals(10,coin03.getValue());
		assertEquals("Nickel should be 5",5,coin02.getValue());
		assertEquals("CHELSEA should be invalid",0,coin07.getValue());
	} 
	
	@Test
	public void StringTotest(){
		assertEquals(coin04.toString() + "should be 25",25,coin04.getValue());
		assertEquals(coin07.toString() + "should be 0",0,coin07.getValue());
		
	}

}
