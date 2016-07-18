package com.accolite.thread;

import java.util.ArrayList;
import java.util.Scanner;

public class producer implements Runnable {
	
	private ArrayList<String> apple ;
	private ArrayList<String> orange ;
	private ArrayList<String> grape ;
	private ArrayList<String> watermelon ;
	
	producer(ArrayList<String> apple,ArrayList<String> orange,ArrayList<String> grape,ArrayList<String> watermelon)
	{
		this.apple=apple;
		this.orange=orange;
		this.grape=grape;
		this.watermelon=watermelon;
		
	}
  
	public synchronized void Add()
	{
		 Scanner scanner = new Scanner(System.in);  
         int choice;
         System.out.println("Number of apple(less than 5) ");
         choice=(scanner.nextInt());
		 if (isFull("apple")) {
			System.out
					.println("We can not accept more fruites at the moment !!");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interruption");
			}
		}
		 for(int i=0;i<5;i++)
		   apple.add("apple");
		System.out.printf("fruit : apple is added !!!");
		
		System.out.println("Number of orange(less than 5) ");
        choice=(scanner.nextInt());
		 if (isFull("orange")) {
			System.out
					.println("We can not accept more fruites at the moment !!");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interruption");
			}
		}
		 for(int i=0;i<5;i++)
		   apple.add("orange");
		System.out.printf("fruit : apple is added !!!");
	
	}
	
	private boolean isFull(String FruitName) {
		int count=0;
		if(FruitName.equals("apple"))
		 {
			for(int i=0;i<5;i++)
				if(apple.get(i)!=null)
					count++;
			if(count == 5)
				return true;
		 }
		if(FruitName.equals("orange"))
		 {
			for(int i=0;i<5;i++)
				if(orange.get(i)!=null)
					count++;
			if(count == 5)
				return true;
		 }
			 
		  
		return false;
	}

	@Override
	public void run() {
		Add();
		
	}

}
