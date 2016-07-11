package com.accolite.au.junit
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.lang.reflect.*;
import org.junit.Test;
import org.mockito.Mockito;

public class MyTests {

	//mocking coin objects
	Coin coinTestObject=Mockito.mock(Coin.class);
	Coin coinTestObject1=Mockito.mock(Coin.class);
	
	ATM myATMTestObject = new ATM();
	
	@Test
	public void constructerCoinTest()
	{
		Coin coin1 = new Coin("Penny");
		assertEquals(1, coin1.getValue());
		Coin coin2 = new Coin("NICKEL");
		assertEquals(5, coin2.getValue());
		Coin coin3 = new Coin("dIME");
		assertEquals(10, coin3.getValue());
		Coin coin4 = new Coin("QUARTER");
		assertEquals(25, coin4.getValue());
		Coin coin5 = new Coin("HALFDOLLAR");
		assertEquals(50, coin5.getValue());
		Coin coin6 = new Coin("SILVERDOLLAR");
		assertEquals(100, coin6.getValue());
		Coin coin7 = new Coin("SILVERDOLLAR1234");
		assertEquals(0, coin7.getValue());
	}
	@Test
	public void toStringTest()
	{
		Coin coin1 = new Coin("Penny");
		String returnedValue = coin1.toString();
		assertEquals("1", returnedValue);
	}
	
	@Test
	public void insertTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		when(coinTestObject.getValue()).thenReturn(0);
		when(coinTestObject1.getValue()).thenReturn(1);
		assertEquals(coinTestObject.getValue(), 0);
		
		//checking for enabled and current values
		 myATMTestObject.insert(coinTestObject);
		Field field = ATM.class.getDeclaredField("enabled");
		field.setAccessible(true);
        Object value = field.get(myATMTestObject);
        assertEquals("false", value.toString());
        
        Class atmClass = myATMTestObject.getClass();
        Field currentValueField = atmClass.getDeclaredField("currValue");
        currentValueField.setAccessible(true);
        
        currentValueField.set(myATMTestObject, new Integer(74));
        myATMTestObject.insert(coinTestObject1);
        Field enableField = ATM.class.getDeclaredField("enabled");
        enableField.setAccessible(true);
        Object enableValue = enableField.get(myATMTestObject);
        Object currentValue = currentValueField.get(myATMTestObject);
        assertEquals("true", enableValue.toString());
        assertEquals("75", currentValue.toString() );

        currentValueField.set(myATMTestObject, new Integer(75));
        myATMTestObject.insert(coinTestObject1);
        enableField = ATM.class.getDeclaredField("enabled");
        enableField.setAccessible(true);
        enableValue = enableField.get(myATMTestObject);
        currentValue = currentValueField.get(myATMTestObject);
        assertEquals("true", enableValue.toString());
        assertEquals("76", currentValue.toString() );
        
        currentValueField.set(myATMTestObject, new Integer(45));
        myATMTestObject.insert(coinTestObject1);
        enableField = ATM.class.getDeclaredField("enabled");
        enableField.setAccessible(true);
        enableValue = enableField.get(myATMTestObject);
        currentValue = currentValueField.get(myATMTestObject);
        assertEquals("true", enableValue.toString());
        assertEquals("46", currentValue.toString() );
	}
	
	@Test
	public void returnCoinsTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		 Class atmClass = myATMTestObject.getClass();
		 Field currentValueField = atmClass.getDeclaredField("currValue");
	     currentValueField.setAccessible(true);
	     Field enableValueField = ATM.class.getDeclaredField("enabled");
	     enableValueField.setAccessible(true);
	     
	     //setting currValue=74 and enabled=false
	     currentValueField.set(myATMTestObject, new Integer(74));
	     enableValueField.set(myATMTestObject, true);
	     myATMTestObject.returnCoins();     
	     Object currentValue=currentValueField.get(myATMTestObject);
	     Object enableField=enableValueField.get(myATMTestObject);
	     assertEquals("false", enableField.toString());
	     assertEquals("0", currentValue.toString());
	     
	     //setting currValue=0 and enabled=true
	     currentValueField.set(myATMTestObject, new Integer(0));
	     enableValueField.set(myATMTestObject, true);
	     myATMTestObject.returnCoins();
	     currentValue=currentValueField.get(myATMTestObject);
	     enableField=enableValueField.get(myATMTestObject);
	     assertEquals("true", enableField.toString());
	     assertEquals("0", currentValue.toString());
	}
	
	@Test
	public void vendTest() throws Exception
	{
		 Class atmClass = myATMTestObject.getClass();
		 Field currentValueField = atmClass.getDeclaredField("currValue");
	     currentValueField.setAccessible(true);
	     Field enableValueField = ATM.class.getDeclaredField("enabled");
	     enableValueField.setAccessible(true);
	     Field totalValueField =atmClass.getDeclaredField("totValue");
	     totalValueField.setAccessible(true);
	     
	     //setting values currValue=75, enabled=true, totValue=0
	     currentValueField.set(myATMTestObject, new Integer(75));
	     enableValueField.set(myATMTestObject, true);
	     totalValueField.set(myATMTestObject, 0);
	     myATMTestObject.vend();
	     Object currentValue=currentValueField.get(myATMTestObject);
	     Object enableValue=enableValueField.get(myATMTestObject);
	     Object totalValue=totalValueField.get(myATMTestObject);
	     assertEquals("false", enableValue.toString());
	     assertEquals("0", currentValue.toString());
	     assertEquals("75", totalValue.toString());
	     
	   //setting values currValue=75, enabled=false, totValue=0
	     currentValueField.set(myATMTestObject, new Integer(75));
	     enableValueField.set(myATMTestObject, false);
	     totalValueField.set(myATMTestObject, 0);
	     myATMTestObject.vend();
	     currentValue=currentValueField.get(myATMTestObject);
	     enableValue=enableValueField.get(myATMTestObject);
	     totalValue=totalValueField.get(myATMTestObject);
	     assertEquals("false", enableValue.toString());
	     assertEquals("75", currentValue.toString());
	     assertEquals("0", totalValue.toString());
	     
	     //setting value as less than zero
	     currentValueField.set(myATMTestObject, new Integer(-75));
	     enableValueField.set(myATMTestObject, false);
	     totalValueField.set(myATMTestObject, 0);
	     try{
	     myATMTestObject.vend();
	     }
	     catch(Exception e)
	     {
	    	// e.printStackTrace();
	     }
	}
}
