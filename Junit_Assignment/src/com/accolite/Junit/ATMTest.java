/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :7/7/16: Jul 11, 2016
*
*  @author :K.Suryateja Rao: SUKO-HYD-01
* ***************************************************************************
*/
package com.accolite.Junit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import junit.framework.Assert;

// TODO: Auto-generated Javadoc
/**
 * The Class ATMTest.
 */
public class ATMTest {
 
 /** The atm. */
 private ATM atm;
 
 /** The coin. */
 private COIN coin;
 
 /** The mock. */
 @Mock
 COIN mock;
 
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
   atm=new ATM();
 }

 /**
  * Tear down.
  *
  * @throws Exception the exception
  */
 @After
 public void tearDown() throws Exception {
 }

 /** The out content. */
 private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
 
 /** The err content. */
 private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

 /**
  * Sets the up streams.
  */
 @Before
 public void setUpStreams() {
     System.setOut(new PrintStream(outContent));
     System.setErr(new PrintStream(errContent));
      mock=Mockito.mock(COIN.class);
 }

 /**
  * Clean up streams.
  */
 @After
 public void cleanUpStreams() {
     System.setOut(null);
     System.setErr(null);
     outContent.reset();
     errContent.reset();
 }
 
 /**
  * Testto string.
  */
/* @Test
  public void testtoString()
  {
    coin=new COIN("Penny");
   assertEquals("1", coin.toString());
  }*/

/**
 * Test coin get value.
 */
/*@Test
public void TestCoinGetValue()
{
 
  coin=new COIN("0");
  int expectedResult=0;
  atm.insert(coin);
  int value=coin.getValue();
  assertEquals(value,expectedResult);
  coin=new COIN("penny");
  assertEquals(coin.getValue(),1);
  coin=new COIN("nickel");
  assertEquals(coin.getValue(),5);
  coin=new COIN("dime");
  assertEquals(coin.getValue(),10);
  coin=new COIN("quarter");
  assertEquals(coin.getValue(),25);
  coin=new COIN("halfdollar");
  assertEquals(coin.getValue(),50);
  coin=new COIN("silverdollar");
  assertEquals(coin.getValue(),100);
 
 
  
}

*//**
 * Test insert value.
 *//*
@Test
public void testInsertValue()
{
  Mockito.when(mock.getValue()).thenReturn(1);
  atm.insert(mock);
  assertEquals("Current value = 1",outContent.toString().trim());
  outContent.reset();
 coin=new COIN("0");
 atm.insert(coin);
 assertEquals("illegal value",errContent.toString().trim());
 coin=new COIN("penny");
 atm.insert(coin);
 assertEquals("Current value = 2",outContent.toString().trim());
 outContent.reset();
 coin=new COIN("silverdollar");
 atm.insert(coin);
 assertEquals("Current value = 102 (sufficient credit)",outContent.toString().trim());
 outContent.reset();
}

*//**
 * Test return value.
 *//*
@Test
public void testReturnValue()
{
 atm.returnCoins();
 assertEquals("no coins to return" , errContent.toString().trim());
 errContent.reset();
 coin=new COIN("silverdollar");
 atm.insert(coin);
 outContent.reset();
 atm.returnCoins();
 assertEquals("Take your coins",outContent.toString().trim());
 outContent.reset();
 atm.returnCoins();
 assertEquals("no coins to return",errContent.toString().trim());
}*/

/**
 * Test vend.
 *
 * @throws Exception the exception
 */
@Test
public void testVend() throws Exception
{
 atm.vend();
 assertEquals("Not enough credit: add 75",outContent.toString().trim());
 coin=new COIN("silverdollar");
 atm.insert(coin);
 outContent.reset();
 atm.vend();
 assertEquals("Get your drink\rCurrent value = 25", outContent.toString().trim().replace("\n", ""));
 outContent.reset();
 try
 {
 atm.vend();
  Assert.fail("Expected an negative credit to be thrown");
    } catch (Exception negativeCreditException) {
        Assert.assertEquals("The exception should be negative credit exception", negativeCreditException.getMessage(), "Error: negative credit!");
 
      }
 
}

}