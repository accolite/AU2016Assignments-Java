package com.accolite.Multithreading_Restaurant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Restaurant {
	
	 
	 public static void main(String[] args) throws InterruptedException {
	 
	  BlockingQueue<Order> BillingQueue=new ArrayBlockingQueue<>(1);
	  BlockingQueue<Double> averageQueue=new ArrayBlockingQueue<>(1);
	  
	  Thread billGenerationThread;
	  Thread calculateAverageThread;
	  Thread notificationToOwnerThread;
	  
	  BillGeneration billGeneration;
	  CalculateAvg calculateAverage;
	  NotifyOwner notificationToOwner;
	  
	  billGeneration=new BillGeneration(BillingQueue);
	  billGenerationThread=new Thread(billGeneration);
	   
	  calculateAverage=new CalculateAvg(BillingQueue,averageQueue);
	  calculateAverageThread=new Thread(calculateAverage);
	   
	  notificationToOwner=new NotifyOwner(BillingQueue,averageQueue);
	  notificationToOwnerThread=new Thread(notificationToOwner);
	     
	  billGenerationThread.start();
	  
	  calculateAverageThread.start();
	  
	  notificationToOwnerThread.start();
	    
	 
	 }

}
