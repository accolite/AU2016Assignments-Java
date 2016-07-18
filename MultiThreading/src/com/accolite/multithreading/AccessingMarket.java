package com.accolite.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

public class AccessingMarket {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub	
		ArrayList<String> apple = new ArrayList<String>(4);
		ArrayList<String> orange = new ArrayList<String>(4);
		ArrayList<String> grape = new ArrayList<String>(4);
		ArrayList<String> watermelon = new ArrayList<String>(4);
		FruitsBuffer buffer = null;
		
		while(true)
		{
		System.out.println("Are you producer or consumer?");
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		
		if(input.equals("producer"))
		{
			System.out.println("Which type of fruit you want to produce?");
			String type = scanner.nextLine();
			if(type.equals("apple"))
			{
				//System.out.println();
			Producer producer = new Producer(apple);
			producer.start();
			producer.join();
		
			}
			if(type.equals("orange"))
			{
			//FruitsBuffer buffer = new FruitsBuffer(orange);	
			Producer producer = new Producer(orange);
			producer.start();
			producer.join();
			
			}
			if(type.equals("grape"))
			{
			//FruitsBuffer buffer = new FruitsBuffer(grape);
			Producer producer = new Producer(grape);
			producer.start();
			producer.join();
		
			}
			if(type.equals("watermelon"))
			{
			Producer producer = new Producer(watermelon);
			producer.start();
			producer.join();
			}
			
		}
		
		else if(input.equals("consumer"))
		{
			System.out.println("which type of fruit you want to consume?");
			String type = scanner.nextLine();
			if(type.equals("apple"))
			{
			Consumer consumer = new Consumer(apple);
			consumer.start();
			consumer.join();
			}
			if(type.equals("orange"))
			{
			Consumer consumer = new Consumer(orange);
			consumer.start();
			consumer.join();
			}
			if(type.equals("grape"))
			{
			Consumer consumer = new Consumer(grape);
			consumer.start();
			consumer.join();
			}
			if(type.equals("watermelon"))
			{
			Consumer consumer = new Consumer(watermelon);
			consumer.start();
			consumer.join();
			}
		}
		
		else
		{
			System.out.println("Terminate");
			break;
		}
		
       
		}
        
	}

}
