package com.accolite.junit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class Atm_test {
	
	private Coin mokitocoin = Mockito.mock(Coin.class);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	    outContent.reset();
	    errContent.reset();
	}
	
	
	@Test
	public void ValidInsert() {
		ATM testcase1 = new ATM();
		
		Mockito.when(mokitocoin.getValue()).thenReturn(0);
		//Coin Coin1 = new Coin("INVALID");
		testcase1.insert(mokitocoin);
		assertEquals("illegal value", errContent.toString().trim());
		cleanUpStreams();
		setUpStreams();
		
		ATM testcase2 = new ATM();
		Mockito.when(mokitocoin.getValue()).thenReturn(100);
		//Coin Coin2 = new Coin("SILVERDOLLAR");
		testcase2.insert(mokitocoin);
		assertEquals("Current value = 100 (sufficient credit)", outContent.toString().trim());
		cleanUpStreams();
		setUpStreams();
		
		
		
		
		
		
	}
	
	
	@Test
	public void returnCoins() {
		
		ATM testcase1 = new ATM();
		testcase1.returnCoins();
		assertEquals("no coins to return", errContent.toString().trim());
		cleanUpStreams();
		setUpStreams();
		
		ATM testcase2 = new ATM();
		Coin Coin2 = new Coin("DIME");
		testcase2.insert(Coin2);
		cleanUpStreams();
		setUpStreams();
		testcase2.returnCoins();
		assertEquals("Take your coins", outContent.toString().trim());
		cleanUpStreams();
		setUpStreams();
		
		
		
	}
	
	@Test
	public void vend() throws Exception {
		ATM testcase1 = new ATM();
		testcase1.vend();
		assertEquals("Not enough credit: add 75", outContent.toString().trim());
		cleanUpStreams();
		setUpStreams();
		
		ATM testcase2 = new ATM();
		Coin Coin1 = new Coin("SILVERDOLLAR");
		testcase2.insert(Coin1);
		cleanUpStreams();
		setUpStreams();
		testcase2.vend();
		assertEquals("Get your drink\rCurrent value = 25", outContent.toString().trim().replace("\n", ""));
		cleanUpStreams();
		setUpStreams();
		
		ATM testcase3 = new ATM();
		Coin Coin4 = new Coin("QUARTER");
		testcase3.insert(Coin4);
		
		Coin Coin5 = new Coin("HALFDOLLAR");
		testcase3.insert(Coin5);
		cleanUpStreams();
		setUpStreams();
		
		testcase3.vend();
		assertEquals("Get your drink\rCurrent value = 0", outContent.toString().trim().replace("\n", ""));
		cleanUpStreams();
		setUpStreams();
		
		ATM testcase4 = new ATM();
		
		/*try {
			Coin Coin6 = new Coin("SILVERDOLLAR");
			testcase4.insert(Coin6);
			testcase4.vend();
			testcase4.vend();
			Assert.fail("Expected an negative credit to be thrown");
			     } catch (Exception negativeCreditException) {
			         Assert.assertEquals("The exception should be negative credit exception", negativeCreditException.getMessage(), "Error: negative credit!");
			     }*/
			 }
	
	@Test(expected=Exception.class)
	 public void testExceptionForVend() throws Exception {
		Mockito.when(mokitocoin.getValue()).thenReturn(-1);
		ATM atm = new ATM();
	    atm.insert(mokitocoin);
	  
	   atm.vend();
	  
	 }
		
		
	}


