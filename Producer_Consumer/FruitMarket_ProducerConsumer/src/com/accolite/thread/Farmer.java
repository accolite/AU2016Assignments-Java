package com.accolite.thread;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Farmer {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue apple = new ArrayBlockingQueue(10);
		BlockingQueue orange = new ArrayBlockingQueue(10);
		BlockingQueue grape = new ArrayBlockingQueue(10);
		BlockingQueue watermelon = new ArrayBlockingQueue(10);
		Producer producer = new Producer(apple, orange, grape, watermelon);
	    Consumer consumer = new Consumer(apple, orange, grape, watermelon);
		while(true) {
			System.out.println("1.Choose Producer 2. Choose consumer 3. Terminate");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			Thread t1 = new Thread(producer);
			Thread t2 = new Thread(consumer);
			if(option == 1) {
				t1.start();
				t1.join();
			} else if(option == 2) {
				t2.start();
				t2.join();
			} else {
				break;
			}
		}
		
		
		
		
	}
}
