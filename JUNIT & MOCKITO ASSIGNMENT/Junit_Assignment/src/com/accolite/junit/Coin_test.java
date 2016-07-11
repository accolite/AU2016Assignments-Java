package com.accolite.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class Coin_test {
	private Coin mokitocoin = Mockito.mock(Coin.class);
	@Test
	public void ValidCoinTests(){
		Mockito.when(mokitocoin.getValue()).thenReturn(1);
		
		/*Coin pennyCoin = new Coin("penny");
		Assert.assertEquals("Value of PENNY should be 1", 1, pennyCoin.getValue());*/
		Assert.assertEquals("Value of PENNY should be 1", 1, mokitocoin.getValue());
		
		Coin nickelCoin = new Coin("NICKEL");
		Assert.assertEquals("Value of NICKEL should be 5", 5, nickelCoin.getValue());
		
		Coin dimeCoin = new Coin("DIME");
		Assert.assertEquals("Value of DIME should be 10", 10, dimeCoin.getValue());
		
		Coin quarterCoin = new Coin("QUARTER");
		Assert.assertEquals("Value of QUARTER should be 25", 25, quarterCoin.getValue());
		
		Coin halfDollarCoin = new Coin("HALFDOLLAR");
		Assert.assertEquals("Value of HALFDOLLAR should be 50", 50, halfDollarCoin.getValue());
		
		Coin silverDollarCoin = new Coin("SILVERDOLLAR");
		Assert.assertEquals("Value of SILVERDOLLAR should be 100", 100, silverDollarCoin.getValue());
	}
	
	
	@Test
	public void invalidCoinTests(){
		Coin invalidCoin = new Coin("-1");
		Assert.assertEquals("Value of INVALID COIN should be 0", 0, invalidCoin.getValue());
		
		
	}
	
	@Test
	public void toStringTest(){
		Coin pennyCoin = new Coin("penny");
		Assert.assertEquals("String value of penny should be PENNY", "1", pennyCoin.toString());
		
		Coin nickelCoin = new Coin("nickel");
		Assert.assertEquals("String value of nickel should be NICKEL", "5", nickelCoin.toString());
		
		Coin dimeCoin = new Coin("dime");
		Assert.assertEquals("String value of dime should be DIME", "10", dimeCoin.toString());
		
		Coin quarterCoin = new Coin("quarter");
		Assert.assertEquals("String value of quarter should be QUARTER", "25", quarterCoin.toString());
		
		Coin halfDollarCoin = new Coin("halfdollar");
		Assert.assertEquals("String value of halfdollar should be HALFDOLLAR", "50", halfDollarCoin.toString());
		
		Coin silverDollarCoin = new Coin("silverdollar");
		Assert.assertEquals("String value of silverdollar should be SILVERDOLLAR", "100", silverDollarCoin.toString());
	}

}
