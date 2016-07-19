package com.accolite.fruitMarket;

import java.util.Scanner;

public class ProduceConsume {

	public static void main(String[] args) throws InterruptedException {


		int capacity,choice;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter maximum capacity ");;
		capacity=sc.nextInt();
		RunningClass obj=new RunningClass(capacity);
		Thread th=new Thread(obj);
		System.out.println("Select if you are a consumer or producer 1.Consumer\n2.Producer\n3.Exit");
		choice=sc.nextInt();
		while(choice==1||choice==2)
		{
			th=new Thread(obj);
			if(choice==1)
			{

				th.setName("Consumer");
				th.start();
				th.join();
			}
			else if(choice==2)
			{
				th.setName("Producer");
				th.start();
				th.join();
			}
			else 
			{
				sc.close();
				return ;
			}
			System.out.println("Select if you are a consumer or producer 1.Consumer\n2.Producer\n3.Exit");
			choice=sc.nextInt();
		}
		sc.close();
	}
}
