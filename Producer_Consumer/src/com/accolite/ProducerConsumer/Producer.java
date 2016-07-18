package com.accolite.ProducerConsumer;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	protected BlockingQueue apple = null;
	protected BlockingQueue orange = null;
	protected BlockingQueue grape = null;
	protected BlockingQueue watermelon = null;
	AtomicInteger atapple=new AtomicInteger(1);
	AtomicInteger atorange=new AtomicInteger(1);
	AtomicInteger atgrape=new AtomicInteger(1);
	AtomicInteger atwatermelon=new AtomicInteger(1);
	Scanner sc;
	public Producer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon) {
		super();
		this.apple = apple;
		this.orange = orange;
		this.grape = grape;
		this.watermelon = watermelon;
		sc=new Scanner(System.in);
	}


	public void run() {
		for (int i = 0; i < 10; i++) {
		if(Thread.currentThread().getName().equals("Farmer1")){
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName());
				System.out.println("Enter No of Apples:");
				atapple.set(sc.nextInt());
				apple.put(atapple.get());
     			System.out.println(Thread.currentThread().getName()+" Apple added:  "+ atapple.get());
     			System.out.println("Enter No of Grapes:");
				atgrape.set(sc.nextInt());
				grape.put(atgrape.get());
     			System.out.println(Thread.currentThread().getName()+" Grape added:  "+ atgrape.get());
     			System.out.println("Enter No of Orange:");
				atorange.set(sc.nextInt());
				orange.put(atorange.get());
     			System.out.println(Thread.currentThread().getName()+" Orange added:  "+ atorange.get());
     			System.out.println("Enter No of Watermelon:");
				atwatermelon.set(sc.nextInt());
				watermelon.put(atwatermelon.get());
     			System.out.println(Thread.currentThread().getName()+" Watermelon added:  "+ atwatermelon.get());
     		} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		else if(Thread.currentThread().getName().equals("Farmer2")){
//			try {
//				Thread.sleep(100);
//				//System.out.println(Thread.currentThread().getName()+"   "+ i);
//				orange.put(atorange.getAndIncrement());
//     			System.out.println(Thread.currentThread().getName()+" Orange added:  "+ atorange.get());
//     			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}	
//		}
//		else if(Thread.currentThread().getName().equals("Farmer3")){
//			try {
//				Thread.sleep(100);
//				//System.out.println(Thread.currentThread().getName()+"   "+ i);
//				watermelon.put(atwatermelon.getAndIncrement());
//     			System.out.println(Thread.currentThread().getName()+" Orange added:  "+ atwatermelon.get());
//     			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}	
		}
		
		
		}
		
	}
		


