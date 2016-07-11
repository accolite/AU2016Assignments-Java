package com.accolite.UnitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
			ATM atm1=Mockito.mock(ATM.class);
			assertNotNull("Mocked Object Created",atm1);
	}

	/**
	 * Test insert 1.
	 */
	@Test
	public void testInsert1() {
		coin1=Mockito.mock(Coin.class);
		atm.insert(coin1);
		Mockito.when(coin1.getValue()).thenReturn(0);
	}
	
	/**
	 * Test insert 2.
	 */
	@Test
	public void testInsert2() {
		coin2=new Coin("HALFDOLLAR");
		atm.insert(coin2);
		
	}
	
	/**
	 * Test insert 3.
	 */
	@Test
	public void testInsert3() {
		coin3=new Coin("SILVERDOLLAR");
		atm.insert(coin3);
		
	}


	/**
	 * Test return coins 1.
	 */
	@Test
	public void testReturnCoins1() {
		coin1=Mockito.mock(Coin.class);
		atm.returnCoins();
		//Mockito.when(coin1.getValue()).thenReturn(0);
	
	}
	
	/**
	 * Test return coins 2.
	 */
	@Test
	public void testReturnCoins2() {
		coin3=new Coin("SILVERDOLLAR");
		atm.insert(coin3);
		atm.returnCoins();
		//Mockito.when(coin1.getValue()).thenReturn(0);
	
	}
		
		
	/**
	 * Test vend 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testVend1() throws Exception {
		coin3=new Coin("SILVERDOLLAR");
		atm.insert(coin3);
		atm.vend();
	}
	
	/**
	 * Test vend 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testVend2() throws Exception {
		coin2=new Coin("QUARTER");
		coin3=new Coin("HALFDOLLAR");
		atm.insert(coin2);
		atm.insert(coin3);
		atm.vend();
	}
	
	/**
	 * Test vend 3.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testVend3() throws Exception{
		atm.vend();
	}
	
	/**
	 * Test vend 4.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testVend4() throws Exception{
		coin1=new Coin("QUARTER");
		coin2=new Coin("HALFDOLLAR");
		coin3=new Coin("PENNY");
		atm.insert(coin1);
		atm.insert(coin2);
		//atm.insert(coin3);
		atm.insert(coin3);
		atm.vend();
		atm.vend();
		
		
	}
	
// Tried to test PowerMockRunner - failed	
//	@Test
//	public void testVend4() throws Exception{
//		ATM atm2=new ATM();
//		MemberModifier.field(ATM.class, "enabled").set(atm2 , true);
//		MemberModifier.field(ATM.class, "currValue").set(atm2 , -1);
//		//atm.insert(coin1);
//		//atm.insert(coin2);
//		//atm.insert(coin3);
//		//atm.insert(coin3);
//		atm.vend();
//		//atm.vend();
//		
//		
//	}
}
