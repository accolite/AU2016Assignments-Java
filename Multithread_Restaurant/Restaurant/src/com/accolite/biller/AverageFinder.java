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
 * The Class AverageFinder.
 */
public class AverageFinder implements Runnable {
	
	/** The last average. */
	private double lastAverage;
	
	/** The total number of bills. */
	private int totalBills;
	
	/** The last bill queue. */
	private BlockingQueue<Bill> lastBill;
	
	/** The average of bills queue. */
	private BlockingQueue<Double> averageBill;
	
	/** The my thread. */
	public Thread myThread;

	/**
	 * Instantiates a new average finder.
	 *
	 * @param lastBill the last bill
	 * @param averageBill the average bill
	 */
	public AverageFinder(BlockingQueue<Bill> lastBill, BlockingQueue<Double> averageBill) {
		this.lastBill = lastBill;
		this.averageBill = averageBill;
		lastAverage = 0;
		totalBills = 0;
		myThread = new Thread(this, "AverageFinder");
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
				System.out.println("AverageFinder waiting to add new bill to the average");
				Bill newBill = lastBill.take();
				if (totalBills == 0) {//initially no bill exist
					totalBills = 1;
					lastAverage = newBill.getBillAmount();
				} else {
					lastAverage = ((lastAverage * totalBills) + newBill.getBillAmount()) / (totalBills + 1);
					totalBills++;
				}
				System.out.println("AverageFinder found new average " + lastAverage);
				averageBill.put(lastAverage); //NewAverageFinder will take this new Average for his job
			} catch (InterruptedException e) {
				System.out.println("AverageFinder got interrupted");
				break;
			}
		}
	}

}
