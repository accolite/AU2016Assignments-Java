/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package com.accolite.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class RestaurantMain.
 */
public class RestaurantMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Double> prevAverage = new ArrayBlockingQueue<>(1);
		BlockingQueue<TablePojo> tableOrders = new ArrayBlockingQueue<>(1);
		BlockingQueue<Double> averageQueue = new ArrayBlockingQueue<>(1);

		Thread t1 = null;
		Thread t2 = null;
		Thread t3 = null;

		t1 = new Thread(new TableBiller(tableOrders));

		t2 = new Thread(new AverageCalcThread(tableOrders, averageQueue, prevAverage));
		t3 = new Thread(new ReporterThread(averageQueue));

		t1.start();
		t2.start();
		t3.start();

	}
}
