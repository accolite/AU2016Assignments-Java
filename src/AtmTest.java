import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.*;

/**
 * 
 */

/**
 * @author Ravi Kalmodia
 *
 */
public class AtmTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
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
	/**
	 * Test method for {@link ATM#insert(Coin)}.
	 */
	@Ignore
	@Test
	public void testInsert() {
		ATM Atm = new ATM() ;
		Coin c1 = new Coin("QUARTER");
		Coin c2 = new Coin("INVALID");	
		Coin c3 = new Coin("HALFDOLLAR");	
		Atm.insert(c1);
		assertEquals("Current value = 25",outContent.toString().trim());
		Atm.insert(c2);
		assertEquals("illegal value",errContent.toString().trim());
		outContent.reset();
		Atm.insert(c3);
		assertEquals("Current value = 75 (sufficient credit)",outContent.toString().trim());
	//	assertEquals(,100);

	}
	@Ignore
	@Test
	public void testToString() {
		Coin c3 = new Coin("HALFDOLLAR");
		assertEquals("50",c3.toString());
	}
	/**
	 * Test method for {@link ATM#returnCoins()}.
	 */
	
	@Test
	public void testReturnCoins() {
		ATM Atm = new ATM() ;
		Atm.returnCoins();
		assertEquals("no coins to return",errContent.toString().trim());
		errContent.reset();
		Coin c1 = new Coin("QUARTER");
		Atm.insert(c1);
		outContent.reset();
		Atm.returnCoins();
		assertEquals("Take your coins",outContent.toString().trim());
          
		
	}

	/**
	 * Test method for {@link ATM#vend()}.
	 */
	@Ignore
	@Test
	public void testVend() throws Exception{
		ATM Atm = new ATM() ;
		Coin c2 = new Coin("INVALID");	
		Atm.insert(c2);
		outContent.reset();
		try {
			Atm.vend();
			assertEquals("Not enough credit: add 75",outContent.toString().trim());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		Coin c1 = new Coin("HALFDOLLAR");
		Coin c4 = new Coin("QUARTER");
		Coin c3 = new Coin("PENNY");
		Atm.insert(c1);
		Atm.insert(c2);
		Atm.insert(c4);
		outContent.reset();
		errContent.reset();
		Atm.vend();
		Atm.vend();
		Atm.insert(c1);
		Atm.insert(c3);
		Atm.insert(c4);
		ATM mt = new ATM();
	    Coin coin1 = Mockito.mock(Coin.class);
	    Mockito.when(coin1.getValue()).thenReturn(-1);
	    mt.insert(coin1);
	    try{
	     mt.vend();
	    } catch( Exception e) {
	     assertEquals("Error: negative credit!", e.getMessage());
	    }
		try {
			Atm.vend();
		//	assertEquals("Get your drink\n Current value = 25\n",outContent.toString().trim());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
