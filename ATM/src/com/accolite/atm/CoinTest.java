package com.accolite.atm;

import org.junit.Assert;
import org.junit.Test;

public class CoinTest {

	@Test
	public void ValidCoinTests(){
		Coin pennyCoin = new Coin("penny");
		Assert.assertEquals("Value of PENNY should be 1", 1, pennyCoin.getValue());
		
		Coin nickelCoin = new Coin("nickel");
		Assert.assertEquals("Value of NICKEL should be 5", 5, nickelCoin.getValue());
		
		Coin dimeCoin = new Coin("dime");
		Assert.assertEquals("Value of DIME should be 10", 10, dimeCoin.getValue());
		
		Coin quarterCoin = new Coin("quarter");
		Assert.assertEquals("Value of QUARTER should be 25", 25, quarterCoin.getValue());
		
		Coin halfDollarCoin = new Coin("halfdollar");
		Assert.assertEquals("Value of HALFDOLLAR should be 50", 50, halfDollarCoin.getValue());
		
		Coin silverDollarCoin = new Coin("silverdollar");
		Assert.assertEquals("Value of SILVERDOLLAR should be 100", 100, silverDollarCoin.getValue());
	}
	
	@Test
	public void invalidCoinTests(){
		try{
			Coin invalidCoin = new Coin("Rupee");
			Assert.assertEquals("Value of INVALID COIN should be 0", 0, invalidCoin.getValue());
			
			invalidCoin = new Coin(null);
			Assert.assertEquals("Value of INVALID COIN should be 0", 0, invalidCoin.getValue());
		}
		catch(NullPointerException npe){
			Assert.fail("Null pointer exception");
		}
	}
	
	@Test
	public void validToStringTest(){
		Coin pennyCoin = new Coin("penny");
		Assert.assertEquals("String value of penny should be 1", "1", pennyCoin.toString());
		
		Coin nickelCoin = new Coin("nickel");
		Assert.assertEquals("String value of nickel should be 5", "5", nickelCoin.toString());
		
		Coin dimeCoin = new Coin("dime");
		Assert.assertEquals("String value of dime should be 10", "10", dimeCoin.toString());
		
		Coin quarterCoin = new Coin("quarter");
		Assert.assertEquals("String value of quarter should be 25", "25", quarterCoin.toString());
		
		Coin halfDollarCoin = new Coin("halfdollar");
		Assert.assertEquals("String value of halfdollar should be 50", "50", halfDollarCoin.toString());
		
		Coin silverDollarCoin = new Coin("silverdollar");
		Assert.assertEquals("String value of silverdollar should be 100", "100", silverDollarCoin.toString());
	}
	
	@Test
	public void invalidToStringTest(){
		try{
			Coin invalidCoin = new Coin("Rupee");
			Assert.assertEquals("String value of INVALID COIN should be 0", "0", invalidCoin.toString());
	 		
			invalidCoin = new Coin(null);
			Assert.assertEquals("String value of INVALID COIN should be 0", "0", invalidCoin.toString());
		}
		catch(NullPointerException e){
			Assert.fail("Null pointer exception");
		}
	}
	
}
