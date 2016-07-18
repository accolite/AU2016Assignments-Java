package com.accolite.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Market {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue apple = new ArrayBlockingQueue(5);
		BlockingQueue orange = new ArrayBlockingQueue(5);
		BlockingQueue grape = new ArrayBlockingQueue(5);
		BlockingQueue watermelon = new ArrayBlockingQueue(5);

		 
	        Producer farmer = new Producer(apple,orange,grape,watermelon);
	        Consumer consumer = new Consumer(apple,orange,grape,watermelon);

	        Thread t1=new Thread(farmer,"Farmer1");
	       // Thread t2=new Thread(farmer,"Farmer2");
	       // Thread t3=new Thread(farmer,"Farmer3");
	        Thread t4=new Thread(consumer,"Consumer1");
	        Thread t5=new Thread(consumer,"Consumer2");
	        t1.start();
	       // t2.start();
	       // t3.start();
	        t4.start();
	        t5.start();
	}
}

