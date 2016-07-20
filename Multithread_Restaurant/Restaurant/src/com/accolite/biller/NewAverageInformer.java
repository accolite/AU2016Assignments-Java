/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.biller;

import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class NewAverageInformer.
 */
public class NewAverageInformer implements Runnable {
	
	/** The previous average. */
	private Double previousAverage;
	
	/** The average bill queue. */
	private BlockingQueue<Double> averageBill;
	
	/** The my thread. */
	public Thread myThread;

	/**
	 * Instantiates a new new average informer.
	 *
	 * @param averageBill the average bill
	 */
	public NewAverageInformer(BlockingQueue<Double> averageBill) {
		this.averageBill = averageBill;
		previousAverage = new Double(0);
		myThread = new Thread(this, "NewAverageInformer");
	}

	/**
	 * Start.
	 */
	public void start() {
		myThread.start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("NewAverageInformer waiting for new Average");
				Double newAverage = averageBill.take();
				if (!newAverage.equals(previousAverage))
					System.out.println("NewAverageInformer found new Average " + newAverage.doubleValue());
				else
					System.out.println("NewAverageInformer found no new Average ");
				previousAverage = newAverage;
			} catch (InterruptedException e) {
				System.out.println("NewAverageInformer got interrupted");
				break;
			}
		}
	}

}
