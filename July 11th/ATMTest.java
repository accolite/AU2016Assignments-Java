/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 11, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.UnitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import java.lang.reflect.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
// TODO: Auto-generated Javadoc

/**
 * The Class ATMTest.
 */
//@RunWith(MockitoJUnitRunner.class)
//@RunWith(Mockito.PowerMockRunner.class)
public class ATMTest {

// Tried Mock Inject 	
/*	
	@Mock (name = "currValue")
	int currentValue;
	
	@Mock (name = "enabled")
	boolean atm_enabled;
	
	@InjectMocks
	private ATM atm1; //the class to test
	 @Before
	  public void setup(){
	    MockitoAnnotations.initMocks(this); // initialize all the @Mock objects
	   }
*/	

	/** The atm. */
	ATM atm=new ATM();
	
	/** The coin 3. */
	Coin coin1,coin2,coin3;
	
	
	/**
 * Test ATM.
 */
@Test
	public void testATM() {
			ATM atm1=mock(ATM.class);
			assertNotNull("Mocked Object Created",atm1);
	}

	/**
	 * Test case 1 for Insert().
	 */
	@Test
	public void testInsert1() {
		coin1=mock(Coin.class);
		when(coin1.getValue()).thenReturn(0);
		atm.insert(coin1);
	}
	
	/**
	 * Test case 2 for Insert().
	 */
	@Test
	public void testInsert2() {
		coin2=mock(Coin.class);
		//coin2=new Coin("HALFDOLLAR");
		when(coin2.getValue()).thenReturn(50);
		atm.insert(coin2);
	}
	
	/**
	 * Test case 3 for Insert().
	 */
	@Test
	public void testInsert3() {
		coin3=mock(Coin.class);
		//coin2=new Coin("HALFDOLLAR");
		when(coin3.getValue()).thenReturn(100);
		atm.insert(coin3);
		
	}


	/**
	 * Test case 1 for ReturnCoins().
	 * currValue=0
	 */
	@Test
	public void testReturnCoins1() {
		//coin1=mock(Coin.class);
		//Mockito.when(coin1.getValue()).thenReturn(0);
		atm.returnCoins();
	}
	
	/**
	 * Test Case 2 for ReturnCoins().
	 * currValue!=0
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testReturnCoins2() throws Exception {
		Field currentValue;
		currentValue=atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);
		currentValue.set(atm, 50);
		
		atm.returnCoins();
	}
		
		
	/**
	 * Test Case 1 for Vend().
	 * enabled=false
	 * Using Reflection
	 * @throws Exception the exception
	 */
	@Test
	public void testVend1() throws Exception{
		Field Enabled;
		
		Enabled=atm.getClass().getDeclaredField("enabled");
		Enabled.setAccessible(true);
		Enabled.set(atm, false);
		
		atm.vend();
	}

	/**
	 * Test Case 2 for Vend().
	 * enabled=True
	 * currValue=50
	 * Using Reflection
	 * @throws Exception the exception
	 */
	@Test
	public void testVend2() throws Exception {
		Field currentValue,Enabled;
		
		Enabled=atm.getClass().getDeclaredField("enabled");
		Enabled.setAccessible(true);
		Enabled.set(atm, true);
		
		currentValue=atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);
		currentValue.set(atm, 75);
		
		atm.vend();
	}
	
	/**
	 * Test Case 3 for Vend().
	 * enabled=True
	 * currValue=100
	 * Using Reflection
	 * @throws Exception the exception
	 */
	@Test
	public void testVend3() throws Exception {
		Field currentValue,Enabled;
		
		Enabled=atm.getClass().getDeclaredField("enabled");
		Enabled.setAccessible(true);
		Enabled.set(atm, true);
		
		currentValue=atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);
		currentValue.set(atm, 100);
		
		atm.vend();
	}
	
	
	/**
	 * Test Case 4 for Vend().
	 * enabled=True
	 * currValue=-1
	 * Using Reflection
	 * @throws Exception the exception
	 */
	@Test
	public void testVend4() throws Exception{
     Field currentValue,Enabled;
		
		Enabled=atm.getClass().getDeclaredField("enabled");
		Enabled.setAccessible(true);
		Enabled.set(atm, true);
		
		currentValue=atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);
		currentValue.set(atm, -1);
		
		atm.vend();
	
		
	}
}
