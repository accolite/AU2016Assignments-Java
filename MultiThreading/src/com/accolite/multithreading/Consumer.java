package com.accolite.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner scanner = new Scanner( System.in );
		System.out.println("How many fruits you want to consume?");
		int input = scanner.nextInt();
		buffer.get(type,input);		
	}
}
