package junit;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ATMTest {
	
	private final  ByteArrayOutputStream outPut = new ByteArrayOutputStream();
	private final  ByteArrayOutputStream err = new ByteArrayOutputStream();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		//System.out.println("hello");
		System.setOut(new PrintStream(outPut));
	    System.setErr(new PrintStream(err));
	}

	@After
	public void tearDown() throws Exception {
		//System.out.println("end");
		System.setOut(null);
	    System.setErr(null);
	    
	}


	@Ignore
	public void testInsertWithLegalValue() {
		ATM atm = new ATM();
		Coin c = Mockito.mock(Coin.class);
		when(c.getValue()).thenReturn(90);
		atm.insert(c);
		//assertThat(outContent.toString(), is("Current value = 34"));
		String s = "Current value = 90";
		assertEquals(s,outPut.toString().substring(0, s.length()));
	}
	@Test
	public void testInsertWithIllegalValue() {
		ATM atm = new ATM();
		Coin c1 = Mockito.mock(Coin.class);
		when(c1.getValue()).thenReturn(0);
		atm.insert(c1);
		//assertThat(outContent.toString(), is("Current value = 34"));
		String s = "illegal value";
		assertEquals(s,err.toString().substring(0, s.length()));
	}
	@Ignore
	public void testReturnCoinsWithNoValue() {
		 ATM atm2 = new ATM();
		//Coin c2 = Mockito.mock(Coin.class);
		//when(c2.getValue()).thenReturn(0);
		atm2.returnCoins();
		String s = "no coins to return";
		assertEquals(s,err.toString().substring(0, s.length()));
	}
	@Ignore
	public void testReturnCoinsWithValue() {
		 ATM atm3 = new ATM();
		Coin c2 = Mockito.mock(Coin.class);
		when(c2.getValue()).thenReturn(34);
		atm3.insert(c2);
		outPut.reset();
		atm3.returnCoins();
		String s = "Take your coins";
		assertEquals(s,outPut.toString().substring(0, s.length()));
	}
	
	
	@Ignore
	public void testVendWithEdgeCase() {
		 ATM atm = new ATM();
		Coin c3 = Mockito.mock(Coin.class);
		when(c3.getValue()).thenReturn(180);
		atm.insert(c3);
		outPut.reset();
		try{
			atm.vend();
			String s = "Get your drink";
			
			assertEquals(s,outPut.toString().substring(0, s.length()));
		}
		catch(Exception e){
			assertEquals("Error: negative credit!",e.getMessage());
		}
		try{
			atm.vend();
			String s = "Get your drink";
			
			assertEquals(s,outPut.toString().substring(0, s.length()));
		}
		catch(Exception e){
			assertEquals("Error: negative credit!",e.getMessage());
		}
	}
	
	
	@Ignore
	public void testVend() {
		 ATM atm = new ATM();
		Coin c3 = Mockito.mock(Coin.class);
		when(c3.getValue()).thenReturn(90);
		atm.insert(c3);
		outPut.reset();
		try{
			atm.vend();
			String s = "Get your drink";
			
			assertEquals(s,outPut.toString().substring(0, s.length()));
		}
		catch(Exception e){
			assertEquals("Error: negative credit!",e.getMessage());
		}
	}
	@Ignore
	public void testVendWithException() {
		 ATM atm = new ATM();
		Coin c3 = Mockito.mock(Coin.class);
		when(c3.getValue()).thenReturn(-12);
		atm.insert(c3);
		try{
			atm.vend();
		}
		catch(Exception e){
			assertEquals("Error: negative credit!",e.getMessage());
			
		}
	}

}
