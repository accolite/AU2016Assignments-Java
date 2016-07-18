package com.accolite.MultithreadingAssignment;


import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
 
 BlockingQueue appleQ=new ArrayBlockingQueue(5);
 BlockingQueue orangeQ=new ArrayBlockingQueue(5);
 BlockingQueue grapeQ=new ArrayBlockingQueue(5);
 BlockingQueue watermelonQ=new ArrayBlockingQueue(5);
 
 public Consumer(BlockingQueue appleQ, BlockingQueue orangeQ, BlockingQueue grapeQ, BlockingQueue watermelonQ) {
  
  this.appleQ=appleQ;
  this.orangeQ=orangeQ;
  this.grapeQ=grapeQ;
  this.watermelonQ=watermelonQ;
  
 }

public void run() {
  // TODO Auto-generated method stub
  
  Scanner in=new Scanner(System.in);
  int fruit,quantity;
  System.out.println("Choose fruit you want to consume:");
  System.out.println("1. apple\n 2. orange\n 3. grape\n 4. watermelon");
  
  fruit=in.nextInt();
  
  System.out.println("Enter the quantity:");
  quantity=in.nextInt();
  int i,consumed;
  
  switch (fruit) {
  case 1:
   if(appleQ.size()-quantity<0)
    System.out.println("There is not enough space");
   for(i=0;i<quantity;i++)
    try {
     consumed=(int)appleQ.take();
     System.out.println("Apple is consumed");
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   break;

  case 2:
   if(orangeQ.size()-quantity<0)
    System.out.println("There is not enough space");
   for(i=0;i<quantity;i++)
    try {
     consumed=(int)orangeQ.take();
     System.out.println("Orange is consumed");
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   break;
   
  case 3:
   if(grapeQ.size()-quantity<0)
    System.out.println("There is not enough space");
   for(i=0;i<quantity;i++)
    try {
     consumed=(int)grapeQ.take();
     System.out.println("Grape is consumed");
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   break;
   
  case 4:
   if(watermelonQ.size()-quantity<0)
    System.out.println("There is not enough space");
   for(i=0;i<quantity;i++)
    try {
     consumed=(int)watermelonQ.take();
     System.out.println("Watermelon is consumed");
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

