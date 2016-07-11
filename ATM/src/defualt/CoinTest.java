package defualt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinTest {
	public String[] coin={"PENNY","NICKEL","DIME","QUARTER","HALFDOLLAR","SILVERDOLLAR","INVALID"};
	public int[] value={1,5,10,25,50,100,0};
	public static Coin[] testCoins;
	@BeforeClass
	public static void init(){
		testCoins = new Coin[7];
	}
	@Before
	@Test
	public void testCoin() {
		for(int i=0;i<coin.length;i++){
			testCoins[i] = new Coin(coin[i]);
			assertNotNull("Constructor failed to create an object for "+coin[i],testCoins[i]); // checking not null
		}
	}

	@Test
	public void testGetValue() {
		for(int i=0;i<coin.length;i++){
			assertEquals("Improper Value assignment for "+coin[i],value[i],testCoins[i].getValue()); // checking not null
		}
	}

	@Test
	public void testToString() {
		for(int i=0;i<coin.length;i++){
			assertEquals("Improper String return for "+coin[i],""+value[i],testCoins[i].toString()); // checking not null
		}
	}
}
