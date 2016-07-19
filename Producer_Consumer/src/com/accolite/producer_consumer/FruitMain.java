/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.accolite.producer_consumer;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class FruitMain.
 */
public class FruitMain {

	/**
	 * Random.
	 *
	 * @return the int
	 */
	public static int randomm() {
		Random rn = new Random();
		int n = 5;
		int i = rn.nextInt() % n;
		return i + 1;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String args[]) throws InterruptedException {
		BlockingQueue Apple = new ArrayBlockingQueue(5);
		BlockingQueue Orange = new ArrayBlockingQueue(5);
		BlockingQueue Grape = new ArrayBlockingQueue(5);
		BlockingQueue Watermelon = new ArrayBlockingQueue(5);

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("1.producer\n2.Consumer");
			int n = scanner.nextInt();
			if (n == 1) {
				Producer producer = new Producer(Apple, Orange, Grape, Watermelon);
				Thread thread_producer = new Thread(producer);
				thread_producer.setName("producer");
				thread_producer.start();
				Thread.currentThread().sleep(10000);
			} else {
				Consumer consumer = new Consumer(Apple, Orange, Grape, Watermelon);
				Thread thread_consumer = new Thread(consumer);
				thread_consumer.setName("consumer");
				thread_consumer.start();
				Thread.currentThread().sleep(10000);
			}
		}
	}
}
