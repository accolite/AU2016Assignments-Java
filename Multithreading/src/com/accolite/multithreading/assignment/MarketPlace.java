package com.accolite.multithreading.assignment;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class MarketPlace {
	public static void main(String[]args) throws InterruptedException
    {
//public static void main(String[] args) throws InterruptedException {
	BlockingQueue apple = new ArrayBlockingQueue(10);
	BlockingQueue orange = new ArrayBlockingQueue(10);
	BlockingQueue grape = new ArrayBlockingQueue(10);
	BlockingQueue watermelon = new ArrayBlockingQueue(10);
	ProducerClass producer = new ProducerClass(apple, orange, grape, watermelon);
    ConsumerClass consumer = new ConsumerClass(apple, orange, grape, watermelon);
    
    	
	while(true) {
		System.out.println("Enter 1 for  Producer \n Enter 2 for consumer \n Enter 3 for  Terminate");
		Scanner entry = new Scanner(System.in);
		int choice = entry.nextInt();
		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(consumer);
		if(choice == 1) {
			thread1.start();
			thread1.join();
		} else if(choice == 2) {
			thread2.start();
			thread2.join();
		} else {
			break;
		}
	}
	
	
	
	
}
}