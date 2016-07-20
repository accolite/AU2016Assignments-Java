package com.accolite.Multithreading_Restaurant;

import java.util.concurrent.BlockingQueue;

public class CalculateAvg implements Runnable {
	
	 /* The bill queue. */
	 BlockingQueue<Order> BillingQueue;
	 
	 /* The average queue. */
	 BlockingQueue<Double> averageQueue;
	 
	
	 public CalculateAvg (BlockingQueue<Order> BillingQueue,BlockingQueue<Double> averageQueue) {
	  
	  this.BillingQueue=BillingQueue;
	  this.averageQueue=averageQueue;
	  
	 }

	 
	 public void run() {
	  
	  Order newOrder=new Order();
	  int count=0;
	  double average=0;
	  while(true)
	  {
	   
	   try {
	    
	    newOrder=BillingQueue.take();
	    count++;
	    average=((average*(count-1))+newOrder.getAmount())/count;
	    averageQueue.put(average);
	    
	    
	   } catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	   
	  }
	  
	 }

}
