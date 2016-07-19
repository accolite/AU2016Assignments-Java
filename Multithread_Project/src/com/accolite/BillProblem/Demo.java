/*
  * Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Chirag Bansal

* ***************************************************************************
 */
package com.accolite.BillProblem;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
	//shared resources
	
	public static void main(String args[])
	{
		float bill_amount;
		ArrayBlockingQueue average=new ArrayBlockingQueue<>(1);
		
		int no_of_bills=0;
		Scanner inp= new Scanner(System.in);
		//GenerateBill bill_interface=new GenerateBill(0,average,no_of_bills);
		GettingAverage average_interface = new GettingAverage(0,average,no_of_bills);
		NotifyManager manager_interface=new NotifyManager(average);
		while(true)
		{
			bill_amount=inp.nextFloat();
		
			average_interface.setBill_amount(bill_amount);
			
			Thread average_thread= new Thread(average_interface);
			average_thread.start();
			
			
			Thread manager_thread=new Thread(manager_interface);
			manager_thread.start();
			
			
		}
		
	}
}
