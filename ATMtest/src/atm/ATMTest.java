package atm;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
public class ATMTest {
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
	@Ignore
	@Test
	public void testInsert_When_InsufficientValue()  {
	        //  create mock
	        Coin coin = Mockito.mock(Coin.class);
	        when(coin.getValue()).thenReturn(0);
	        ATM atm= new ATM();
	        atm.insert(coin);
	        assertEquals("illegal value",errContent.toString().trim());
	}
	@Ignore
	@Test
	public void testInsert_When_sufficientCredit()  {
	        //  create mock
	        Coin coin = Mockito.mock(Coin.class);
	        when(coin.getValue()).thenReturn(100);
	        ATM atm= new ATM();
	        atm.insert(coin);
	        assertEquals("Current value = 100 (sufficient credit)",outContent.toString().trim());
	}
	@Ignore
	@Test
	public void testReturnCoins_When_no_coins_to_return()  {
	   try{
		//ATM atm= new ATM();
	        Field privatecurrValueField = ATM.class.getDeclaredField("currValue");

	        privatecurrValueField.setAccessible(true);
	        ATM atm= new ATM();
	        int value = (int) privatecurrValueField.get(atm);
	 
	        atm.returnCoins();
	        assertEquals("curr val",value,0);
	}
	catch(Exception e){}
	}
	@Ignore
	@Test
	public void testReturnCoins_When_Take_your_coins()  {
		Coin coin = Mockito.mock(Coin.class);
        when(coin.getValue()).thenReturn(5);
        ATM atm= new ATM();
        atm.insert(coin);
        outContent.reset();
        atm.returnCoins();
        assertEquals("Take your coins",outContent.toString().trim());
		/*
	   try{
		//ATM atm= new ATM();
	        Field privatecurrValueField = ATM.class.getDeclaredField("currValue");

	        privatecurrValueField.setAccessible(true);
	        ATM atm= new ATM();
	        int value = (int) privatecurrValueField.get(atm);
	 
	        atm.returnCoins();
	        assertTrue("when curr value not equal to 0", value > 0);
	       // assertEquals("curr val",value,0);
	}
	catch(Exception e){}
	*/
	}

	@Test
	public void testVend_toCheck_Get_your_drink()
		{
		try{
		 Field privateEnabledField = ATM.class.getDeclaredField("enabled");

		 privateEnabledField.setAccessible(true);
	        ATM atm= new ATM();
	        Coin coin = Mockito.mock(Coin.class);
	        when(coin.getValue()).thenReturn(80);
	        atm.insert(coin);
	        boolean value = (boolean) privateEnabledField.get(atm);
	        assertEquals("enabled",value,true);
	        
		}
		catch(Exception e){}
		}
	}
	
	
