package com.accolite.JunitATM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinTest {
	Coin c;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetValue() {
		c=new Coin("PENNY");
		assertEquals("testing Penny",1,c.getValue());
		
		c=new Coin("NICKEL");
		assertEquals("testing Penny",5,c.getValue());
		
		c=new Coin("DIME");
		assertEquals("testing Penny",10,c.getValue());
		
		c=new Coin("QUARTER");
		assertEquals("testing Penny",25,c.getValue());
		
		c=new Coin("HALFDOLLAR");
		assertEquals("testing Penny",50,c.getValue());
		
		c=new Coin("SILVERDOLLAR");
		assertEquals("testing Penny",100,c.getValue());
		
		c=new Coin("INVALID");
		assertEquals("testing Penny",0,c.getValue());
		
		
		
	}
	@Test
	public void testtoString() {
		c=new Coin("PENNY");
		assertEquals("testing Penny","1",c.toString());
		
		c=new Coin("NICKEL");
		assertEquals("testing Penny","5",c.toString());
		
		c=new Coin("DIME");
		assertEquals("testing Penny","10",c.toString());
		
		c=new Coin("QUARTER");
		assertEquals("testing Penny","25",c.toString());
		
		c=new Coin("HALFDOLLAR");
		assertEquals("testing Penny","50",c.toString());
		
		c=new Coin("SILVERDOLLAR");
		assertEquals("testing Penny","100",c.toString());
		
		c=new Coin("INVALID");
		assertEquals("testing Penny","0",c.toString());
		
		
		
	}

}
