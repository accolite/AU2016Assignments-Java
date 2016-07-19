/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.restaurant;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class InputThread.
 */
public class InputThread extends Thread {

	/** The logbook. */
	BlockingQueue<Order> logbook;

	/**
	 * Instantiates a new input thread.
	 *
	 * @param logbook
	 *            the logbook
	 */
	InputThread(BlockingQueue<Order> logbook) {
		this.logbook = logbook;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the table number");
			int tableno = in.nextInt();
			System.out.println("Enter the amount");
			float amount = in.nextFloat();
			logbook.add(new Order(tableno, amount));
		}

	}

}
