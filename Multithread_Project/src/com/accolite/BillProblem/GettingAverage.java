package com.accolite.BillProblem;

import java.util.concurrent.ArrayBlockingQueue;

public class GettingAverage implements Runnable {
	float bill_amount;
	float prev_av=0;
	ArrayBlockingQueue average=null;
	int no_of_bills;
	
	public GettingAverage() {
		super();
	}

	public GettingAverage(float bill_amount, ArrayBlockingQueue average,int no_of_bills) {
		super();
		this.bill_amount = bill_amount;
		this.average = average;
		this.no_of_bills=no_of_bills;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		no_of_bills++;
		//System.out.println(prev_av);
		float new_average=(prev_av*(no_of_bills-1)+bill_amount)/no_of_bills;
		
			
			
	
			prev_av=new_average;
		try {
			average.put(new_average);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public float getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}

}
