package com.accolite.jayesh.junit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class ATMTest {
	
	
	Coin coin1 = new Coin("PENNY");
	Coin coin2 = new Coin("NICKEL");
	Coin coin3 = new Coin("DIME");
	Coin coin4 = new Coin("QUARTER");
	Coin coin5 = new Coin("HALFDOLLAR");
	Coin coin6 = new Coin("SILVERDOLLAR");
	Coin coin7 = new Coin("INVALID");

	
	
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
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testATM() {
		//fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		ATM my_atm1 = new ATM();
		my_atm1.insert(coin7);
		assertEquals("illegal value",errContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		ATM my_atm2 = new ATM();
		my_atm2.insert(coin4);
		assertEquals("Current value = " + coin4.getValue(),outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		assertEquals("",errContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		ATM my_atm3 = new ATM();
		my_atm3.insert(coin6);
		assertEquals("Current value = 100 (sufficient credit)",outContent.toString().trim());
		//assertEquals(" (sufficient credit)",outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		
		
		//fail("Not yet implemented");
	}

@Test
	public void testReturnCoins() {
		ATM my_atm1 = new ATM();
		//my_atm1.insert(coin7);
		my_atm1.returnCoins();
		assertEquals("no coins to return",errContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		ATM my_atm2 = new ATM();
		my_atm2.insert(coin1);
		outContent.reset();
		my_atm2.returnCoins();
		assertEquals("Take your coins",outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		//fail("Not yet implemented");
	}

	@Test
	public void testVend() throws Exception{
		
		ATM my_atm2 = new ATM();
		my_atm2.vend();
		assertEquals("Not enough credit: add "+ 75,outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		ATM my_atm1 = new ATM();
		my_atm1.insert(coin4);
		outContent.reset();
		my_atm1.insert(coin5);
		outContent.reset();
		my_atm1.vend();
		assertEquals("Get your drink\nCurrent value = 0".replace("\r", ""),outContent.toString().trim().replace("\r", ""));
		//errContent.reset();
		//outContent.reset();

		
		errContent.reset();
		outContent.reset();
		
		ATM my_atm3 = new ATM();
		coin1 = Mockito.mock(Coin.class);
		Mockito.when(coin1.getValue()).thenReturn(-1);
		my_atm3.insert(coin1);
		try{
			my_atm3.vend();
		} catch( Exception e) {
			assertEquals("Error: negative credit!", e.getMessage());
		}
		
		//fail("Not yet implemented");
	}

}
