package com.accolite.producer_consumer;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	protected BlockingQueue Apple = null;
	protected BlockingQueue Orange = null;
	protected BlockingQueue Grapes = null;
	protected BlockingQueue Watermelon = null;
	AtomicInteger apple = new AtomicInteger(0);
	AtomicInteger orange = new AtomicInteger(0);
	AtomicInteger grape = new AtomicInteger(0);
	AtomicInteger watermelon = new AtomicInteger(0);

	public Producer(BlockingQueue Apple, BlockingQueue Orange, BlockingQueue Grapes, BlockingQueue Watermelon) {
		super();
		this.Apple = Apple;
		this.Orange = Orange;
		this.Grapes = Grapes;
		this.Watermelon = Watermelon;
	}

	@Override
	public void run() {
		//if (Thread.currentThread().getName().equals("producer")) {
			try {
				Thread.sleep(1000);
				Scanner S = new Scanner(System.in);
				System.out.println(Thread.currentThread().getName());
				System.out.println("Enter the no apples to be added");
				int n = S.nextInt();
				Apple.put(apple.addAndGet(n));
				System.out.println(Thread.currentThread().getName() + " apples added=" + n);
				System.out.println("Enter the no oranges to be added");
				n = S.nextInt();
				Orange.put(orange.addAndGet(n));
				System.out.println(Thread.currentThread().getName() + " oranges added=" + n);
				System.out.println("Enter the no grapes to be added");
				n = S.nextInt();
				Grapes.put(grape.addAndGet(n));
				System.out.println(Thread.currentThread().getName() + " grapes added=" + n);
				System.out.println("Enter the no watermelon to be added");
				n = S.nextInt();
				Watermelon.put(watermelon.addAndGet(n));
				System.out.println(Thread.currentThread().getName() + " watermelons added=" + n);

			} catch (Exception e) {
				e.printStackTrace();
			}
	//	}

	}

}