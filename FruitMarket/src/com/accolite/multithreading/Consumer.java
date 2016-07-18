package com.accolite.multithreading;

import java.util.ArrayList;

public class Consumer extends Thread
{
	FruitsBuffer buffer = new FruitsBuffer();
	ArrayList<String> type = null;
	String fruit = null;
	
	public Consumer(ArrayList<String> type)
	{
		this.type = type;
	}
	
	public void run()
	{
		buffer.get(type);		
	}
}
