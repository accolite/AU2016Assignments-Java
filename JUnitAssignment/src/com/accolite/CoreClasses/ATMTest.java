package com.accolite.CoreClasses;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.*;

public class ATMTest {

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
	public void testInsertCoinInATMNotSufficientAmount() {
		Coin coin = Mockito.mock(Coin.class);
		when(coin.getValue()).thenReturn(34);
		ATM atm = new ATM();
		atm.insert(coin);
		String s = "Current value = 34";
		assertEquals(s,outContent.toString().substring(0, s.length()));
	}
	
	@Test
	public void testInsertCoinInATMSufficientAmount() {
		Coin coin = Mockito.mock(Coin.class);
		when(coin.getValue()).thenReturn(79);
		ATM atm = new ATM();
		atm.insert(coin);
		String s = "Current value = 79"+ " (sufficient credit)";
		assertEquals(s,outContent.toString().substring(0, s.length()));
	}
	
	@Test
	public void testInsertCoinInATMZero() {
		Coin coin = Mockito.mock(Coin.class);
		when(coin.getValue()).thenReturn(0);
		ATM atm = new ATM();
		atm.insert(coin);
		String s = "illegal value";
		assertEquals(s,errContent.toString().substring(0, s.length()));
	}
	
	
	@Test
	public void testReturnCoinsFromATMWhenNoCoins() {
		ATM atm = new ATM();
		atm.returnCoins();
		String s = "no coins to return";
		assertEquals(s,errContent.toString().substring(0, s.length()));
	}
	
	
	@Test
	public void testReturnCoinsFromATMWhenPositiveCoins() {
		Coin coin2 = Mockito.mock(Coin.class);
		when(coin2.getValue()).thenReturn(30);
		ATM atm = new ATM();
		atm.insert(coin2);
		outContent.reset();
		atm.returnCoins();		
		String s = "Take your coins";
		assertEquals(s,outContent.toString().substring(0, s.length()));
	}
	
	
	@Test
	public void testVendATMWhenNegativeCoins() {
		Coin coin2 = Mockito.mock(Coin.class);
		when(coin2.getValue()).thenReturn(-30);
		ATM atm = new ATM();
		atm.insert(coin2);
		try {
			atm.vend();
		} catch (Exception e) {
			assertEquals("Error: negative credit!", e.getMessage());
		}
	}
	
	
	@Test
	public void testVendATMWhenEnoughCreditCard() {
		Coin coin2 = Mockito.mock(Coin.class);
		when(coin2.getValue()).thenReturn(90);
		ATM atm = new ATM();
		atm.insert(coin2);
		outContent.reset();
		try{
		  atm.vend();
		}catch(Exception e){
			e.printStackTrace();
		}
		String s = "Get your drinkCurrent value = "+15;
		assertEquals(s,outContent.toString().trim());
	}
	
	
	@Test
	public void testVendATMWhenNotEnoughCreditCard() {
		Coin coin2 = Mockito.mock(Coin.class);
		when(coin2.getValue()).thenReturn(72);
		ATM atm = new ATM();
		atm.insert(coin2);
		outContent.reset();
		try{
		  atm.vend();
		}catch(Exception e){
			e.printStackTrace();
		}
		String s = "Not enough credit: add " +3;
		assertEquals(s,outContent.toString().trim());
	}
	
	

}
