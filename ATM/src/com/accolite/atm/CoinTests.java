package com.accolite.atm;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinTests {

	@Test
	public void testToString(){
		Coin penny = new Coin("PENNY");
		assertEquals("Output of toString Penny must be 1","1",penny.toString());
		
		Coin nickel = new Coin("NICKEL");
		assertEquals("Output of toString Nickel must be 5","5",nickel.toString());
		
		Coin dime = new Coin("DIME");
		assertEquals("Output of toString Dime must be 10","10",dime.toString());
		
		Coin quarter = new Coin("QUARTER");
		assertEquals("Output of toString Quarter must be 25","25",quarter.toString());
		
		Coin halfdollar = new Coin("HALFDOLLAR");
		assertEquals("Output of toString Halfdollar must be 50","50",halfdollar.toString());
		
		Coin silverdollar = new Coin("SILVERDOLLAR");
		assertEquals("Output of toString Silverdollar must be 100","100",silverdollar.toString());
		
	}
	
	@Test 
	public void checkValues(){
		Coin penny = new Coin("PENNY");
		assertEquals("Value of Penny must be 1",1,penny.getValue());
		
		Coin nickel = new Coin("NICKEL");
		assertEquals("Value of Nickel must be 5",5,nickel.getValue());
		
		Coin dime = new Coin("DIME");
		assertEquals("Value of Dime must be 10",10,dime.getValue());
		
		Coin quarter = new Coin("QUARTER");
		assertEquals("Value of Quarter must be 25",25,quarter.getValue());
		
		Coin halfdollar = new Coin("HALFDOLLAR");
		assertEquals("Value of HalfDollar must be 50",50,halfdollar.getValue());
		
		Coin silverdollar = new Coin("SILVERDOLLAR");
		assertEquals("Value of SilverDollar must be 100",100,silverdollar.getValue());
		
	}
	
	@Test
	public void checkInvalidCoinValue(){
		Coin invalid = new Coin("adfsagsdgjshb");
		assertEquals("Value of an Invalid Coin must be 0", 0, invalid.getValue());
	}
	
}
