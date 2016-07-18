package com.accolite;

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
	
	public synchronized void put(ArrayList<String> type)
	{
		while(isFull(type))
		{
			System.out.println("List is Full");
			 try{
			 //set the current thread to wait
			 wait();
			 }catch(InterruptedException ex){
			 //someone wake me up.
		 }
		}
	
		type.add("fruit");
		System.out.println("Fruit added");
		notifyAll();
		
		
	}
	
	public synchronized void get(ArrayList<String> type)
	{
		String fruit = null;
		while(isEmpty(type))
		{
			System.out.println("Fruit Basket is empty");
			try{
				 //set the current thread to wait
				 wait();
				 }catch(InterruptedException ex){
				 //someone wake me up.
				 }
		}
		
			fruit = type.remove(0); //consume the first fruit in the list
			notifyAll();//wakeup all the waiting thread to proceed
			System.out.println(fruit);
		}
				 
	
}