/**
 * 
 */
package com.accolite.JunitTest;

import com.java.MyJunit.*;

import java.lang.reflect.*;

import junit.framework.Assert;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.ValidateWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.EndsWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * @author Balaji P
 *
 */
public class ATMTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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
	 * Test method for {@link com.java.MyJunit.ATM#ATM()}.
	 */
	@Test
	public void testATM() {
		// fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.java.MyJunit.ATM#insert(com.java.MyJunit.Coin)}.
	 */
	@Test
	public void testInsert() {
		// ATM atm = Mockito.mock(ATM.class);
		ATM atm = new ATM();
		Coin coin = new Coin("PENNY");
		Object val = null;
		// System.out.println(coin.getValue());
		try {
			Field MyCurrValue = ATM.class.getDeclaredField("currValue");
			Field Myenabled = ATM.class.getDeclaredField("enabled");

			atm.insert(coin);

			MyCurrValue.setAccessible(true);
			val = MyCurrValue.get(atm);
//
			System.out.println("value is " + val.toString());
			assertEquals("Value is correct", "100", val.toString());
			// fail("Not yet implemented"); // TODO

			atm.insert(new Coin("Hello"));
			val = MyCurrValue.get(atm);
			assertEquals("Value is correct", "100", val.toString());
		} catch (Exception e) {

		}

	}

	private Mockito doAnswer(Answer<Integer> answer) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Test method for {@link com.java.MyJunit.ATM#returnCoins()}.
	 */
/*	@Test
	public void testReturnCoins() {
		ATM atm = new ATM();
		Object val;
		try {
			Field MyCurrValue = ATM.class.getDeclaredField("currValue");
			Field Myenabled = ATM.class.getDeclaredField("enabled");
			MyCurrValue.setAccessible(true);
			atm.insert(new Coin("PENNY"));
			atm.returnCoins();
			val = MyCurrValue.get(atm);
			assertEquals("0",val.toString());
		} catch (Exception e) {

		}
		// fail("Not yet implemented"); // TODO
	}*/

	/**
	 * Test method for {@link com.java.MyJunit.ATM#vend()}.
	 */
/*	@Test
	public void testVend() {
		ATM atm = new ATM();
		Object Currval;
		try {
			Field MyCurrValue = ATM.class.getDeclaredField("currValue");
			Field Myenabled = ATM.class.getDeclaredField("enabled");
			MyCurrValue.setAccessible(true);
			atm.insert(new Coin("SILVERDOLLAR"));
			atm.vend();
			Currval = MyCurrValue.get(atm);
			assertEquals("25",Currval.toString());
		} catch (Exception e) {

		}
		//fail("Not yet implemented"); // TODO
	}*/

}
