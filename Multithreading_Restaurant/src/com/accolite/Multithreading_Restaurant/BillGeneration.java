package com.accolite.Multithreading_Restaurant;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BillGeneration implements Runnable {
	
	
	 BlockingQueue<Order> BillingQueue=new ArrayBlockingQueue<>(1);
	 
	 /* The amount. */
	 int amount;
	 
	 public BillGeneration(BlockingQueue<Order> BillingQueue) {
	  
	  this.BillingQueue=BillingQueue;
	 
	 }

	 
	 public void run() {
	  
	  Order order=new Order();
	  Scanner input=new Scanner(System.in);
	  
	  while(true)
	  {
	   System.out.println("Enter the table number");
	   order.setTableNo(input.nextInt());
	   System.out.println("Enter the bill amount\n");
	   order.setAmount(input.nextDouble());
	   
	   try {
	    BillingQueue.put(order);
	   } catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	  
	 }

}
