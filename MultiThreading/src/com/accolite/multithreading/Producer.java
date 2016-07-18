package com.accolite.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner scanner = new Scanner( System.in );
		System.out.println("How many fruits you want to produce?");
		int input = scanner.nextInt();
		buffer.put(type,input);

	}
	

}
