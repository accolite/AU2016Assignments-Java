package com.accolite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.CodingErrorAction;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.AtMost;

public class ATMTest {
	
	Coin coin=new Coin("INVALID");
	
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testATM() {
		
	}
	@Ignore
	@Test
	public void testInsert() {
	
		ATM atm=new ATM();
		atm.insert(coin);
		assertEquals("illegal value",errContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		coin=new Coin("HALFDOLLAR");
		atm.insert(coin);
		assertEquals("Current value = " +coin.getValue() , outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		assertEquals("", outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		coin=new Coin("SILVERDOLLAR");
		atm.insert(coin);
		assertEquals("Current value = 150 (sufficient credit)" , outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
	}

	@Test
	public void testReturnCoins() {
		
		ATM atm=new ATM();
		coin=new Coin("INVALID");
		atm.returnCoins();
		assertEquals("no coins to return" , errContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		coin=new Coin("SILVERDOLLAR");
		atm.insert(coin);
		outContent.reset();
		atm.returnCoins();
		assertEquals("Take your coins" , outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
	}
	@Ignore
	@Test
	public void testVend() throws Exception {
		ATM atm=new ATM();
		atm.vend();
		assertEquals("Not enough credit: add " +75 , outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		ATM atm1=new ATM();
		coin=new Coin("QUARTER");
		atm1.insert(coin);
		outContent.reset();
		coin=new Coin("HALFDOLLAR");
		atm1.insert(coin);
		outContent.reset();
		atm1.vend();
		assertEquals("Get your drink\nCurrent value = 0".replace("\r", "") , outContent.toString().trim());
		errContent.reset();
		outContent.reset();
		
		ATM atm2=new ATM();
		coin=new Coin("PENNY");
		Mockito.when(coin.getValue()).thenReturn(-1);
		atm2.insert(coin);
		try{
			atm2.vend();
		}catch(Exception e){
			assertEquals("Error: negative credit!", e.getMessage());
		}
		
		
		
	}

}
