package com.accolite.assignment4;

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
import org.mockito.Mockito;

import junit.framework.Assert;

public class ATMTest1 {
	private ATM atm;
	private COIN coin;

	@Mock
	COIN mock;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 atm=new ATM();
	}

	@After
	public void tearDown() throws Exception {
	}

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	     mock=Mockito.mock(COIN.class);
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	    outContent.reset();
	    errContent.reset();
	}
	@Ignore
	@Test
	 public void testtoString()
	 {
	   coin=new COIN("Penny");
	  assertEquals("1", coin.toString());
	 }
@Test
public void TestCoinGetValue()
{
	
	 coin=new COIN("0");
	 int expectedResult=0;
	 atm.insert(coin);
	 int value=coin.getValue();
	 assertEquals(value,expectedResult);
	 coin=new COIN("penny");
	 assertEquals(coin.getValue(),1);
	 coin=new COIN("nickel");
	 assertEquals(coin.getValue(),5);
	 coin=new COIN("dime");
	 assertEquals(coin.getValue(),10);
	 coin=new COIN("quarter");
	 assertEquals(coin.getValue(),25);
	 coin=new COIN("halfdollar");
	 assertEquals(coin.getValue(),50);
	 coin=new COIN("silverdollar");
	 assertEquals(coin.getValue(),100);
	
	
	 
}
@Ignore
@Test
public void testInsertValue()
{
	 Mockito.when(mock.getValue()).thenReturn(1);
	 atm.insert(mock);
	 assertEquals("Current value = 1",outContent.toString().trim());
	 outContent.reset();
	coin=new COIN("0");
	atm.insert(coin);
	assertEquals("illegal value",errContent.toString().trim());
	coin=new COIN("penny");
	atm.insert(coin);
	assertEquals("Current value = 2",outContent.toString().trim());
	outContent.reset();
	coin=new COIN("silverdollar");
	atm.insert(coin);
	assertEquals("Current value = 102 (sufficient credit)",outContent.toString().trim());
	outContent.reset();
}
@Ignore
@Test
public void testReturnValue()
{
	atm.returnCoins();
	assertEquals("no coins to return" , errContent.toString().trim());
	errContent.reset();
	coin=new COIN("silverdollar");
	atm.insert(coin);
	outContent.reset();
	atm.returnCoins();
	assertEquals("Take your coins",outContent.toString().trim());
	outContent.reset();
	atm.returnCoins();
	assertEquals("no coins to return",errContent.toString().trim());
}
@Ignore
@Test
public void testVend() throws Exception
{
	atm.vend();
	assertEquals("Not enough credit: add 75",outContent.toString().trim());
	coin=new COIN("silverdollar");
	atm.insert(coin);
	outContent.reset();
	atm.vend();
	assertEquals("Get your drink\rCurrent value = 25", outContent.toString().trim().replace("\n", ""));
	outContent.reset();

	try
	{
	atm.vend();
	 Assert.fail("Expected an negative credit to be thrown");
    } catch (Exception negativeCreditException) {
        Assert.assertEquals("The exception should be negative credit exception", negativeCreditException.getMessage(), "Error: negative credit!");
	
		    }
	
}

}

