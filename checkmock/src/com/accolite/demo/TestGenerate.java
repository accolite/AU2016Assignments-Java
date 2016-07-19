package com.accolite.demo;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestGenerate {

	private Coin mockito=Mockito.mock(Coin.class);
	private ATM mockito11=Mockito.mock(ATM.class);
	private  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private  ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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
	
	
	
	@Test
	public void testtoString()
	{
		Coin c=new Coin("Pen");
		assertEquals("0", c.toString());
	}
	@Test
	public void testgetValue()
	{
		Coin c=new Coin("Pen");
		assertEquals("Successs",0,c.getValue());
		c=new Coin("pENNY");
		assertEquals(1,c.getValue());
		c=new Coin("nickel");
		assertEquals("Success",5,c.getValue());
		c=new Coin("dime");
		assertEquals("Success",10,c.getValue());
		c=new Coin("quarter");
		assertEquals("Success",25,c.getValue());
		c=new Coin("halfDollar");
		assertEquals("Success",50,c.getValue());
		c=new Coin("silverDollar");
		assertEquals("Success",100,c.getValue());
		
	}
	
	@Test 
	public void testInsert()
	{
		Mockito.when(mockito.getValue()).thenReturn(0);
		Coin c=new Coin("Penny");
		ATM atm=new ATM();
		atm.insert(c);
		assertEquals( "Current value = 1",outContent.toString().trim());
		c=new Coin("nickel");
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		atm.insert(c);
		assertEquals( "Current value = 6",outContent.toString().trim());
		c= new Coin("asdfkjbab");
		atm.insert(c);
		assertEquals( "illegal value",errContent.toString().trim());
		c= new Coin("Silverdollar");
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		atm.insert(c);
		assertEquals( "Current value = 106 (sufficient credit)",outContent.toString().trim());
		
	}
	
	@Test 
	public void TestReturnCoins()
	{
		ATM atm=new ATM();
		Coin c= new Coin("asdfkjbab");
		atm.returnCoins();
		assertEquals("no coins to return",errContent.toString().trim());
		
		c=new Coin("Penny");
		atm.insert(c);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		atm.returnCoins();
		assertEquals( "Take your coins",outContent.toString().trim());
		
		/*c=new Coin("nickel");
		atm.insert(c);
		atm.returnCoins();
		assertEquals( "Take your coins",outContent.toString().trim());
		
		c= new Coin("Silverdollar");
		atm.insert(c);
		atm.returnCoins();
		assertEquals( "Take your coins",outContent.toString().trim());*/
		
	}
	
	@Test 
	public void TestVend() throws Exception
	{
		ATM atm=new ATM();
		Coin c1=new Coin("quarter");
		atm.insert(c1);
		Coin c2=new Coin("HalfDollar");
		atm.insert(c2);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		atm.vend();
		assertEquals("Get your drink\rCurrent value = 0",outContent.toString().trim().replace("\n",""));
		
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		atm=new ATM();
		Coin c=new Coin("asfdfkjna");
		atm.vend();
		assertEquals("Not enough credit: add 75",outContent.toString().trim());
		
		atm=new ATM();
		c= new Coin("silverdollar");
		atm.insert(c);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		atm.vend();
		
		assertEquals("Get your drink\rCurrent value = 25",outContent.toString().trim().replace("\n",""));
		
	}
	
	
	
	
}