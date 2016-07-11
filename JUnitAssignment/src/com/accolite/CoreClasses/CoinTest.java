package com.accolite.CoreClasses;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import org.junit.*;

public class CoinTest {

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
	public void testCoinValue() {
		Coin coin1  = new Coin("PENNY");
		assertEquals(coin1.getValue(),1);
		Coin coin2 = new Coin("nickel");
		assertEquals(coin2.getValue(),5);
		coin2 = Mockito.mock(Coin.class);
		when(coin2.getValue()).thenReturn(65);
		assertEquals(coin2.getValue(),65);
		Coin coin3 = new Coin("dime");
		assertEquals(coin3.getValue(),10);
		Coin coin4 = new Coin("Quarter");
		assertEquals(coin4.getValue(),25);
		Coin coin5 = new Coin("HalfDOLLAR");
		assertEquals(coin5.getValue(),50);
		Coin coin6 = new Coin("SILVERDOLLAR");
		assertEquals(coin6.getValue(),100);
	}

}
