package com.accolite.junitassgn;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;



public class ATMTest 
{
 @Mock
 Coin coin;
 ATM atm;
 
 ByteArrayOutputStream outstream = new ByteArrayOutputStream();
 ByteArrayOutputStream errstream = new ByteArrayOutputStream();
 
 
 @Before
 public void setUp()
 {
  coin=Mockito.mock(Coin.class);
  atm=new ATM();
  //coin=new Coin("PENNY");
  
  System.setOut(new PrintStream(outstream));
  System.setErr(new PrintStream(errstream));
  
 }
 
 @After
 public void tearDown()
 {
   System.setOut(null);
   System.setErr(null);
 }
 
/* @Test
    public void testInsertInvalid()
    {
  //invalid case
  ByteArrayOutputStream errstream = new ByteArrayOutputStream();
  System.setErr(new PrintStream(errstream));
  
  Mockito.when(coin.getValue()).thenReturn(0);
  atm.insert(coin);
  assertEquals("illegal value", errstream.toString().substring(0,13));
  
    }
 @Test
 public void testInsertValueLesserCost()
 {
  
  ByteArrayOutputStream outstream = new ByteArrayOutputStream();
  System.setOut(new PrintStream(outstream));
  
  Mockito.when(coin.getValue()).thenReturn(1);
  atm.insert(coin);
  assertEquals("Current value = 1", outstream.toString().substring(0,17));
  
 }
 
 @Test
 public void testInsertValueGreaterCost()
 {

  outstream = new ByteArrayOutputStream();
  System.setOut(new PrintStream(outstream));
  
  Mockito.when(coin.getValue()).thenReturn(100);
  atm.insert(coin);
  assertEquals("Current value = 100 (sufficient credit)", outstream.toString().substring(0,39));
  
 }
 
 @Test
    public void testReturnCoinsZeroCurrval()
    {
  
  ByteArrayOutputStream errstream = new ByteArrayOutputStream();
  System.setErr(new PrintStream(errstream));
  
  Mockito.when(coin.getValue()).thenReturn(0);
  atm.returnCoins();
  assertEquals("no coins to return", errstream.toString().substring(0,18));
    }
 
 @Test
 public void testReturnCoinsZCurrvalNotZero()
 {
        
  Mockito.when(coin.getValue()).thenReturn(1);
  atm.insert(coin);
  
  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  System.setOut(new PrintStream(outContent));
  atm.returnCoins();
  assertEquals("Take your coins", outContent.toString().substring(0,15));
    }*/
 
 @Test
    public void testVend() throws Exception
    {
  
  atm.vend();
  assertEquals("Not enough credit: add 75", outstream.toString().substring(0,25));
  
  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  System.setOut(new PrintStream(outContent));
  
  Mockito.when(coin.getValue()).thenReturn(75);
  atm.insert(coin);
  
  
  outContent = new ByteArrayOutputStream();
  System.setOut(new PrintStream(outContent));
  
  atm.vend();
  assertEquals("Get your drink\rCurrent value = 0", outContent.toString().trim().replace("\n", ""));
  
 }
 
/* @Test(expected=Exception.class)
 public void testExceptionForVend() throws Exception {
  Mockito.when(coin.getValue()).thenReturn(-1);
  atm.insert(coin);
  
  atm.vend();
  
 
  

}*/
 
 

}