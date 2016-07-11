package com.accolite.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinTest {

	Coin coin;
	

	@Test
	public void testGetValue() {
		coin=new Coin("PENNY");
		assertEquals("Penny must be equal to 1",1,coin.getValue());
		
		coin=new Coin("NICKEL");
		assertEquals("Nickel must be equal to 5",5,coin.getValue());
		
		coin=new Coin("DIME");
		assertEquals(" Dime must be equal to 10",10,coin.getValue());
		
		coin=new Coin("QUARTER");
		assertEquals("Quarter must be equal to 25",25,coin.getValue());
		
		coin=new Coin("HALFDOLLAR");
		assertEquals(" Halfdollar must be equal to 50",50,coin.getValue());
		
		coin=new Coin("SILVERDOLLAR");
		assertEquals("Silverdollar must be equal to 100",100,coin.getValue());
		
		coin=new Coin("INVALID");
		assertEquals("Invalid",0,coin.getValue());
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		coin=new Coin("PENNY");
		assertEquals("Penny must be equal to 1","1",coin.toString());
		
		coin=new Coin("NICKEL");
		assertEquals("Nickel must be equal to 5","5",coin.toString());
		
		coin=new Coin("DIME");
		assertEquals("Dime must be equal to 10","10",coin.toString());
		
		coin=new Coin("QUARTER");
		assertEquals("Quarter must be equal to 25","25",coin.toString());
		
		coin=new Coin("HALFDOLLAR");
		assertEquals("Halfdollar must be equal to 50","50",coin.toString());
		
		coin=new Coin("SILVERDOLLAR");
		assertEquals("Silverdollar must be equal to 100","100",coin.toString());
		
		coin=new Coin("INVALID");
		assertEquals("Invalid","0",coin.toString());
		//fail("Not yet implemented");
	}

}
