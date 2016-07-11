package com.accolite.atm;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;


public class ATMTest {
	
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private Coin mockedCoin = Mockito.mock(Coin.class);
	
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
	
	public void resetStreams(){
		cleanUpStreams();
		setUpStreams();
	}
	
	// insert(Coin coin) test
	@Test
	public void validCoinInsertTest(){
		ATM atm = new ATM();
		
		Mockito.when(mockedCoin.getValue()).thenReturn(50);
		atm.insert(mockedCoin);
		Assert.assertEquals("Current value should be displayed", "Current value = 50", outContent.toString().trim());
	}
	
	// insert(Coin coin) test
	@Test
	public void validSufficientCoinInsertTest(){
		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(100);
		
		atm.insert(mockedCoin);
		Assert.assertEquals("Current balance and Sufficient credit message should be displayed", "Current value = 100 (sufficient credit)", outContent.toString().trim());
	}
	
	// insert(Coin coin) test
 	@Test
	public void invalidCoinInsertTest(){
		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(0);
		
		atm.insert(mockedCoin);
		Assert.assertEquals("Error should be displayed", "illegal value",errContent.toString().trim());
	}
	
	// returnCoins() test
 	@Test
	public void validReturnCoinsTest(){
		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(10);
		
		atm.insert(mockedCoin);
		resetStreams();
		atm.returnCoins();
		Assert.assertEquals("Info should be displayed", "Take your coins",outContent.toString().trim());
	}
	
 	@Test
 	public void negativeReturnCoinsTest(){
 		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(-10);
		
		atm.insert(mockedCoin);
		resetStreams();
		atm.returnCoins();
		Assert.assertEquals("Error info should be displayed", "no coins to return",errContent.toString().trim());
	}
 	
	// returnCoins() test
 	@Test
	public void invalidReturnCoinsTest(){
		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(0);
		
		atm.insert(mockedCoin);
		resetStreams();
		atm.returnCoins();
		Assert.assertEquals("Error info should be displayed", "no coins to return",errContent.toString().trim());
	}
 	
	@Test
 	public void invalidVendTest() throws Exception{
 		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(0);
		atm.insert(mockedCoin);
		resetStreams();
		atm.vend();
		Assert.assertEquals("Not enough money info should be displayed", "Not enough credit: add 75", outContent.toString().trim());
 	}
 	
	@Test
 	public void validVendTest() throws Exception{
 		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(80);
		atm.insert(mockedCoin);
		resetStreams();
		atm.vend();
		Assert.assertEquals("Vended and current value should be displayed", "Get your drink\rCurrent value = 5", outContent.toString().trim().replace("\n", ""));	
	}
	
	@Test
 	public void validVendTestAbsolute() throws Exception{
 		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(75);
		atm.insert(mockedCoin);
		resetStreams();
		atm.vend();
		Assert.assertEquals("Vended and current value should be displayed", "Get your drink\rCurrent value = 0", outContent.toString().trim().replace("\n", ""));	
	}
	
	@Test
 	public void negativeBalanceVendingException() throws Exception{
 		ATM atm = new ATM();
		Mockito.when(mockedCoin.getValue()).thenReturn(-15);
		atm.insert(mockedCoin);
		resetStreams();
		try {
			atm.vend();
			Assert.fail("Expected an negative credit to be thrown");
	    } catch (Exception negativeCreditException) {
	        Assert.assertEquals("The exception should be negative credit exception", negativeCreditException.getMessage(), "Error: negative credit!");
	    }
	}
 	
}
