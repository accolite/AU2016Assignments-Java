package com.accolite.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

public class AccessingMarket {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub	
		ArrayList<String> apple = new ArrayList<String>(4);
		ArrayList<String> orange = new ArrayList<String>(4);
		ArrayList<String> grape = new ArrayList<String>(4);
		ArrayList<String> watermelon = new ArrayList<String>(4);
		
		int count = 1;
		
		while(true)
		{
			if(count==5)
			{
				break;
			}
		System.out.println("Are you producer or consumer?");
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		
		if(input.equals("producer"))
		{
			System.out.println("Which type of fruit you want to produce?");
			String type = scanner.nextLine();
			if(type.equals("apple"))
			{
			//FruitsBuffer buffer = new FruitsBuffer(apple);
			Producer producer = new Producer(apple);
			producer.start();
			}
			if(type.equals("orange"))
			{
			//FruitsBuffer buffer = new FruitsBuffer(orange);	
			Producer producer = new Producer(orange);
			producer.start();
			}
			if(type.equals("grape"))
			{
			//FruitsBuffer buffer = new FruitsBuffer(grape);
			Producer producer = new Producer(grape);
			producer.start();
			}
			if(type.equals("watermelon"))
			{
			Producer producer = new Producer(watermelon);
			producer.start();
			}
			
		}
		
		if(input.equals("consumer"))
		{
			System.out.println("which type of fruit you want to consume?");
			String type = scanner.nextLine();
			if(type.equals("apple"))
			{
				System.out.println("Hii");
			Consumer consumer = new Consumer(apple);
			consumer.start();
			}
			if(type.equals("orange"))
			{
			Consumer consumer = new Consumer(orange);
			consumer.start();
			}
			if(type.equals("grape"))
			{
			Consumer consumer = new Consumer(grape);
			consumer.start();
			}
			if(type.equals("watermelon"))
			{
			Consumer consumer = new Consumer(watermelon);
			consumer.start();
			}
		}
		
        count++;
		}
        
	}

}
