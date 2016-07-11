import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Ankush Dhama
 *
 */
public class CoinTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Coin#Coin(java.lang.String)}.
	 */
	@Test
	public void testCoin() {
		
		
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Coin#getValue()}.
	 */
	@Test
	public void testGetValue() {
		
		Coin coin1 = new Coin("PENNY");
		assertEquals("",1,coin1.getValue());
		
		coin1 = new Coin("NICKEL");
		assertEquals("",5,coin1.getValue());
		
		coin1 = new Coin("DIME");
		assertEquals("",10,coin1.getValue());
		
		coin1 = new Coin("QUARTER");
		assertEquals("",25,coin1.getValue());
		
		coin1 = new Coin("HALFDOLLAR");
		assertEquals("",50,coin1.getValue());
		
		coin1 = new Coin("SILVERDOLLAR");
		assertEquals("",100,coin1.getValue());
		
		coin1 = new Coin("RANDOM");
		assertEquals("",0,coin1.getValue());
		
	}

	/**
	 * Test method for {@link Coin#toString()}.
	 */
	@Test
	public void testToString() {
		
		Coin coin1 = new Coin("PENNY");
		assertEquals("","1",coin1.toString());
		
		coin1 = new Coin("NICKEL");
		assertEquals("","5",coin1.toString());
		
		coin1 = new Coin("DIME");
		assertEquals("","10",coin1.toString());
		
		coin1 = new Coin("QUARTER");
		assertEquals("","25",coin1.toString());
		
		coin1 = new Coin("HALFDOLLAR");
		assertEquals("","50",coin1.toString());
		
		coin1 = new Coin("SILVERDOLLAR");
		assertEquals("","100",coin1.toString());
		
		coin1 = new Coin("RANDOM");
		assertEquals("","0",coin1.toString());
	}

}
