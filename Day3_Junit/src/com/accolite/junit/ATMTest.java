/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 11, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package com.accolite.junit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ATMTest.
 */
//@RunWith(MockitoJUnitRunner.class)
public class ATMTest {

	/** The err content. */
	ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	/** The out content 1. */
	ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
	
	/** The out content. */
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/** The coin. */
	@Mock
	Coin coin;
	
	/** The atm. */
	ATM atm;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		atm = new ATM();
		coin = Mockito.mock(Coin.class);
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		System.setOut(null);
		System.setErr(null);
	}
	
	/**
	 * Vender test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void VenderTest() throws Exception {
		//into the branch -------   enabled is false, CV=0
		atm.vend();
		assertEquals("Not enough credit: add 75", outContent.toString().substring(0, 25));

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Mockito.when(coin.getValue()).thenReturn(75);
		atm.insert(coin);

		// into the branch -------  enabled is true and CV=75
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		atm.vend();
		assertEquals("Get your drink\rCurrent value = 0", outContent.toString().trim().replace("\n", ""));

	}
	
	/**
	 * Insert test.
	 */
	@Ignore
	@Test
	public void InsertTest() {
		// into the branch ------- invalid 
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
		Mockito.when(coin.getValue()).thenReturn(0);
		atm.insert(coin);
		assertEquals("illegal value", errContent.toString().substring(0, 13));

		// into the branch -------  currValue < 75
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Mockito.when(coin.getValue()).thenReturn(1);
		atm.insert(coin);
		assertEquals("Current value = 1", outContent.toString().substring(0, 17));

		// into the branch ------- currValue >= 75
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Mockito.when(coin.getValue()).thenReturn(100);
		atm.insert(coin);
		assertEquals("Current value = 101 (sufficient credit)", outContent.toString().substring(0, 39));

	}

	/**
	 * Return coins test.
	 */
	@Ignore
	@Test
	public void ReturnCoinsTest() {
		// into the branch ------- currVal==0
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));

		Mockito.when(coin.getValue()).thenReturn(0);
		atm.returnCoins();
		assertEquals("no coins to return", errContent.toString().substring(0, 18));

		//into the branch ------- else
		Mockito.when(coin.getValue()).thenReturn(1);
		atm.insert(coin);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		atm.returnCoins();
		assertEquals("Take your coins", outContent.toString().substring(0, 15));
	}



	/**
	 * Test exception.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testException() throws Exception {
		Mockito.when(coin.getValue()).thenReturn(-1);
		atm.insert(coin);

		atm.vend();

	}

}