package com.accolite.MultithreadingAssignment;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Farmer implements Runnable {

	 private int apple=0, orange=0, grape=0, watermelon=0;
	 
	 BlockingQueue appleQ=new ArrayBlockingQueue(5);
	 BlockingQueue orangeQ=new ArrayBlockingQueue(5);
	 BlockingQueue grapeQ=new ArrayBlockingQueue(5);
	 BlockingQueue watermelonQ=new ArrayBlockingQueue(5);
	 
	 public Farmer(BlockingQueue appleQ, BlockingQueue orangeQ, BlockingQueue grapeQ, BlockingQueue watermelonQ) {
	  
	  this.appleQ=appleQ;
	  this.orangeQ=orangeQ;
	  this.grapeQ=grapeQ;
	  this.watermelonQ=watermelonQ;
	  
	 }
	 
	 public void run() {
	  // TODO Auto-generated method stub
	  
	  Scanner in=new Scanner(System.in);
	  int fruit,quantity;
	  System.out.println("Choose fruit you want to produce:");
	  System.out.println("1. apple\n 2. orange\n 3. grape\n 4. watermelon");
	  
	  fruit=in.nextInt();
	  
	  System.out.println("Enter the quantity:");
	  quantity=in.nextInt();
	  //System.out.println(appleQueue.size());
	  int i;
	  switch (fruit) {
	  case 1:
	   if((appleQ.size()+quantity)>5)
	    System.out.println("There is not enough space");
	   for(i=0;i<quantity;i++)
	    try {
	     appleQ.put(1);
	     System.out.println("Apple is added");
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   break;

	  case 2:
	   if((orangeQ.size()+quantity)>5)
	    System.out.println("There is not enough space");
	   for(i=0;i<quantity;i++)
	    try {
	     orangeQ.put(2);
	     System.out.println("Orange is added");
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   break;
	   
	  case 3:
	   if((grapeQ.size()+quantity)>5)
	    System.out.println("There is not enough space");
	   for(i=0;i<quantity;i++)
	    try {
	     grapeQ.put(3);
	     System.out.println("Grape is added");
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   break;
	   
	  case 4:
	   if((watermelonQ.size()+quantity)>5)
	    System.out.println("There is not enough space");
	   for(i=0;i<quantity;i++)
	    try {
	     watermelonQ.put(4);
	     System.out.println("Watermelon is added");
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   break;
	   
	  default:
	   System.out.println("Inappropriate option");
	   break;
	  }


	 } 
}