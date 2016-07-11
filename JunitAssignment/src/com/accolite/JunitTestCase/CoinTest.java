package com.accolite.JunitTestCase;

import static org.junit.Assert.*;
import org.junit.*;

public class CoinTest {
	
	 @Test
	 public void testCoinConstructer()
	 {
		 Coin coin1 = new Coin("Penny");
		 assertEquals(1, coin1.getValue());
		 Coin coin2 = new Coin("Nickel");
		 assertEquals(5, coin2.getValue());
		 Coin coin3 = new Coin("dime");
		 assertEquals(10, coin3.getValue());
		 Coin coin4 = new Coin("quarter");
		 assertEquals(25, coin4.getValue());
		 Coin coin5 = new Coin("halfdollar");
		 assertEquals(50, coin5.getValue());
		 Coin coin6 = new Coin("Silverdollar");
		 assertEquals(100, coin6.getValue());
		 Coin coin7 = new Coin("INVALID");
		 assertEquals(0, coin7.getValue());
	 }
	 
	 @Test
	 public void testToString()
	 {
		 Coin coin1 = new Coin("Penny");
		 String returnedValue = coin1.toString();
		 assertEquals("1", returnedValue);
		 
		 Coin coin2 = new Coin("Nickel");
		 returnedValue = coin2.toString();
		 assertEquals("5", returnedValue);
		 
		 Coin coin3 = new Coin("dime");
		 returnedValue = coin3.toString();
		 assertEquals("10", returnedValue);
		 
		 Coin coin4 = new Coin("quarter");
		 returnedValue = coin4.toString();
		 assertEquals("25", returnedValue);
		 
		 Coin coin5 = new Coin("halfdollar");
		 returnedValue = coin5.toString();
		 assertEquals("50", returnedValue);
		 
		 Coin coin6 = new Coin("Silverdollar");
		 returnedValue = coin6.toString();
		 assertEquals("100", returnedValue);
		 
		 Coin coin7 = new Coin("INVALID");
		 returnedValue = coin7.toString();
		 assertEquals("0", returnedValue);
	 }
}
