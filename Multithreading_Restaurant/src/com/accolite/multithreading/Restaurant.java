package com.accolite.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
	
	Bill bill;
	
	ExecutorService exec = Executors.newCachedThreadPool();
	
	BillPayment payment = new BillPayment(this);
	AverageBill avgbill = new AverageBill(this);
	NotifyOwner owner = new NotifyOwner(this);
	public Restaurant()
	{
		exec.execute(payment);
		exec.execute(avgbill);
		exec.execute(owner);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Restaurant();
				
	}

}
