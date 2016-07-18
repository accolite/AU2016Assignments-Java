package com.accolite.multithreading;

import java.awt.List;
import java.util.ArrayList;

public class FruitsBuffer 
{
	int appleSize;
	int orangeSize;
	int grapeSize;
	int watermelonSize;
	
	ArrayList<String> apple = null;
	ArrayList<String> orange = null;
	ArrayList<String> grape = null;
	ArrayList<String> watermelon = null;
	

	public boolean isFull(ArrayList<String> type)
	{
		if(type.size()==4)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	public boolean isEmpty(ArrayList<String> type)
	{
		if(type.isEmpty())
		{
			return true;
		}
		return false;
	
	}
	
	public synchronized void put(ArrayList<String> type,int n)
	{
		for(int i=1 ;i<=n ;i++)
		{
			if(isFull(type))
			{
				System.out.println("List is Full");
				break;
//				 try{
//				 //set the current thread to wait
//				 wait();
//				 }catch(InterruptedException ex){
//				 //someone wake me up.
//			 }
			}
		
			type.add("fruit");
			System.out.println("Fruit added");
			notifyAll();
			
		}
		
		
	}
	
	public synchronized void get(ArrayList<String> type,int n)
	{
		for(int i=1;i<=n;i++)
		{
			String fruit = null;
			if(isEmpty(type))
			{
				System.out.println("Fruit Basket is Empty");
				break;
//			try{
//					 //set the current thread to wait
//					 wait();
//					 	
//					 }catch(InterruptedException ex)
//						{
//					 //someone wake me up.
//						 
//					 }
			}
			
				fruit = type.remove(0); //consume the first fruit in the list
				notifyAll();//wakeup all the waiting thread to proceed
				System.out.println(fruit);
		}
		
		}
				 
	
}
