/**
 * 
 */
package ass3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Administrator
 *
 */
public class AtmTest {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
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
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		 System.setOut(null);
	    System.setErr(null);
	}

	/**
	 * Test method for {@link ass3.ATM#ATM()}.
	 */
	
	/**
	 * Test method for {@link ass3.ATM#insert(ass3.Coin)}.
	 */
	@Test
	public void Insert()
	{
		Coin invalid= new Coin("LALLALAL");
		ATM atm=new ATM();
		atm.insert(invalid);
		assertEquals("illegal value",errContent.toString().trim());
		Coin p=new Coin("SILVERDOLLAR");
		ATM atm1=new ATM();
		atm1.insert(p);
		assertEquals("Current value = 100 (sufficient credit)",outContent.toString().trim());
		outContent.reset();
		Coin q=new Coin("HALFDOLLAR");
		ATM atm2=new ATM();
		atm2.insert(q);
		assertEquals("Current value = 50",outContent.toString().trim());
	}
	@Test
	public void testreturn()
	{
		Coin p=new Coin("HALFDOLLAR");
		ATM atm=new ATM();
		atm.returnCoins();
		assertEquals("no coins to return",errContent.toString().trim());
		Coin q=new Coin("HALFDOLLAR");
		ATM atm1=new ATM();
		atm1.insert(p);
		outContent.reset();
		atm1.returnCoins();
		assertEquals("Take your coins",outContent.toString().trim());
	}

	@Test
	public void vendtest() throws Exception
	{
		Coin p=new Coin("SILVERDOLLAR");
		ATM atm=new ATM();
		atm.insert(p);
		outContent.reset();
		atm.vend();
		String a="Get your drink\nCurrent value = 25";
		String r=outContent.toString().trim();
		a=a.replace("\n", "");
		a=a.replace("\r", "");
		r=r.replace("\n", "");
		r=r.replace("\r", "");
		assertEquals(a,r);
		Coin q=new Coin("HALFDOLLAR");
		ATM atm1=new ATM();
		atm1.insert(q);
		outContent.reset();
		atm1.vend();
		assertEquals("Not enough credit: add 25",outContent.toString().trim());
		Coin x=new Coin("HALFDOLLAR");
		Coin y=new Coin("QUARTER");
		ATM atm2=new ATM();
		atm2.insert(x);
		outContent.reset();
		atm2.insert(y);
		outContent.reset();
		atm2.vend();
		String s="Get your drink\nCurrent value = 0";
		String t=outContent.toString().trim();
		s=s.replace("\n", "");
		s=s.replace("\r", "");
		t=t.replace("\n", "");
		t=t.replace("\r", "");
		assertEquals(s,t);
		Coin negv=Mockito.mock(Coin.class);
		when(negv.getValue()).thenReturn(-1);
		ATM atm5=new ATM();
		atm5.insert(negv);
		outContent.reset();
		try{
		atm5.vend();
		}
		catch(Exception e)
		{
			
			assertEquals("Error: negative credit!",e.getMessage());
		}
	
	}
	
}
