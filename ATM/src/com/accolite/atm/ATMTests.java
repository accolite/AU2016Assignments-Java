/**
 * 
 */
package com.accolite.atm;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Saumyadeep Tarafdar
 *
 */
public class ATMTests {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	    System.setOut(null);
	    System.setErr(null);
	}

	/**
	 * Test Case Description : Insert Coin With a Value high enough to enable a purchase
	 */
	
	@Test
	public void testValidCoinInsertWithCostGreatherThanCOST() {
		Coin silverDollar = new Coin("SILVERDOLLAR");
		ATM atm = new ATM();
		atm.insert(silverDollar);
		assertEquals("Current value = 100 (sufficient credit)",outContent.toString().trim());
	}

	/**
	 * Test Case Description : Insert Coin With a Value which is lower that COST
	 */
	
	@Test
	public void testValidCoinInsertWithCostLessThanCOST() {
		Coin nickel = new Coin("NICKEL");
		ATM atm = new ATM();
		atm.insert(nickel);
		assertEquals("Current value = 5",outContent.toString().trim());
	}
	
	/**
	 * Test Case Description : Insert Invalid Coin
	 */

	@Test
	public void testInvalidCoinInsert() {
		Coin invalidCoin = new Coin("NODENOMINATION");
		ATM atm = new ATM();
		atm.insert(invalidCoin);
		assertEquals("Expected output is illegal value","illegal value",errContent.toString().trim());
	}
	/**
	 * Test Case Description : No Coins to return
	 */
	
	@Test
	public void testReturnCoinsWhenCurrvalueis0() {
		ATM atm = new ATM();
		atm.returnCoins();
		assertEquals("no coins to return", errContent.toString().trim());
	}

	/**
	 * Test Case Description : Returning some coind
	 */
	@Test
	
	public void testReturnCoinsWhenCurrvalueisNot0() {
		Coin penny = new Coin("PENNY");
		ATM atm = new ATM();
		atm.insert(penny);
		outContent.reset();
		atm.returnCoins();
		assertEquals("Take your coins", outContent.toString().trim());
	}
	
	/**
	 * Test Case Description : Get a drink
	 * @throws Exception 
	 */
	
	@Test
	public void testVendGetDrink() throws Exception {
		Coin silverDollar = new Coin("SILVERDOLLAR");
		ATM atm = new ATM();
		atm.insert(silverDollar);
		outContent.reset();
		atm.vend();
		String actual = "Get your drink\nCurrent value = 25";
		String expected =  outContent.toString().trim();
		
		actual = actual.replace("\r", "");
		expected = expected.replace("\r", "");
		
		assertEquals(actual, expected);

	}
	/**
	 * Test Case Description : Insufficient funds for drinks
	 * @throws Exception 
	 */
	
	@Test
	public void testVendGetDrinkNoMoreMoney() throws Exception {
		Coin halfdollar = new Coin("HALFDOLLAR");
		Coin quarter = new Coin("QUARTER");
		ATM atm = new ATM();
		atm.insert(halfdollar);
		atm.insert(quarter);
		outContent.reset();
		atm.vend();
		String actual = "Get your drink\nCurrent value = 0";
		String expected =  outContent.toString().trim();
		
		actual = actual.replace("\r", "");
		expected = expected.replace("\r", "");
		
		assertEquals(actual, expected);
	}
	
	/**
	 * Test Case Description : No money for a drink
	 * @throws Exception 
	 */
	
	@Test
	public void testVendNoGetDrinkBecauseZeroMoney() throws Exception {
		ATM atm = new ATM();
		atm.vend();
		assertEquals("Not enough credit: add 75", outContent.toString().trim());
	}
	
	/**
	 * Test Case Description : Special Case Negative credit
	 * @throws Exception 
	 */
	
	@Test
	public void testVendgetException() throws Exception {
		Coin negativeValueCoin = Mockito.mock(Coin.class);
		Mockito.when(negativeValueCoin.getValue()).thenReturn(-100);
		ATM atm = new ATM();
		atm.insert(negativeValueCoin);
		outContent.reset();
		try {
			atm.vend();
		} catch(Exception e) {
			assertEquals("Error: negative credit!", e.getMessage());
		}
	}
	
}
