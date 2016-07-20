package com.accolite.restaurant;

import java.util.ArrayList;

public class BillAmount extends Thread{
	
	int tableNumber;
	double tableAmount;
	BillAmount(int tableNumber,double tableAmount)
	{
		this.tableNumber=tableNumber;
		this.tableAmount=tableAmount;
	}
	
	 static int count=0;
	 private ArrayList<Double> tables = new ArrayList<Double>();
	 
	    public void run() {
	        try {
	            	putBillAmount(tableAmount);
	                sleep( 1000 );
	            } 
	        catch( InterruptedException e ) { 
	        	e.printStackTrace();
	        }
	    }
	 
	    private synchronized void putBillAmount(double billAmount) throws InterruptedException
	    {
	       	count=count+1;
	        tables.add(billAmount);
	        notify();
	    }
	 
	    // Called by AverageBillAmount
	    public synchronized double getBillAmount() throws InterruptedException
	    {
	        notify();
	        while ( tables.size()==0 )
	            wait();
	        return tableAmount;
	    }

}
