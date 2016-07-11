package com.accolite.JunitATM;

import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.lang.*
;
public class ATMTest {
	
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		 System.setOut(null);
		    System.setErr(null);
		
	}

	@Test
	public void testATM() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testInsert() {
		ATM at=new ATM();
		Coin c = Mockito.mock(Coin.class);	
		Mockito.when(c.getValue()).thenReturn(0);
		at.insert(c);
		assertEquals("insert tc","illegal value",errContent.toString().substring(0,13));
		errContent.reset();
		
		Mockito.when(c.getValue()).thenReturn(5);
		at.insert(c);
		assertEquals("insert tc","Current value = 5",outContent.toString().substring(0,17));
		outContent.reset();
		
		Mockito.when(c.getValue()).thenReturn(1);
		at.insert(c);
		assertEquals("insert tc","Current value = 6",outContent.toString().substring(0, 17));
		outContent.reset();
		
		Mockito.when(c.getValue()).thenReturn(100);
		at.insert(c);
		assertEquals("insert tc","Current value = 106 (sufficient credit)",outContent.toString().substring(0, 39));
		outContent.reset();
		
		
		
	}
	@Ignore @Test
	public void testReturnCoins() {
		//fail("Not yet implemented");
		ATM at=new ATM();
		at.returnCoins();
		assertEquals("test return","no coins to return",errContent.toString().substring(0, 18));
		errContent.reset();
		
		Coin c = Mockito.mock(Coin.class);
		Mockito.when(c.getValue()).thenReturn(100);
		at.insert(c);
		outContent.reset();
		
		at.returnCoins();
		assertEquals("test return","Take your coins",outContent.toString().substring(0, 15));
		outContent.reset();
	}

	@Ignore @Test(expected=Exception.class)
	public void testVend() throws Exception {
		//fail("Not yet implemented");
		ATM at=new ATM();
		Coin c = Mockito.mock(Coin.class);
		//Mockito.when(c.getValue()).thenReturn(75);
		//at.insert(c);
		//outContent.reset();
		at.vend();
		
		//assertEquals("Not enough credit: add 75",outContent.toString());
		assertEquals("test vend","Not enough credit: add 75",outContent.toString().substring(0,25));
		outContent.reset();
		
		Mockito.when(c.getValue()).thenReturn(100);
		at.insert(c);
		outContent.reset();
		at.vend();
		outContent.reset();
	
		at.vend();
	//	catch(Exception e)
		//{}
		assertEquals("test vend","Get your drink\n",outContent.toString());
		
		
		at=new ATM();
		
		Mockito.when(c.getValue()).thenReturn(75);
		at.insert(c);
		//Mockito.when(c.getValue()).thenReturn(50);
	//	at.insert(c);
		
		at.vend();
		//at.vend();
		//assertEquals("test vend","Get your drink\nCurrent value = 0",outContent.toString());
		
		//at.vend();
		
	}

}
