/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.restaurant;

import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class OutputThread.
 */
public class OutputThread extends Thread {
	
	/** The report. */
	BlockingQueue<Float> report;

	/**
	 * Instantiates a new output thread.
	 *
	 * @param report the report
	 */
	OutputThread(BlockingQueue<Float> report) {
		this.report = report;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Float average = new Float(report.take());
				System.out.println("AVG " + average.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
