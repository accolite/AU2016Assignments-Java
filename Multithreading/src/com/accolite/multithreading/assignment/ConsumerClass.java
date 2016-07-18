package com.accolite.multithreading.assignment;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConsumerClass extends Thread {
	protected BlockingQueue apple = null;
	 protected BlockingQueue orange = null;
	 protected BlockingQueue grape = null;
	 protected BlockingQueue watermelon = null; 

	 public ConsumerClass(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon ) {
	  this.apple = apple;
	  this.orange = orange;
	  this.grape = grape;
	  this.watermelon = watermelon;  
	 }
	 public void run() {
			int choice = 0;
			Scanner entry = new Scanner(System.in);boolean f=true;
			while(f) {
			System.out.println("1.For consuming Apple?\n 2.For consuming orange\n 3.For consuming grape\n 4.For consume watermelon\n 5.To stop consuming");
			choice = entry.nextInt();int num; 
			switch(choice)
			{
			case 1:
				System.out.println("Enter no. of apple wants to consume");
				num= entry.nextInt();
				if(apple.size()>=num) {
					for (int i = 0; i < num; i++) {
						apple.remove();
						System.out.println("Consumed apple");
						
					}
				} else 
					System.out.println("Not possible");
				
				break;
			case 2:
				System.out.println("Enter no. of orange wants to consume");
				num = entry.nextInt();
				if(orange.size() >= num) {
					for (int i = 0; i < num; i++) {
						orange.remove();
						System.out.println("Consumed Orange");
					}
				} else 
					System.out.println("Not possible");
				
				break;
			
			case 3:
				System.out.println("Enter no. of grape wants to consume");
				num = entry.nextInt();
				if(grape.size() >= num) {
					for (int i = 0; i < num; i++) {
						grape.remove();
						System.out.println("Consumed Grape");
					}
				} else {
					System.out.println("Not possible");
				}
				break;
				
			case  4:
				System.out.println("Enter no. of watermelon wants to consume");
				num = entry.nextInt();
				if(watermelon.size() >= num) {
					for (int i = 0; i < num; i++) {
						watermelon.remove();
						System.out.println("Consumed Watermelon");
					}
				} else 
					System.out.println("Not possible");
				 break;
			default:f=false;
				break;
			}
			
}

		

	}
	 
}
