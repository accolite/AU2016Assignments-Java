/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package com.accolite.multithread;

import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class ReporterThread.
 */
public class ReporterThread implements Runnable {

	/** The average queue. */
	BlockingQueue<Double> averageQueue = null;

	/**
	 * Instantiates a new reporter thread.
	 *
	 * @param averageQueue the average queue
	 */
	public ReporterThread(BlockingQueue<Double> averageQueue) {
		super();
		this.averageQueue = averageQueue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
		
			Double rep = 0.0;
			try {
				rep = averageQueue.take();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Report->  Average : " + rep);
		}
	}
}
