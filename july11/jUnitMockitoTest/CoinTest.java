/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 11, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.junitatm;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * The Test for Class Coin.
 */
public class CoinTest {

	
	/**
	 * Test get value method
	 */
	@Test
	public void testGetValue() {
		
		/* Default or some random value */
		Coin coin = new Coin("something");
		assertEquals("Something is invalid",coin.getValue(),0); 
		
		/* Penny case */
		coin = new Coin("penny");
		assertEquals("Penny is 1",coin.getValue(),1);

		/* Nickel case */
		coin = new Coin("niCkel");
		assertEquals("Nickel is 5",coin.getValue(),5);
		
		/* Dime case */
		coin = new Coin("DIME");
		assertEquals("Dime is 10",coin.getValue(),10);
		
		/* Quarter case */
		coin = new Coin("quarTER");
		assertEquals("Quarter is 25",coin.getValue(),25);
		
		/* HalfDollar case */
		coin = new Coin("HALFdollar");
		assertEquals("HalfDollar is 50",coin.getValue(),50);
		
		/* SilverDollar case */
		coin = new Coin("SilverDollar");
		assertEquals("SilverDollar is 100",coin.getValue(),100);	
	}

	/**
	 * Test to string method.
	 */
	@Test
	public void testToString() {
		/* Default or some random value */
		Coin coin = new Coin("something");
		assertEquals("Something is invalid in Text",coin.toString(),"0"); 

		/* Penny case */
		coin = new Coin("penny");
		assertEquals("Penny is 1 in Text",coin.toString(),"1");
		

		/* Nickel case */
		coin = new Coin("niCkel");
		assertEquals("Nickel is 5 in Text",coin.toString(),"5");
		

		/* Dime case */
		coin = new Coin("DIME");
		assertEquals("Dime is 10 in Text",coin.toString(),"10");
		

		/* Quarter case */
		coin = new Coin("quarTER");
		assertEquals("Quarter is 25 in Text",coin.toString(),"25");
		

		/* HalfDollar case */
		coin = new Coin("HALFdollar");
		assertEquals("HalfDollar is 50 in Text",coin.toString(),"50");
		

		/* SilverDollar case */
		coin = new Coin("SilverDollar");
		assertEquals("SilverDollar is 100 in Text",coin.toString(),"100");
		
	}

}
