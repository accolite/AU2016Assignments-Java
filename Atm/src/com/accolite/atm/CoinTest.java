/**
 * 
 */
package com.accolite.atm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Diksha Garg
 *
 */
public class CoinTest {
	
	
	Coin coin1=new Coin("ABC");
	Coin coin2=new Coin("PENNY");
	Coin coin3=new Coin("NICKEL");
	Coin coin4=new Coin("DIME");
	Coin coin5=new Coin("QUARTER");
	Coin coin6=new Coin("HALFDOLLAR");
	Coin coin7=new Coin("SILVERDOLLAR");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.accolite.atm.Coin#Coin(java.lang.String)}.
	 */
	@Test
	public void testCoin() {

		
		
	}

	/**
	 * Test method for {@link com.accolite.atm.Coin#getValue()}.
	 */
	@Test
	public void testGetValue() {

		assertEquals(coin1.getValue(),0);
		assertEquals(coin2.getValue(),1);
		assertEquals(coin3.getValue(),5);
		assertEquals(coin4.getValue(),10);
		assertEquals(coin5.getValue(),25);
		assertEquals(coin6.getValue(),50);
		assertEquals(coin7.getValue(),100);
		
	}

	/**
	 * Test method for {@link com.accolite.atm.Coin#toString()}.
	 */
	@Test
	public void testToString() {
		
		assertEquals(coin1.toString(),"0");
		assertEquals(coin2.toString(),"1");
		assertEquals(coin3.toString(),"5");
		assertEquals(coin4.toString(),"10");
		assertEquals(coin5.toString(),"25");
		assertEquals(coin6.toString(),"50");
		assertEquals(coin7.toString(),"100");
		
	}

	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
	

}
