package com.accolite.Junit;

import static org.junit.Assert.*;
import java.lang.reflect.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class ATMTest {

	Method[] mthd = ATM.class.getDeclaredMethods();//access the methods
	Field[] fld = ATM.class.getDeclaredFields();//access the fields
 	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testATM() {
		//fail("Not yet implemented");
		//Coin coin = new Coin("penny");
		//ATM atm = new ATM();
		//assertEquals(atm.insert(coin),;)
	}

	@Test
	public void testInsert() throws IllegalArgumentException, IllegalAccessException {
		
		Coin coin = new Coin("penny");
		ATM atm = new ATM();
		
		int count = 0;
		Object val = null;
		atm.insert(coin);
		
		for(Field fld1:fld)
         {
            fld1.setAccessible(true);
            val = fld1.get(atm);
            count++;
            if(count == 2){
            	break;
            }
         }
         
            //System.out.println("field :"+fld1.getName());
            //System.out.println("type :"+fld1.getType());
            //System.out.println("value :"+fld1.getInt(new Reflaction1()));
        
		//System.out.println(val);
		assertEquals("Adding penny",val.toString(),"1");
		//fail("Not yet implemented");
	}

	@Test
	public void testReturnCoins() throws IllegalArgumentException, IllegalAccessException {
		Object val = null;
		int count = 0;
		ATM atm = new ATM();
		Coin coin  = new Coin("nickel");
		atm.insert(coin);
		atm.returnCoins();
		for(Field fld1: fld)
         {
            fld1.setAccessible(true);
            val = fld1.get(atm);
            count++;
            if(count == 2){
            	break;
            }
         }
		
		assertEquals(val.toString(),"5");
		//assertEquals(val.toString(),"");
		//fail("Not yet implemented");
	}

	@Test
	public void testVend() throws Exception {
		//fail("Not yet implemented");
		Object val = null;
		int count = 0;
		ATM atm = new ATM();
		Coin coin  = new Coin("silverdollar");
		atm.insert(coin);
		//atm.returnCoins();
		
		atm.vend();
		//assertEquals(val.toString(),"25");
	
	}
	

}
