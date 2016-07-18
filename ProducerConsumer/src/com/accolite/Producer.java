package com.accolite;

import java.util.ArrayList;

public class Producer extends Thread
{
	FruitsBuffer buffer = new FruitsBuffer();
	ArrayList<String> type = null;
	
	public Producer(ArrayList<String> type)
	{
		this.type=type;
	}
	
	public void run()
	{
		buffer.put(type);

	}
	

}
