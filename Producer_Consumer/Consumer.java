package com.accolite.au.assignment6;

import java.util.Random;

public class Consumer extends Thread{
private Fruits fruits;
 
 public Consumer (Fruits fruits) {
	 this.fruits = fruits;
 }
 
 public void run () {
  while (true) {
  System.out.println ("Consumer is ready to buy fruits");
  Random randomValue = new Random();
  try {
   Thread.sleep(5000);  
   int type = randomValue.nextInt(4);   
   switch (type) {   
   case 0: 
	   fruits.consumeApple();
    System.out.println ("Apple Consumed");
    break;
   case 1: 
	   fruits.consumeOrange();
    System.out.println ("Orange Consumed");
    break;
   case 2: 
	   fruits.consumeGrape();;
    System.out.println ("Grape Consumed");
    break;
   default: 
	   fruits.consumeWatermelon();   
    System.out.println ("Watermelon Consumed");
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
  }
}
