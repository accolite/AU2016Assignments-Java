/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 11, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.junitatm;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

/**
 * The Class to Test ATM.
 */
@RunWith(MockitoJUnitRunner.class)
public class ATMTest {
	
	ATM atm;
	Coin coin;
	
	@Before
	public void initialize(){
		/* Create object for ATM and mock coins */
		atm = new ATM();
		coin = mock(Coin.class);
		
	}


	/**
	 * Test insert method.
	 */
	@Test
	public void testInsert() {
		
		/* Invalid insert */
		Field currentValue;
		int currValue;
		
		Field enabledField;
		boolean enabled;
		
		try{
			currentValue = atm.getClass().getDeclaredField("currValue");
			currentValue.setAccessible(true);
			
			when(coin.getValue()).thenReturn(0);
			when(coin.toString()).thenReturn("0");
			atm.insert(coin);

			enabledField = atm.getClass().getDeclaredField("enabled");
			enabledField.setAccessible(true);
			
			enabled = (boolean) enabledField.get(atm);
	        assertEquals("Enabled is false after invalid insert", enabled, false);
	        
			
	        currValue = (int) currentValue.get(atm);
	        assertEquals("Current value is 0 after invalid insert", currValue, 0);
	        
			/* Normal insert */
			when(coin.getValue()).thenReturn(25);
			when(coin.toString()).thenReturn("25");
			atm.insert(coin);
			

	        enabled = (boolean) enabledField.get(atm);
	        assertEquals("Enabled is false after normal insert", enabled, false);
	        
			
		    currValue = (int) currentValue.get(atm);
	        assertEquals("Current value is 25 after normal insert", currValue, 25);
		
			
			/* Enabling insert */
			when(coin.getValue()).thenReturn(100);
			when(coin.toString()).thenReturn("100");
			atm.insert(coin);
	
		    currValue = (int) currentValue.get(atm);
	        assertEquals("Current value is 125 after this enabling insert", currValue, 125);
		

	        enabled = (boolean) enabledField.get(atm);
	        assertEquals("Enabled is true after enabling insert", enabled, true);
	        
	       
	        
		}catch(Exception e){
			
		}
	}

	
	@Test
	public void testReturnCoins() {

		/* When there is nothing to return */
		when(coin.getValue()).thenReturn(0);
		when(coin.toString()).thenReturn("0");
		atm.returnCoins();

		/* Insert sample coins */
		when(coin.getValue()).thenReturn(25);
		when(coin.toString()).thenReturn("25");
		
		
		atm.insert(coin);

		/* Return those sample coins */
		atm.returnCoins();
		
	}
	
	@Test
	public void testVend(){
		
		/* Case to vend enabled and then immediately disable */
		when(coin.getValue()).thenReturn(75);
		when(coin.toString()).thenReturn("75");
		atm.insert(coin);
		
		try {
			atm.vend();

			Field totalValue = atm.getClass().getDeclaredField("totValue");
			totalValue.setAccessible(true);
	        int totValue = (int) totalValue.get(atm);
	        assertEquals("total Value is 75 after 1 successful vending", totValue, 75);
	        
			
			/* Case to check disabled */
			atm.vend();
			
			/* Case to vend enabled and keep it as enabled */
			when(coin.getValue()).thenReturn(85);
			when(coin.toString()).thenReturn("85");
			atm.insert(coin);
			
			Field currentValue = atm.getClass().getDeclaredField("currValue");
			currentValue.setAccessible(true);
	        int currValue = (int) currentValue.get(atm);
	        assertEquals("Current value is 85 after this insert", currValue, 85);
			
			atm.vend();

			totValue = (int) totalValue.get(atm);
	        assertEquals("total Value is 150 after 2 successful vendings", totValue, 150);
	        
			/* Case to check negative credit */
			atm.vend();
			
		} catch (Exception e) {
			
		}
		
	}
	
	@After
	public void destroy(){
		atm = null;
		coin = null;
	}

}
