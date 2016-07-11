/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 11, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.accolite.atm;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.runner.RunWith;
// TODO: Auto-generated Javadoc

/**
 * The Class ATMTest.
 */
@RunWith(MockitoJUnitRunner.class)

public class ATMTest {

	/** The my out. */
	ByteArrayOutputStream myOut = new ByteArrayOutputStream();
	
	/** The my err. */
	ByteArrayOutputStream myErr = new ByteArrayOutputStream();
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(myOut));
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		 System.setOut(null);
	     System.setErr(null);
	}


	/**
	 * Test method for {@link com.accolite.atm.ATM#insert(com.accolite.atm.Coin)}.
	 */
	@Test
	public void testInsert() {
		
		System.setOut(new PrintStream(myOut));
		System.setErr(new PrintStream(myErr));
		
		ATM atm = new ATM();
		Coin c = Mockito.mock(Coin.class);
	    when( c.getValue() ).thenReturn( 50 );
	    
	    atm.insert( c );
	    assertTrue( myOut.toString().toLowerCase().contains( new String("Current value = 50").toLowerCase()) );
	    
	    atm.insert( c );
	    assertTrue( myOut.toString().toLowerCase().contains( new String("Current value = 100 (sufficient credit)").toLowerCase()) );
	    
		when( c.getValue() ).thenReturn( 0 );
	    atm.insert( c );
	    assertTrue( myErr.toString().toLowerCase().contains( new String("illegal value").toLowerCase()) );
	
	}

	/**
	 * Test method for {@link com.accolite.atm.ATM#returnCoins()}.
	 */
	@Test
	public void testReturnCoins() 
	{
		System.setOut(new PrintStream(myOut));
		System.setErr(new PrintStream(myErr));
		
		ATM atm = new ATM();
		Coin c = Mockito.mock(Coin.class);
	    
	    atm.returnCoins();
	    assertTrue( myErr.toString().toLowerCase().contains( new String("no coins to return").toLowerCase()) );
	
	    myErr.reset();
	    when( c.getValue() ).thenReturn( 75 );
	    atm.insert( c );
	    atm.returnCoins();
	    assertTrue( myOut.toString().toLowerCase().contains( new String("Take your coins").toLowerCase()) );
	}

	/**
	 * Test method for {@link com.accolite.atm.ATM#vend()}.
	 */
	@Test
	public void testVend() 
	{
		System.setOut(new PrintStream(myOut));
		System.setErr(new PrintStream(myErr));
		
		ATM atm = new ATM();
		Coin c = Mockito.mock(Coin.class);
	    when( c.getValue() ).thenReturn( 75 );
	    
	    try {
			atm.vend();
			assertTrue( myOut.toString().toLowerCase().contains( new String("Not enough credit: add 75").toLowerCase()) );
			
			myOut.reset();
			atm.insert( c );
			atm.vend();
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		    assertTrue( myOut.toString().toLowerCase().contains( new String("Get your drink").toLowerCase()) && myOut.toString().toLowerCase().contains( new String("Current value = 0").toLowerCase()) );
		    
		    myOut.reset();
		    when( c.getValue() ).thenReturn( -100 );
		    atm.insert( c );
		    atm.vend();
		    
		  } catch (Exception e) 
	      {
			// TODO Auto-generated catch block
			assertEquals( e.getMessage(), "Error: negative credit!");
		}
	    
	}

}
