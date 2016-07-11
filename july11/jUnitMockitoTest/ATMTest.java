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
	public void testInsertZero() throws Exception{

		Field currentValue;
		int currValue;

		Field enabledField;
		boolean enabled;

		currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);


		/* Invalid insert */
		when(coin.getValue()).thenReturn(0);
		when(coin.toString()).thenReturn("0");
		atm.insert(coin);

		enabledField = atm.getClass().getDeclaredField("enabled");
		enabledField.setAccessible(true);

		enabled = (boolean) enabledField.get(atm);
		assertEquals("Enabled is false after invalid insert", enabled, false);


		currValue = (int) currentValue.get(atm);
		assertEquals("Current value is 0 after invalid insert", currValue, 0);


	}


	@Test
	public void testInsertNormal() throws Exception{

		Field currentValue;
		int currValue;

		Field enabledField;
		boolean enabled;

		currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);


		enabledField = atm.getClass().getDeclaredField("enabled");
		enabledField.setAccessible(true);

		/* Normal insert */
		when(coin.getValue()).thenReturn(25);
		when(coin.toString()).thenReturn("25");
		atm.insert(coin);


		enabled = (boolean) enabledField.get(atm);
		assertEquals("Enabled is false after normal insert", enabled, false);


		currValue = (int) currentValue.get(atm);
		assertEquals("Current value is 25 after normal insert", currValue, 25);

	}


	@Test
	public void testInsertEnabling() throws Exception{

		Field currentValue;
		int currValue;

		Field enabledField;
		boolean enabled;

		currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);


		enabledField = atm.getClass().getDeclaredField("enabled");
		enabledField.setAccessible(true);

		/* Enabling insert */
		when(coin.getValue()).thenReturn(100);
		when(coin.toString()).thenReturn("100");
		atm.insert(coin);

		currValue = (int) currentValue.get(atm);
		assertEquals("Current value is 100 after this enabling insert", currValue, 100);


		enabled = (boolean) enabledField.get(atm);
		assertEquals("Enabled is true after enabling insert", enabled, true); 

	}



	@Test
	public void testReturnCoinsNothing() throws Exception{
		/* When there is nothing to return */
		when(coin.getValue()).thenReturn(0);
		when(coin.toString()).thenReturn("0");
		atm.returnCoins();

		Field currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);

		int currValue = (int) currentValue.get(atm);
		assertEquals("Nothing returned", 0, currValue);

	}


	@Test
	public void testReturnCoinsSample() throws Exception{
		/* Sample current value setting */
		Field currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);
		currentValue.set(atm, 100);

		/* Return those sample coins */
		atm.returnCoins();

		int currValue = (int) currentValue.get(atm);
		assertEquals("All 100 coins are returned", 0, currValue);

	}


	@Test
	public void testVendEnableAndImmediateDisable() throws Exception{

		/* Case to vend enabled and then immediately disable */	
		Field currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);
		currentValue.set(atm, 75);

		Field enabledValue = atm.getClass().getDeclaredField("enabled");
		enabledValue.setAccessible(true);
		enabledValue.set(atm, true);

		atm.vend();

		Field totalValue = atm.getClass().getDeclaredField("totValue");
		totalValue.setAccessible(true);

		int totValue = (int) totalValue.get(atm);
		assertEquals("total Value is 75 after 1 successful vending", totValue, 75);

		boolean enabled = (boolean) enabledValue.get(atm);
		assertEquals("Enabled is false after vending after 75", enabled, false);

		int currValue = (int) currentValue.get(atm);
		assertEquals("Current Value is 0 after 1 successful vending after 75", currValue, 0);


	}


	@Test
	public void testVendDisabled() throws Exception{

		/* Case to vend when disabled */

		atm.vend();

		Field totalValue = atm.getClass().getDeclaredField("totValue");
		totalValue.setAccessible(true);

		int totValue = (int) totalValue.get(atm);
		assertEquals("total Value is 0 after 1 unsuccessful vending", totValue, 0);

		Field currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);

		int currValue = (int) totalValue.get(atm);
		assertEquals("Current Value is 0 after 1 unsuccessful vending", currValue, 0);

		Field enabledValue = atm.getClass().getDeclaredField("enabled");
		enabledValue.setAccessible(true);

		boolean enabled = (boolean) enabledValue.get(atm);
		assertEquals("Enabled is false after vending after 75", enabled, false);


	}

	@Test
	public void testVendEnableAndKeepEnabled() throws Exception{

		Field totalValue = atm.getClass().getDeclaredField("totValue");
		totalValue.setAccessible(true);

		Field currentValue = atm.getClass().getDeclaredField("currValue");
		currentValue.setAccessible(true);

		Field enabledValue = atm.getClass().getDeclaredField("enabled");
		enabledValue.setAccessible(true);

		/* Case to vend enabled and keep it as enabled */
		currentValue.set(atm, 85);
		enabledValue.set(atm, true);

		atm.vend();

		int totValue = (int) totalValue.get(atm);
		assertEquals("total Value is 75 after successful vendings", totValue, 75);

		boolean enabled = (boolean) enabledValue.get(atm);
		assertEquals("Enabled is true after vending after 85", enabled, true);

		int currValue = (int) currentValue.get(atm);
		assertEquals("Current value is 10 after this vending", currValue, 10);


	}


	@Test
	public void testVendNegative(){
		try{
			Field totalValue = atm.getClass().getDeclaredField("totValue");
			totalValue.setAccessible(true);
	
			Field currentValue = atm.getClass().getDeclaredField("currValue");
			currentValue.setAccessible(true);
	
			Field enabledValue = atm.getClass().getDeclaredField("enabled");
			enabledValue.setAccessible(true);
	
			/* Case to vend enabled and keep it as enabled */
			currentValue.set(atm, 10);
			enabledValue.set(atm, true);
	
			atm.vend();
		
		}catch(Exception e){
			
		}
	}



	@After
	public void destroy(){
		atm = null;
		coin = null;
	}

}
