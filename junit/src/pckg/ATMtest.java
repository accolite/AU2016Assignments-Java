/**
 * 
 */
package pckg;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

/**
 * @author Gagan Jha
 *
 */
public class ATMtest {

	/**
	 * @throws java.lang.Exception
	 */

	private  ByteArrayOutputStream out=new ByteArrayOutputStream();
	private  ByteArrayOutputStream err=new ByteArrayOutputStream();
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

		 System.setOut(new PrintStream(out));
		    System.setErr(new PrintStream(err));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pckg.ATM#ATM()}.
	 */
	@Test
	public void testATM() {
		
	}

	/**
	 * Test method for {@link pckg.ATM#insert(pckg.Coin)}.
	 */
/*	@Test
	public void testInsert() {
		Coin c = new Coin("PENNY");
		ATM a = new ATM();
		a.insert(c);
		assertEquals("Current value = 1",out.toString().trim());
		c = new Coin("gagan");
		a = new ATM();
		a.insert(c);
		assertEquals("illegal value",err.toString().trim());
		c = new Coin("SILVERDOLLAR");
		a = new ATM();
		out.reset();
		a.insert(c);
		assertEquals("Current value = 100"+" (sufficient credit)",out.toString().trim());
	}
	@Test
	public void testReturnCoins() {
		ATM a = new ATM();
		a.returnCoins();
		assertEquals("no coins to return",err.toString().trim());
	}*/

	/**
	 * Test method for {@link pckg.ATM#vend()}.
	 */
	@Test
	public void testVend() {
		ATM a =new ATM();
		a.insert(new Coin("SILVERDOLLAR"));
		out.reset();
		try{
		a.vend();}
		catch(Exception e)
		{
			
		}
		assertEquals("Get your drinkCurrent value = 25",out.toString().trim());
	}

}
