package com.accolite.PCProblem;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FrontFace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BlockingQueue apple = new ArrayBlockingQueue(5);
		 BlockingQueue orange = new ArrayBlockingQueue(5);
		 BlockingQueue grape = new ArrayBlockingQueue(5);
		 BlockingQueue watermelon = new ArrayBlockingQueue(5);
		 
		 
		 Producer.MAX_SIZE=5;
		 
		 Consumer.MAX_SIZE=5;
		 
		 Scanner inp= new Scanner(System.in);
		 while(true)
		 {
		 System.out.println("1:producer"+"2:consumer");
		 int ch=inp.nextInt();
		 if(ch==1)
		 {
			 System.out.println("enter number of apples,orange,grape,watermelon to be added");
			 int apples_no=inp.nextInt();
			 int orange_no=inp.nextInt();
			 int grape_no=inp.nextInt();
			 int watermelon_no=inp.nextInt();
			 Producer producer_interface=new Producer(apple,orange,grape,watermelon,apples_no,orange_no,grape_no,watermelon_no);
			 Thread producer_thread=new Thread(producer_interface);
			 producer_thread.start();
			 
		 }
		 else
		 {
			 System.out.println("enter number of apples,orange,grape,watermelon to be consumed");
			 int apples_no=inp.nextInt();
			 int orange_no=inp.nextInt();
			 int grape_no=inp.nextInt();
			 int watermelon_no=inp.nextInt();
			 Consumer consumer_interface=new Consumer(apple,orange,grape,watermelon,apples_no,orange_no,grape_no,watermelon_no);
			 Thread consumer_thread=new Thread(consumer_interface);
			 consumer_thread.start();
		 }
		 
		 
		 }

	}

}
