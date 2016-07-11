package com.accolite.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class CoinTest extends TestCase {

    //Setup function
    public void setUp() throws Exception {
        System.out.println("Set up function is called");
    }

    //Teardown function
    public void tearDown() {
    	System.out.println("Tear down function is called");
    }
    
    //Test case 1
    @Test
    public void testInsert() {
    	Coin coin1 = new Coin("penny");
        System.out.println("Test case for insertion");
        System.out.println(coin1.toString());
        assertEquals("Test case passed",1,coin1.getValue());    
       
        Coin coin2 = new Coin("Invalid");
        assertEquals("Test case passed",0,coin2.getValue());
        
        Coin coin3 = new Coin("Nickel");
        assertSame("Test case passed",5,coin3.getValue());
        
        Coin coin4 = new Coin("Dime");
        assertSame("Test case passed",10,coin4.getValue());
        
        Coin coin5 = new Coin("Quarter");
        assertEquals("Test case passed",25,coin5.getValue());
        
        Coin coin6 = new Coin("Halfdollar");
        assertEquals("Test case passed",50,coin6.getValue());
        
        Coin coin7 = new Coin("Silverdollar");
        assertNotSame("Test case passed",1,coin7.getValue());
        
    }

    //Test case 2
   //Example for @ignore
    @Ignore
	@Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }
    
    //Test case 3
    //Example for timeout
    @Test(timeout = 5000)
    public void testSlowMethod() {
        System.out.println("Wait for few more seconds..Under process");
    }
}
