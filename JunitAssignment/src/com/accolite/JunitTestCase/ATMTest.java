package com.accolite.JunitTestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ATMTest 
{
	@Mock
	Coin coin;
	ATM atm;
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp()
	{
		coin=Mockito.mock(Coin.class);
		atm=new ATM();
		
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		
	}
	
	@After
	public void tearDown()
	{
		 System.setOut(null);
		 System.setErr(null);
	}
	
	@Test
    public void testInsert()
    {
		//value=invalid case
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
		
		Mockito.when(coin.getValue()).thenReturn(0);
		atm.insert(coin);
		assertEquals("illegal value", errContent.toString().substring(0,13));
		
		//currValue < 75
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Mockito.when(coin.getValue()).thenReturn(1);
		atm.insert(coin);
		assertEquals("Current value = 1", outContent.toString().substring(0,17));
		
		//currValue >= 75
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Mockito.when(coin.getValue()).thenReturn(100);
		atm.insert(coin);
		assertEquals("Current value = 101 (sufficient credit)", outContent.toString().substring(0,39));
		
	}
	
	
	@Test
    public void testReturnCoins()
    {
		// currVal==0
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
		
		Mockito.when(coin.getValue()).thenReturn(0);
		atm.returnCoins();
		assertEquals("no coins to return", errContent.toString().substring(0,18));
		
		
        // currVal!=0
		Mockito.when(coin.getValue()).thenReturn(1);
		atm.insert(coin);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		atm.returnCoins();
		assertEquals("Take your coins", outContent.toString().substring(0,15));
    }
	
	
	@Test
    public void testVend() throws Exception
    {
		// enabled=false and current value=0
		atm.vend();
		assertEquals("Not enough credit: add 75", outContent.toString().substring(0,25));
		
		// enabled=true and current value=0
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Mockito.when(coin.getValue()).thenReturn(75);
		atm.insert(coin);
		
		//enabled=true and currVal=0
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		atm.vend();
		assertEquals("Get your drink\rCurrent value = 0", outContent.toString().trim().replace("\n", ""));
	 }
	
	@Test(expected=Exception.class)
	public void testExceptionForVend() throws Exception {
		Mockito.when(coin.getValue()).thenReturn(-1);
		atm.insert(coin);
		atm.vend();
		
	}
	
}
