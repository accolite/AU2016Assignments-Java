/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.accolite.producer_consumer;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	/** The Apple. */
	protected BlockingQueue Apple = null;
	
	/** The Orange. */
	protected BlockingQueue Orange = null;
	
	/** The Grapes. */
	protected BlockingQueue Grapes = null;
	
	/** The Watermelon. */
	protected BlockingQueue Watermelon = null;

	/**
	 * Instantiates a new consumer.
	 *
	 * @param Apple the apple
	 * @param Orange the orange
	 * @param Grapes the grapes
	 * @param Watermelon the watermelon
	 */
	public Consumer(BlockingQueue Apple, BlockingQueue Orange, BlockingQueue Grapes, BlockingQueue Watermelon) {
		
		this.Apple = Apple;
		this.Orange = Orange;
		this.Grapes = Grapes;
		this.Watermelon = Watermelon;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Thread.currentThread().getName()+"-Thread");
		try {
			int n;
			System.out.println("Enter the no of apples to consumed");
			n = scanner.nextInt();
			if (Apple.size() < n) {
				System.out.println("Not enough apples");
				//Thread.sleep(300);
			} else {
				for (int i = 0; i < n; i++) {
					Apple.take();	
				}
				System.out.println(Thread.currentThread().getName()+"-Thread->" + "Consumed "+n+" apples");
			}
			System.out.println("Enter the no of oranges to consumed");
			n = scanner.nextInt();
			if (Orange.size() < n) {
				System.out.println("Not enough oranges");
				//Thread.sleep(300);
			} else {
				for (int i = 0; i < n; i++) {
					Orange.take();
				}
				System.out.println(Thread.currentThread().getName()+"-Thread->" +  "Consumed "+n+" oranges");
			}
			System.out.println("Enter the no of grapes to consumed");
			n = scanner.nextInt();
			if (Grapes.size() < n) {
				System.out.println("Not enough grapes");
				//Thread.sleep(300);
			} else {
				for (int i = 0; i < n; i++) {
					Grapes.take();
				}
				System.out.println(Thread.currentThread().getName()+"-Thread->" + "Consumed "+n+" grapes");
			}
			System.out.println("Enter the no of watermelons to consumed");
			n = scanner.nextInt();
			if (Watermelon.size() < n) {
				System.out.println("Not enough watermelon");
				//Thread.sleep(300);
			} else {
				for (int i = 0; i < n; i++) {
					Watermelon.take();
				}
				System.out.println(Thread.currentThread().getName()+"-Thread->" + "Consumed "+n+" watermelons");
			}
			Thread.currentThread().interrupt();
			/*int n;
			System.out.println("Enter which fruit to be consumed");
			String fruit = scanner.next();
			if (fruit == "Apple" || fruit == "apple") {
				System.out.println("Enter the no of apples to consumed");
				n = scanner.nextInt();
				if (Apple.size() < n) {
					System.out.println("Not enough apples");
					Thread.sleep(300);
				} else {
					for (int i = 0; i < n; i++) {
						Apple.take();
					}
					System.out.println(Thread.currentThread().getName() + "-Thread" + "Consumed " + n + " apples");
				}
			} else if (fruit == "Orange" || fruit == "orange") {
				System.out.println("Enter the no of oranges to consumed");
				n = scanner.nextInt();
				if (Orange.size() < n) {
					System.out.println("Not enough oranges");
					Thread.sleep(300);
				} else {
					for (int i = 0; i < n; i++) {
						Orange.take();
					}
					System.out.println(Thread.currentThread().getName() + "-Thread" + "Consumed " + n + "+oranges");
				}
			} else if (fruit == "Grape" || fruit == "grape") {
				System.out.println("Enter the no of grapes to consumed");
				n = scanner.nextInt();
				if (Grapes.size() < n) {
					System.out.println("Not enough grapes");
					Thread.sleep(300);
				} else {
					for (int i = 0; i < n; i++) {
						Grapes.take();
					}
					System.out.println(Thread.currentThread().getName() + "-Thread" + "Consumed " + n + "grapes");
				}
			} else if (fruit == "Watermelon" || fruit == "watermelon") {
				System.out.println("Enter the no of watermelons to consumed");
				n = scanner.nextInt();
				if (Watermelon.size() < n) {
					System.out.println("Not enough watermelon");
					Thread.sleep(300);
				} else {
					for (int i = 0; i < n; i++) {
						Watermelon.take();
					}
					System.out.println(Thread.currentThread().getName() + "-Thread" + "Consumed" + n + " watermelons");
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
