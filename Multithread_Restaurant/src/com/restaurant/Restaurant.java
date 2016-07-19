/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.restaurant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurant.
 */
public class Restaurant {
	
	/** The logbook. */
	static BlockingQueue<Order> logbook = new ArrayBlockingQueue<Order>(1);
	
	/** The report. */
	static BlockingQueue<Float> report = new ArrayBlockingQueue<Float>(1);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new InputThread(logbook));
		Thread t2 = new Thread(new AverageThread(logbook, report));
		Thread t3 = new Thread(new OutputThread(report));
		t1.start();
		t2.start();
		t3.start();
	}

}
