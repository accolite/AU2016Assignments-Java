package com.accolite.demo;

import java.util.Scanner;

public class producerconsumer {
	public static void main(String args[]) throws InterruptedException{
		
		System.out.println("enter the maximum quantity of buffer");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int choice=1;
		MyThread runnable=new MyThread(i);
		Thread thread;
		System.out.println("enter your choice 1.) producer    2.)consumer ");
		while(choice==1||choice==2){
		
		
		thread=new Thread(runnable);
		choice=sc.nextInt();
		
		thread.setName("producer");
		
		
		
		if(choice==1)
		{
			thread.start();
			thread.join();
		}
		else if (choice==2)
		{
			thread.setName("consumer");
			thread.start();
			thread.join();
		}
		System.out.println("enter your choice 1.) producer    2.)consumer ");
		}
			
	}
	

}
