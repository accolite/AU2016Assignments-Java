package defualt;

import static org.junit.Assert.*;

import org.junit.*;
import org.mockito.Mockito;

public class ATMTest {
	
	@Test
	public void testATM() {
		ATM atmTester = new ATM();
		assertNotNull("Constructor failed to create an object",atmTester); // checking not null
	}
	
	@Test
	public void testInsertInvalid() {
		Coin mockCoin=Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(0);
		ATM atmTester = new ATM();
		atmTester.insert(mockCoin);
	}

	@Test
	public void testInsertLessThanCOST() {
		Coin mockCoin=Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(25);
		ATM atmTester = new ATM();
		atmTester.insert(mockCoin);
	}
	@Test
	public void testInsertMoreThanCOST() {
		Coin mockCoin=Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(100);
		ATM atmTester = new ATM();
		atmTester.insert(mockCoin);
	}

	@Test
	public void testReturnCoinsWithoutCoins() {
		ATM atmTester = new ATM();
		atmTester.returnCoins();
	}

	@Test
	public void testReturnCoinsWithCoins() {
		Coin mockCoin=Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(100);
		ATM atmTester = new ATM();
		atmTester.insert(mockCoin);
		atmTester.returnCoins();
	}
	
	@Test
	public void testVendNoCoins() throws Exception {
		Coin mockCoin = Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(75);
		ATM atmTester = new ATM();
		atmTester.vend();
	}
	
	@Test
	public void testVendWithCOST() throws Exception {
		Coin mockCoin = Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(75);
		ATM atmTester = new ATM();
		atmTester.insert(mockCoin);
		atmTester.vend();
	}
	
	@Test(expected=Exception.class)
	public void testVendNegativeValue() throws Exception {
		Coin mockCoin = Mockito.mock(Coin.class);
		Mockito.when(mockCoin.getValue()).thenReturn(100);
		ATM atmTester = new ATM();
		atmTester.insert(mockCoin);
		atmTester.vend();
		atmTester.vend();
	}

}
