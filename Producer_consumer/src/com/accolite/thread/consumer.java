package com.accolite.thread;

import java.util.ArrayList;
import java.util.Scanner;

public class consumer implements Runnable 
{
	private ArrayList<String> apple ;
	private ArrayList<String> orange ;
	private ArrayList<String> grape ;
	private ArrayList<String> watermelon ;
	
	
	consumer(ArrayList<String> apple,ArrayList<String> orange,ArrayList<String> grape,ArrayList<String> watermelon)
	{
		this.apple=apple;
		this.orange=orange;
		this.grape=grape;
		this.watermelon=watermelon;
		
	}
	
	public int size()
	{
		return apple.size();
	}
	public synchronized void  Buy() {

		 
         Scanner scanner = new Scanner(System.in);  
         int choice;
         int count=0;
         
         String currentFruitRecusted;
         System.out.println("Number of apple");
         choice=(scanner.nextInt());
         System.out.println(apple.size());
		if (isEmpty("apple")) {
			System.out.println("we don't have any goods yet");
		}
		else 
		{
			
		for( int j=0;j<5;j++)
			  if(apple.get(j) != null)
				  count++;
		 if((count - choice) < 0 )
			System.out.println("Fewer apple are available");
			
		 else
			{
		
			for(int i1=0;i1<choice;i1++)
				 currentFruitRecusted = apple.remove(i1);
			System.out.println(choice +" apples removed");
			}
		}
		
		 System.out.println("Number of orange");
         choice=(scanner.nextInt());
         System.out.println(orange.size());
		if (isEmpty("orange")) {
			System.out.println("we don't have any goods yet");
		}
		else 
		{
			
		for( int j=0;j<5;j++)
			  if(orange.get(j) != null)
				  count++;
		 if((count - choice) < 0 )
			System.out.println("Fewer apple are available");
			
		 else
			{
		
			for(int i1=0;i1<choice;i1++)
				 currentFruitRecusted = orange.remove(i1);
			System.out.println(choice +" oranges removed");
			}
		}
}
	private boolean isEmpty(String FruitName) {
		    
		   if(FruitName.equals("apple"))
			  return apple.isEmpty();
		  if(FruitName.equals("grape"))
			  return grape.isEmpty();
		  if(FruitName.equals("orange"))
			  return orange.isEmpty();
		  if(FruitName.equals("watermelon"))
			  return watermelon.isEmpty();
		return false;
	}
	@Override
	public void run() {
		Buy();
		
	}
}