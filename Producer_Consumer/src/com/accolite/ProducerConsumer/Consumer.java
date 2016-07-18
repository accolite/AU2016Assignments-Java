package com.accolite.ProducerConsumer;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {

	protected BlockingQueue apple = null;
	protected BlockingQueue orange = null;
	protected BlockingQueue grape = null;
	protected BlockingQueue watermelon = null;
//	AtomicInteger atapple=new AtomicInteger(1);
//	AtomicInteger atorange=new AtomicInteger(1);
//	AtomicInteger atgrape=new AtomicInteger(1);
//	AtomicInteger atwatermelon=new AtomicInteger(1);
	int var_apple,var_orange,var_grape,var_watermelon;
	Scanner sc;

	public Consumer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon) {
		super();
		sc=new Scanner(System.in);
		this.apple = apple;
		this.orange = orange;
		this.grape = grape;
		this.watermelon = watermelon;
	}



//	public void run() {
//		try {
//			while (true) {
//				//int element=(int)queue.take();
//				if(apple.isEmpty()==false)
//					System.out.println(Thread.currentThread().getName()+" Consumed apple " + apple.take());
//				else
//					System.out.println(Thread.currentThread().getName()+" waiting for apple ");
//				Thread.sleep(1000);
//				if(orange.isEmpty()==false)
//					System.out.println(Thread.currentThread().getName()+" Consumed orange " + orange.take());
//				else
//					System.out.println(Thread.currentThread().getName()+" waiting for orange ");
//				Thread.sleep(1000);
//				if(grape.isEmpty()==false)
//					System.out.println(Thread.currentThread().getName()+" Consumed grape " + grape.take());
//				else
//					System.out.println(Thread.currentThread().getName()+" waiting for grape ");
//				Thread.sleep(1000);
//				if(watermelon.isEmpty()==false)
//					System.out.println(Thread.currentThread().getName()+" Consumed watermelon " + watermelon.take());
//				else
//					System.out.println(Thread.currentThread().getName()+" waiting for watermelon ");
//				Thread.sleep(1000);
//			
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//	}
	
	
	public void run(){
		while(true){
		System.out.println(Thread.currentThread().getName());
		System.out.println("Enter No of Apples:");
		var_apple=sc.nextInt();
		try{
		for(int i=0;i<var_apple;i++){
			if(apple.isEmpty()==false)
			{	
				apple.take();
				System.out.println(Thread.currentThread().getName()+" consumed Apple  " );
			}
			else{
				
				System.out.println(Thread.currentThread().getName()+" waiting for apple ");
				Thread.sleep(10000);
			}
			Thread.sleep(1000);
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Enter No of Oranges:");
		var_orange=sc.nextInt();
		try{
		for(int i=0;i<var_orange;i++){
			if(orange.isEmpty()==false)
			{	
				orange.take();
				System.out.println(Thread.currentThread().getName()+" consumed Orange  " );
			}
			else{
				System.out.println(Thread.currentThread().getName()+" waiting for Orange ");
				Thread.sleep(10000);
			}
			Thread.sleep(1000);
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
}}
