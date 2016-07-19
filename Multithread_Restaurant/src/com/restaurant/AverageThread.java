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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class AverageThread.
 */
public class AverageThread extends Thread {

	/** The logbook. */
	BlockingQueue<Order> logbook;
	
	/** The history. */
	LinkedList<Order> history = new LinkedList<Order>();
	
	/** The report. */
	BlockingQueue<Float> report;

	/**
	 * Instantiates a new average thread.
	 *
	 * @param logbook the logbook
	 * @param report the report
	 */
	AverageThread(BlockingQueue<Order> logbook, BlockingQueue<Float> report) {
		this.logbook = logbook;
		this.report = report;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		float avgtotal = 0;
		while (true) {
			Order neworder = null;
			try {
				neworder = logbook.take();
				history.add(neworder);
				for (Order e : history) {
					avgtotal += e.getAmount();
				}
				report.put(new Float(avgtotal / history.size()));
				// System.out.println( "AVG " + avgtotal/history.size());
				avgtotal = 0;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
