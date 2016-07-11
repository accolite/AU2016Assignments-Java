package com.accolite.atm;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Created by Diksha Garg on 7/11/2016.
 */
public class ATMTest {


    private PrintStream outputStream;
    private PrintStream errorStream;
    Coin coinObject;
    ATM atmObject;

    @Before
    public void setUpStreams() {
        outputStream = mock(PrintStream.class);
        errorStream = mock(PrintStream.class);
        System.setOut(outputStream);
        System.setErr(errorStream);

        coinObject = mock(Coin.class);
        atmObject = new ATM();

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    
    
    @Test
    public void testInsertCase(){



        when(coinObject.getValue()).thenReturn(0);
        atmObject.insert(coinObject);
        //verify(errorStream).print("illegal value");
        errorStream.toString().toLowerCase().contains("illegal value");


        when(coinObject.getValue()).thenReturn(1);
        atmObject.insert(coinObject);
        verify(outputStream).print("Current value = 1");

        when(coinObject.getValue()).thenReturn(5);
        atmObject.insert(coinObject);
        verify(outputStream).print("Current value = 6");

        when(coinObject.getValue()).thenReturn(10);
        atmObject.insert(coinObject);
        verify(outputStream).print("Current value = 16");


        when(coinObject.getValue()).thenReturn(25);
        atmObject.insert(coinObject);
        verify(outputStream).print("Current value = 41");


        when(coinObject.getValue()).thenReturn(50);
        atmObject.insert(coinObject);
        verify(outputStream).print("Current value = 91");

        when(coinObject.getValue()).thenReturn(100);
        atmObject.insert(coinObject);
        verify(outputStream).print("Current value = 191");

    }

    
    @Test
    public void testReturnCoins(){

        ATM atm = new ATM();
        
        errorStream.flush();
        atm.returnCoins();
        errorStream.toString().toLowerCase().contains("no coins to return");
        
        
        when(coinObject.getValue()).thenReturn(50);
        
        atm.insert(coinObject);
        outputStream.flush();
        atm.returnCoins();
        outputStream.toString().toLowerCase().contains("Take your coins");
        //verify(outputStream).print( "Take your coins" );


    }



   

    @Test
    public void testVent() throws Exception {
    	try{
    		
    		ATM atm=new ATM();
            atm.vend();
            outputStream.toString().toLowerCase().contains("Not enough credit: add 75");
            
            when(coinObject.getValue()).thenReturn(75);
            atm.insert(coinObject);
            outputStream.flush();
            atm.vend();
            outputStream.toString().toLowerCase().contains("Get your drink");
            
            
            when(coinObject.getValue()).thenReturn(-100);
            atm.insert(coinObject);
            outputStream.flush();
            atm.vend();


    	}catch(Exception e)
    	{
    		e.getMessage().equals("Error: negative credit!");
    	}
        
    }


}

