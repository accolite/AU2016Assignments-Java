/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 11, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.accolite.atm;

import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
// TODO: Auto-generated Javadoc

/**
 * The Class CoinTest.
 */
@RunWith(MockitoJUnitRunner.class)
/**
 * @author Udit Mehata
 *
 */
public class CoinTest {

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.accolite.atm.Coin#Coin(java.lang.String)}.
	 */
	@Test
	public void testCoin() 
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.accolite.atm.Coin#getValue()}.
	 */
	@Test
	public void testGetValue() 
	{ 
		Coin c = new Coin("SILVERDOLLAR");
		assertEquals( "Get Value for Coin succeeded for SILVERDOLLAR with value 100 :", 100, c.getValue() );
		c = new Coin("HALFDOLLAR");
		assertEquals( "Get Value for Coin succeeded for HALFDOLLAR with value 50 :", 50, c.getValue() );
		c = new Coin("QUARTER");
		assertEquals( "Get Value for Coin succeeded for QUARTER with value 25 :", 25, c.getValue() );
		c = new Coin("DIME");
		assertEquals( "Get Value for Coin succeeded for DIME with value 10:", 10, c.getValue() );
		c = new Coin("NICKEL");
		assertEquals( "Get Value for Coin for NICKEL for value 5 :", 5, c.getValue() );
		c = new Coin("PENNY");
		assertEquals( "Get Value for Coin for PENNY for value 1 :", 1, c.getValue() );
	    c = new Coin("NAMELESSCOIN");
		assertEquals( "Tried creating a coin called NAMELESSCOIN. Get Value returned Invalid", 0, c.getValue() );
	}

	/**
	 * Test method for {@link com.accolite.atm.Coin#toString()}.
	 */
	/**
	 * 
	 */
	@Test
	public void testToString() 
	{
		Coin c = new Coin("SILVERDOLLAR");
		assertEquals( "toString() for Coin succeeded for SILVERDOLLAR with value 100:", "100", c.toString() );
		c = new Coin("HALFDOLLAR");
		assertEquals( "toString() for Coin succeeded for HALFDOLLAR with value 50:", "50", c.toString() );
		c = new Coin("QUARTER");
		assertEquals( "toString() for Coin succeeded for QUARTER with value 25:", "25",  c.toString() );
		c = new Coin("DIME");
		assertEquals( "toString() for Coin succeeded for DIME with value 10:", "10", c.toString() );
		c = new Coin("NICKEL");
		assertEquals( "toString() for Coin succeeded for NICKEL for value 5 :", "5",  c.toString()  );
		c = new Coin("PENNY");
		assertEquals( "toString() for Coin succeeded for PENNY for value 1 :", 1, c.getValue() );
	    c = new Coin("NAMELESSCOIN");
		assertEquals( "Tried creating a coin called NAMELESSCOIN. Get Value returned Invalid:", 0, c.getValue() );
	}

}
