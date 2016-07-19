package org.au.restaurant;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Restaurant {
	
	public static void main(String[] args) {
		BlockingQueue<Order> orders = new ArrayBlockingQueue<>(1);
		BlockingQueue<Double> averageQueue = new ArrayBlockingQueue<>(1);
		Thread t1=null;
		Thread t2=null;
		Thread t3=null;
		t1 = new Thread(new Biller(orders));
		t2 = new Thread(new AverageCalculator(orders,averageQueue));
		t3 = new Thread(new AverageReporter(averageQueue));
		
		t1.start();
		t2.start();
		t3.start();
}
}
