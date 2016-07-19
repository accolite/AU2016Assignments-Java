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
import java.util.concurrent.atomic.AtomicInteger;

// TODO: Auto-generated Javadoc
/**
 * The Class Producer.
 */
public class Producer implements Runnable {

	/** The Apple. */
	protected BlockingQueue Apple = null;
	
	/** The Orange. */
	protected BlockingQueue Orange = null;
	
	/** The Grapes. */
	protected BlockingQueue Grapes = null;
	
	/** The Watermelon. */
	protected BlockingQueue Watermelon = null;

	/**
	 * Instantiates a new producer.
	 *
	 * @param Apple the apple
	 * @param Orange the orange
	 * @param Grapes the grapes
	 * @param Watermelon the watermelon
	 */
	public Producer(BlockingQueue Apple, BlockingQueue Orange, BlockingQueue Grapes, BlockingQueue Watermelon) {
		
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
		if (Thread.currentThread().getName().equals("producer")) {
			try {
				Scanner S = new Scanner(System.in);
				System.out.println(Thread.currentThread().getName()+"-Thread");
				System.out.println("Enter the no apples to be added");
				int n = S.nextInt();
				for(int i=1;i<=n;i++){
					Apple.put(i);
				}
				System.out.println(Thread.currentThread().getName() +"-Thread->"+ " apples added=" + n);
				System.out.println("Enter the no oranges to be added");
				n = S.nextInt();
				for(int i=1;i<=n;i++){
					Orange.put(i);
				}
				System.out.println(Thread.currentThread().getName() +"-Thread->"+ " oranges added=" + n);
				System.out.println("Enter the no grapes to be added");
				n = S.nextInt();
				for(int i=1;i<=n;i++){
					Grapes.put(i);
				}
				System.out.println(Thread.currentThread().getName() +"-Thread->"+ " grapes added=" + n);
				System.out.println("Enter the no watermelon to be added");
				n = S.nextInt();
				for(int i=1;i<=n;i++){
					Watermelon.put(i);
				}
				System.out.println(Thread.currentThread().getName() +"-Thread->"+" watermelons added=" + n);
				Thread.currentThread().interrupt();
				/*Scanner S = new Scanner(System.in);
				int n;
				System.out.println(Thread.currentThread().getName() + "-Thread");
				System.out.println("Enter which fruit to be produced");
				String fruit = S.next();
				if (fruit == "Apple" || fruit == "apple") {
					System.out.println("Enter the no apples to be added");
					n = S.nextInt();
					for (int i = 1; i <= n; i++) {
						Apple.put(i);
					}
					System.out.println(Thread.currentThread().getName() + " apples added=" + n);
				} else if (fruit == "Orange" || fruit == "orange") {
					System.out.println("Enter the no oranges to be added");
					n = S.nextInt();
					for (int i = 1; i <= n; i++) {
						Orange.put(i);
					}
					System.out.println(Thread.currentThread().getName() + " oranges added=" + n);
				} else if (fruit == "Grape" || fruit == "grape") {
					System.out.println("Enter the no grapes to be added");
					n = S.nextInt();
					for (int i = 1; i <= n; i++) {
						Grapes.put(i);
					}
					System.out.println(Thread.currentThread().getName() + " grapes added=" + n);
				} else if (fruit == "Watermelon" || fruit == "watermelon") {
					System.out.println("Enter the no watermelon to be added");
					n = S.nextInt();
					for (int i = 1; i <= n; i++) {
						Watermelon.put(i);
					}
					System.out.println(Thread.currentThread().getName() + " watermelons added=" + n);
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}