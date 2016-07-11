package com.accolite.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



import org.easymock.EasyMock;

public class AtmTest {

	Coin coinMock1;
	Coin coinMock2;
	Atm atmMock;

	@Ignore
	//Test for inserting coins
	@Test
	public void testInsertCoin() {
		Coin coin = new Coin();
        
		
		EasyMock.expect(coinMock1.getValue()).andReturn(Coin.PENNY);
		EasyMock.replay(coinMock1);
		System.out.println("PENNY:"+coinMock1.getValue());
		
		EasyMock.expect(coinMock2.getValue()).andReturn(Coin.NICKEL);
		EasyMock.replay(coinMock2);
		System.out.println("NICKEL:"+coinMock2.getValue());		
	}
	
	@Ignore
	//Test case for insert
	@Test
	public void testInsert(){
		Coin coin1 = new Coin("SilverDollar");
		Atm atm = new Atm();
		atm.insert(coin1);
		assertEquals("Passed",100,coin1.getValue());
        Coin coin2 = new Coin("Invalid");
		atm.insert(coin2);
		assertEquals("Passed",0,coin2.getValue());
	}
	
	@Ignore
	//Test case for returncoins
	@Test
	public void testReturnCoins(){
		Atm atm = new Atm();
		atm.returnCoins();
		assertEquals("Passed",0,atm.currValue);
		atm.currValue = 100;
		atm.returnCoins();
	}
	
	
	//Test case for vend
	@Test
	public void testVend() throws Exception{
		Atm atm = new Atm();
		atm.currValue = 100;
		atm.enabled = true;
		atm.vend();
		assertEquals("Passed", true, atm.enabled);
		Coin coin = new Coin("Penny");
		atm.insert(coin);
		atm.enabled = false;
		assertEquals("Passed",false,atm.enabled);
		atm.vend();
		atm.enabled = true;
		atm.currValue = 75;
		atm.vend();
		assertEquals("Passed",0,atm.currValue);
	}

	@Before
	public void setUp() {
		System.out.println("Mock variable is created");
		coinMock1 = EasyMock.createMock(Coin.class);
		coinMock2 = EasyMock.createMock(Coin.class);
		atmMock = EasyMock.createMock(Atm.class);
		
	}
}
