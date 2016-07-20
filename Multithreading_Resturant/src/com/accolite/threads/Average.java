package com.accolite.threads;

import java.util.ArrayList;

public class Average implements Runnable {

	
	private ArrayList<Integer> balance;
	private ArrayList<Integer> avg = new ArrayList<Integer>(1);
	
	private static int count;
	
	
	
	Average(ArrayList<Integer> b)
	{
		this.balance=b;
		avg.add(0,0);
		count=0;
		
		System.out.println("balance is"+ balance);
		System.out.println("average is"+ avg);
		
		
	}
	
	@Override
	public void run() {
		calculate_avg();
		
	}

	private void calculate_avg() {
		 count++;
		 int avg_cal;
		// not_t.run();
		 System.out.println("Now balance is " + balance.get(0));
		System.out.println("count is " + count);
     	avg_cal=balance.get(0)/count;
     	avg.add(0,avg_cal);
		System.out.println("avg now became" + avg.get(0));
				
		

	
		
		
	}
	public int return_avg()
	{
		return avg.get(0);
	}

}
