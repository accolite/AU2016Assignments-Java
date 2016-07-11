import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

/**
 * 
 */

/**
 * @author Ankush Dhama
 *
 */
public class ATMTest {

	
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
	 * Test method for {@link ATM#ATM()}.
	 */
	@Test
	public void testATM() {
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ATM#insert(Coin)}.
	 */
/*	@Test
	public void testInsert() {
	
		Coin coinmock = Mockito.mock(Coin.class);
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ATM atm = new ATM();
		Mockito.when(coinmock.getValue()).thenReturn(1);
		atm.insert(coinmock);
		assertEquals("Current value = 1",outContent.toString().substring(0,17));
		System.setOut(null);
		
		Coin coinmock1 = Mockito.mock(Coin.class);
		final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
		ATM atm1 = new ATM();
		Mockito.when(coinmock1.getValue()).thenReturn(0);
		atm1.insert(coinmock1);
		assertEquals("illegal value",errContent.toString().substring(0,13));
		System.setOut(null);
		
		Coin coinmock2 = Mockito.mock(Coin.class);
		final ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent2));
		ATM atm2 = new ATM();
		Mockito.when(coinmock2.getValue()).thenReturn(100);
		atm2.insert(coinmock2);
		assertEquals("Current value = 100 (sufficient credit)",outContent2.toString().substring(0,39));
		System.setOut(null);
		
	}*/

	/**
	 * Test method for {@link ATM#returnCoins()}.
	 */
/*	@Test
	public void testReturnCoins() {
		
		Coin coinmock1 = Mockito.mock(Coin.class);
		final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
		ATM atm1 = new ATM();
		atm1.returnCoins();
		assertEquals("no coins to return",errContent.toString().substring(0,18));
		System.setOut(null);
		
		Coin coinmock2 = Mockito.mock(Coin.class);
		final ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent2));
		ATM atm2 = new ATM();
		Mockito.when(coinmock2.getValue()).thenReturn(100);
		atm2.insert(coinmock2);
		outContent2.reset();
		
		atm2.returnCoins();
		
		assertEquals("Take your coins",outContent2.toString().substring(0,15));
		System.setOut(null);

	}*/

	/**
	 * Test method for {@link ATM#vend()}.
	 * @throws Exception 
	 */
	@Test
	public void testVend() throws Exception {
		
		Coin coinmock = Mockito.mock(Coin.class);
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ATM atm = new ATM();
		Mockito.when(coinmock.getValue()).thenReturn(0);
		atm.insert(coinmock);
		outContent.reset();
		
		atm.vend();
		
		assertEquals("Not enough credit: add 75",outContent.toString().substring(0,25));
		System.setOut(null);
		
		
		Coin coinmock2 = Mockito.mock(Coin.class);
		final ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent2));
		ATM atm2 = new ATM();
		Mockito.when(coinmock2.getValue()).thenReturn(100);
		atm2.insert(coinmock2);
		outContent2.reset();
		
		atm2.vend();
		
		assertEquals("Get your drink\rCurrent value = 25",outContent2.toString().trim().replace("\n", ""));
		System.setOut(null);
		
		
	}

}
