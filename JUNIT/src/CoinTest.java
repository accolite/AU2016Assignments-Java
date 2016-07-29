import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinTest {
	Coin coin1;
	Coin coin2;
	Coin coin3;
	Coin coin4;
	Coin coin5;
	Coin coin6;
	Coin coin7;

	@Test
	@Before
	public void testCoin() {
		coin1 = new Coin("penny");
		coin2 = new Coin("nickel");
		coin3 = new Coin("dime");
		coin4 = new Coin("quarter");
		coin5 = new Coin("halfdollar");
		coin6 = new Coin("silverdollar");
		coin7 = new Coin("123");
		int coinvalue=coin7.getValue();
		assertEquals("not a coin",coinvalue,0);

	}

	@Test
	public void testgetValue() {
		
		int coinvalue=coin6.getValue();
		assertEquals("valid coin",coinvalue,100);
		
	}

	@Test
	public void testtoString() {
		assertEquals(coin6.toString(),"100");
	}



}
