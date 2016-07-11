package com.accolite.junitandmaven;

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

public class ATMCOINTest {
	
	
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
	public final void testATM() {

	}
	
	@Test
	public final void testToString() {
		Coin C1=new Coin("NICKEL");
		Coin C2=new Coin("Dime");
		assertEquals(C2.toString(),"10");
	}
	
	@Test
	public final void testInsert() {
		errContent.reset();
		outContent.reset();
		Coin C1 = new Coin("QUARTER");
		ATM atmObj = new ATM();
		atmObj.insert(C1);
		assertEquals(outContent.toString().trim(), "Current value = 25");
		Coin C2 = new Coin("SAICHARAN");
		atmObj.insert(C2);
		assertEquals(errContent.toString().trim(), "illegal value");
		Coin C3 = new Coin("SILVERDOLLAR");
		outContent.reset();
		ATM atmObj1 = new ATM();
		atmObj1.insert(C3);
		assertEquals(outContent.toString().trim(), "Current value = 100 (sufficient credit)");
		
	}
	
	@Test
	public final void testReturnCoins() {
		
		ATM atmObj = new ATM();
		atmObj.returnCoins();
		assertEquals(errContent.toString().trim(), "no coins to return");
		errContent.reset();
		Coin C1 = new Coin("QUARTER");
		atmObj.insert(C1);
		assertEquals(outContent.toString().trim(), "Current value = 25");
		outContent.reset();
		atmObj.returnCoins();
		assertEquals(outContent.toString().trim(), "Take your coins");

	}

	@Test
	public final void testVend() throws Exception {
		errContent.reset();
		outContent.reset();
		ATM a1 = new ATM();
		Coin C1 = new Coin("MOVVA");
		a1.vend();
		assertEquals(outContent.toString().trim(), "Not enough credit: add 75");
		Coin C2 = new Coin("HALFDOLLAR");
		Coin C3 = new Coin("QUARTER");
		Coin C4 = new Coin("PENNY");
		outContent.reset();
		a1.insert(C2);
		assertEquals(outContent.toString().trim(), "Current value = 50");
		outContent.reset();
		a1.insert(C3);
		assertEquals(outContent.toString().trim(), "Current value = 75 (sufficient credit)");
		outContent.reset();
		a1.vend();
		a1.vend();
		a1.insert(C2);
		a1.insert(C3);
		a1.insert(C4);
		a1.vend();
		ATM my_atm3 = new ATM();
		  Coin coin1 = Mockito.mock(Coin.class);
		  Mockito.when(coin1.getValue()).thenReturn(-1);
		  my_atm3.insert(coin1);
		  try{
		   my_atm3.vend();
		  } catch( Exception e) {
		   assertEquals("Error: negative credit!", e.getMessage());
		  }
		try{my_atm3.vend();}catch(Exception e){}
	}

}
