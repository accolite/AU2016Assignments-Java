import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

public class ATMTest {
	ATM atm = new ATM();
	Coin coin1;
	Coin coin2;
	Coin coin3;
	Coin coin123;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	@Before
	public void setUp() throws Exception {
		coin1 = new Coin("penny");
		coin2 = new Coin("halfdollar");
		coin3 = new Coin("silverdollar");
	}


/*	@Test
	public void testATM() {
		ATM atm = new ATM();
		assertNotNull(atm);
	}*/

	@Test
	public void testInsert() {
		
		atm.insert(coin1);
		atm.insert(coin3); 
		coin123 = mock(Coin.class);
		atm.insert(coin123);

		when(coin123.getValue()).thenReturn(0);

		assertEquals(coin123.getValue(), 0);

	}
/*	@Test
	public void testVend() {
		
		ATM atm11=new ATM();
		coin123 = mock(Coin.class);
		atm11.insert(coin123);
		when(coin123.getValue()).thenReturn(0);
		assertEquals(coin123.getValue(), 0);
        try {
    		Field curval=atm.getClass().getDeclaredField("currValue");
    		curval.setAccessible(true);
    		int cur=(int)curval.get(atm);
    		assertEquals("cur value",0,cur);
    		Field totval=atm.getClass().getDeclaredField("totValue");
    		totval.setAccessible(true);
    		int tot=(int)curval.get(atm);
    		assertEquals("tot value",0,tot);
        	atm.insert(coin2);
			atm.insert(new Coin("quarter"));
			atm.vend();
			assertEquals("cur value",0,cur);
			atm11.vend();
			atm.insert(coin3);
			atm.vend();
			atm.vend();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception thrown");
		}  
	}
	@Test
	public void testReturnCoins() {
		
		atm.returnCoins();
		atm.insert(coin3); 
		atm.returnCoins();

	}
*/


}
