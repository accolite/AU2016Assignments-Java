package com.accolite.producer_consumer;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	protected BlockingQueue Apple = null;
	protected BlockingQueue Orange = null;
	protected BlockingQueue Grapes = null;
	protected BlockingQueue Watermelon = null;

	public Consumer(BlockingQueue Apple, BlockingQueue Orange, BlockingQueue Grapes, BlockingQueue Watermelon) {
		super();
		this.Apple = Apple;
		this.Orange = Orange;
		this.Grapes = Grapes;
		this.Watermelon = Watermelon;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Thread.currentThread().getName());
		try {
			int n;
			System.out.println("Enter the no of apples to consumed");
			n = scanner.nextInt();
			if (Apple.size() < n) {
				System.out.println("Not enough apples");
				Thread.sleep(3000);
			} else {
				for (int i = 0; i < n; i++) {
					Apple.take();
					System.out.println(Thread.currentThread().getName() + "Consumed an apple");
				}
			}
			System.out.println("Enter the no of oranges to consumed");
			n = scanner.nextInt();
			if (Orange.size() < n) {
				System.out.println("Not enough oranges");
				Thread.sleep(3000);
			} else {
				for (int i = 0; i < n; i++) {
					Orange.take();
					System.out.println(Thread.currentThread().getName() + "Consumed an orange");
				}
			}
			System.out.println("Enter the no of grapes to consumed");
			n = scanner.nextInt();
			if (Grapes.size() < n) {
				System.out.println("Not enough grapes");
				Thread.sleep(3000);
			} else {
				for (int i = 0; i < n; i++) {
					Grapes.take();
					System.out.println(Thread.currentThread().getName() + "Consumed a grape");
				}
			}
			System.out.println("Enter the no of watermelons to consumed");
			n = scanner.nextInt();
			if (Watermelon.size() < n) {
				System.out.println("Not enough watermelon");
				Thread.sleep(3000);
			} else {
				for (int i = 0; i < n; i++) {
					Watermelon.take();
					System.out.println(Thread.currentThread().getName() + "Consumed a watermelon");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
