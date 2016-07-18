package com.accolite.MultithreadingAssignment;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java.util.Scanner;

public class FruitMarket {

public static void main (String[] args) throws InterruptedException {
	
	Thread t1;
	Thread t2;
	int cont=1;
	
	BlockingQueue appleQ = new ArrayBlockingQueue(5);
	BlockingQueue orangeQ = new ArrayBlockingQueue(5);
	BlockingQueue grapeQ = new ArrayBlockingQueue(5);
	BlockingQueue watermelonQ = new ArrayBlockingQueue(5);
	while(cont==1)
	{
	
	System.out.println("Enter the desired option");
	System.out.println("1.producer");
	System.out.println("2.consumer");
		
	Scanner in=new Scanner(System.in);
	   int input,fruit;
	   input=in.nextInt();
	  
	   switch (input) {
	   case 1:
	    Farmer farmer=new Farmer(appleQ, orangeQ, grapeQ, watermelonQ);
	    t1=new Thread(farmer);
	    t1.start();
	    t1.join();
	    break;
	 
	   case 2:
	    Consumer consumer=new Consumer(appleQ, orangeQ, grapeQ, watermelonQ);
	    t2=new Thread(consumer);
	    t2.start();
	    t2.join();
	    break;
	    
	   default:
	    System.out.println("option is Inappropriate ");
	    break;
	   }
	   
	   System.out.println("Continue (0/1)");
	   cont=in.nextInt();
	  }
	 }


	}	
					
