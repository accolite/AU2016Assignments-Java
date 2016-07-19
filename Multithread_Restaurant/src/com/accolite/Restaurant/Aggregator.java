/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.Restaurant;

import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Aggregator.
 */
public class Aggregator implements Runnable {
	
	/** The Aggregator Queue. */
	BlockingQueue AggregatorBill=null;
	
	/** The Average. */
	double Average;
	
	/**
	 * Instantiates a new aggregator.
	 *
	 * @param aggregatorBill the aggregator bill
	 */
	public Aggregator(BlockingQueue aggregatorBill) {
		super();
		AggregatorBill = aggregatorBill;
		Average=0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double currentAverage=0;
		while(true){
			try {
				/** Getting the Value from Aggregator Queue */
				currentAverage=(double) AggregatorBill.take();
				/** Checking for Change in Values */
				if(currentAverage!=Average){
					System.out.println("Previous Average:"+Average+"\nCurrent Average"+currentAverage);
					Average=currentAverage;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				/** Handling Interruption */
				System.out.println("Aggregator Thread Stopped");
				break;
			}
		}
		
	}

}
