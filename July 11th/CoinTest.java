/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 11, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.UnitTesting;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class CoinTest.
 */
public class CoinTest {

	/** The coin 8. */
	Coin coin1,coin2,coin3,coin4,coin5,coin6,coin7,coin8,coin9;
	
	/**
	 * Test case 1 for Coin1
	 */
	
	@Test
	public void testCoin1() {
		coin1=new Coin("PENNY");
		int coin_value=coin1.getValue();
		assertEquals("Checking PENNY",1,coin_value);
		String coin=coin1.toString();
		assertEquals("Checking PENNY","1",coin);
	}
	
	/**
	 * Test case 2 for Coin2
	 */
	@Test
	public void testCoin2() {
		coin2=new Coin("NICKEL");
		int coin_value=coin2.getValue();
		assertEquals("Checking NICKEL",5,coin_value);
		String coin=coin2.toString();
		assertEquals("Checking NICKEL","5",coin);
		
	}
	
	/**
	 * Test case 3 for Coin3
	 */
	
	@Test
	public void testCoin3() {
		coin3=new Coin("DIME");
		int coin_value=coin3.getValue();
		assertEquals("Checking DIME",10,coin_value);
		String coin=coin3.toString();
		assertEquals("Checking DIME","10",coin);
		
	}
	
	/**
	 * Test case 4 for Coin4
	 */
	@Test
	public void testCoin4() {
		coin4=new Coin("QUARTER");
		int coin_value=coin4.getValue();
		assertEquals("Checking QUARTER",25,coin_value);
		String coin=coin4.toString();
		assertEquals("Checking QUARTER","25",coin);
		
	}
	
	/**
	 * Test case 5 for Coin5
	 */
	@Test
	public void testCoin5() {
		coin5=new Coin("HALFDOLLAR");
		int coin_value=coin5.getValue();
		assertEquals("Checking HALFDOLLAR",50,coin_value);
		String coin=coin5.toString();
		assertEquals("Checking HALFDOLLAR","50",coin);
		
	}
	
	/**
	 * Test case 6 for Coin6
	 */
	
	@Test
	public void testCoin6() {
		coin6=new Coin("SILVERDOLLAR");
		int coin_value=coin6.getValue();
		assertEquals("Checking SILVERDOLLAR",100,coin_value);
		String coin=coin6.toString();
		assertEquals("Checking SILVERDOLLAR","100",coin);
		
	}
	
	/**
	 * Test case 7 for Coin7
	 */
	@Test
	public void testCoin7() {
		coin7=new Coin("INVALID");
		int coin_value=coin7.getValue();
		assertEquals("INVALID Coin",0,coin_value);
		String coin=coin7.toString();
		assertEquals("INVALID Coin","0",coin);
		
	}
	
	/**
	 * Test case 8 for Coin8
	 */
	@Test
	public void testCoin8() {
		coin8=new Coin("RUPEE");
		int coin_value=coin8.getValue();
		assertEquals("INVALID Coin",0,coin_value);
		String coin=coin8.toString();
		assertEquals("INVALID Coin","0",coin);
		
	}
	
	/**
	 * Test case 9 for Coin9
	 * Used Ignore
	 */
	
	//@Ignore
	@Test
	public void testCoin9() {
		coin9=new Coin("DOLLAR");
		int coin_value=coin9.getValue();
		assertEquals("INVALID Coin",0,coin_value);
		String coin=coin9.toString();
		assertEquals("INVALID Coin","0",coin);
		
	}
}