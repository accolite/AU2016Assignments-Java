/**
 * 
 */
package com.accolite.JunitTest;

import com.java.MyJunit.*;

import junit.framework.Assert;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.EndsWith;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author Balaji P
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CoinTest {

	@InjectMocks
	Coin coin2 = new Coin("silverdollar");
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Coin coin = new Coin("Nickel");
		System.out.println("In Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("In Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.java.MyJunit.Coin#Coin(java.lang.String)}.
	 */
	@Test
	public void testCoin() {
		Coin coin3 = Mockito.mock(Coin.class);
		//coin3.
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.java.MyJunit.Coin#getValue()}.
	 */
	@Test
	public void testGetValue() {
		Coin coin = new Coin("PENNY");
		assertEquals("coin value is correct for"+coin.toString(),coin.getValue(),1);
		coin = new Coin("Nickel");
		assertEquals("coin value is correct for"+coin.toString(),coin.getValue(),5);
		coin = new Coin("dime");
		assertEquals("coin value is correct for "+coin.toString(),coin.getValue(),10);
		coin = new Coin("quarter");
		assertEquals("coin value is correct for"+coin.toString(),coin.getValue(),25);
		coin = new Coin("halfdollar");
		assertEquals("coin value is correct for"+coin.toString(),coin.getValue(),50);
		coin = new Coin("silverdollar");
		assertEquals("coin value is correct for"+coin.toString(),coin.getValue(),100);
		coin = new Coin("Nickle");
		assertEquals("coin value is correct for"+coin.toString(),coin.getValue(),0);
		
		when(coin2.getValue()).thenReturn(10);
		assertEquals("using mock object and overriding mock function", coin2.getValue(),100);
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.java.MyJunit.Coin#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
