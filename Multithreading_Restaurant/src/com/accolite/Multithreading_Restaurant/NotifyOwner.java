package com.accolite.Multithreading_Restaurant;

import java.util.concurrent.BlockingQueue;

public class NotifyOwner implements Runnable {
	
	/* The bill queue. */
	BlockingQueue<Order> BillingQueue;

	/* The average queue. */
	BlockingQueue<Double> averageQueue;

	 public NotifyOwner(BlockingQueue<Order> BillingQueue, BlockingQueue<Double> averageQueue){
	  
	  this.BillingQueue=BillingQueue;
	  this.averageQueue=averageQueue;
	  
	 }

	 
	 public void run() {
	  
	  double average;
	  
	  while(true){
	   
	   try {
	    average=averageQueue.take();
	    System.out.println("New Average is: "+average);
	    
	   } catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	   
	  }
	  
	 }
	}
