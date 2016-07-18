package com.accolite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import junit.framework.Assert;

import static org.mockito.Mockito.*;

public class ATMTest {
	ATM atmTest = new ATM();

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

	
	@Mock
	Coin coin111;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    coin111=mock(Coin.class);
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	    errContent.reset();
	    outContent.reset();
	    
	}
	
	
/*	
	@Test
	public void TestCoinValue()
	{
	// ATM atmTest = new ATM();
		Coin coin=new Coin("0");
		int expectedResult =0;
		int v=coin.getValue();
		assertEquals(expectedResult,v);
		
		Coin coin1 =new Coin("penny");
		assertEquals(coin1.getValue(),1);
		
		Coin coin2 =new Coin("nickel");
		assertEquals(coin2.getValue(),5);
		
		Coin coin3 =new Coin("dime");
		assertEquals(coin3.getValue(),10);
		
		Coin coin4 =new Coin("quarter");
		assertEquals(coin4.getValue(),25);
		
		Coin coin5 =new Coin("halfdollar");
		assertEquals(coin5.getValue(),50);
		
		Coin coin6 =new Coin("silverdollar");
		assertEquals(coin6.getValue(),100);
	}
	*/
	
	@Test
	public void TestInsert()
	{
		when(coin111.getValue()).thenReturn(1);
		atmTest.insert(coin111);
		
		assertEquals("Current value = 1",outContent.toString().trim());
		outContent.reset();
		
		
		Coin coin7 = new Coin("0");
		atmTest.insert(coin7);
		assertEquals("illegal value",errContent.toString().trim());
		
		atmTest.insert(new Coin("silverdollar"));
		assertEquals("Current value = 101 (sufficient credit)",outContent.toString().trim());
		
		outContent.reset();
		atmTest.insert(new Coin("penny"));
		assertEquals("Current value = 102 (sufficient credit)",outContent.toString().trim());
		
		

	}
	
/*	@Test
	public void TestReturnCoins()
	{
		atmTest.returnCoins();
		assertEquals("no coins to return" , errContent.toString().trim());
		
		errContent.reset();
		atmTest.insert(new Coin("silverdollar"));
		outContent.reset();
		atmTest.returnCoins();
		assertEquals("Take your coins", outContent.toString().trim());
		outContent.reset();
		atmTest.returnCoins();
		assertEquals("no coins to return" , errContent.toString().trim());
	}
	
	@Test
	public void Testvend() throws Exception
	{
		atmTest.vend();
		assertEquals("Not enough credit: add 75",outContent.toString().trim());
		atmTest.insert(new Coin("silverdollar"));
		outContent.reset();
		
		atmTest.vend();
		//assertEquals("Get your drink\nCurrent value = 25",outContent.toString().trim());
		assertEquals("Get your drink\rCurrent value = 25", outContent.toString().trim().replace("\n", ""));
		outContent.reset();
		try
		 {
		 atmTest.vend();
		  Assert.fail("Expected an negative credit to be thrown");
		    } catch (Exception negativeCreditException) {
		        Assert.assertEquals("The exception should be negative credit exception", negativeCreditException.getMessage(), "Error: negative credit!");
		 
		      }
		
		
	}*/

}
