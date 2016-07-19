/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package au.accolite.restaurant;

import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculateAverage.
 */
public class CalculateAverage implements Runnable {
	
	/** The bill queue. */
	BlockingQueue<Order> billQueue;
	
	/** The average queue. */
	BlockingQueue<Double> averageQueue;
	
	/**
	 * Instantiates a new calculate average.
	 *
	 * @param billQueue the bill queue
	 * @param averageQueue the average queue
	 */
	public CalculateAverage (BlockingQueue<Order> billQueue,BlockingQueue<Double> averageQueue) {
		
		this.billQueue=billQueue;
		this.averageQueue=averageQueue;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		Order newOrder=new Order();
		int count=0;
		double average=0;
		while(true)
		{
			
			try {
				
				newOrder=billQueue.take();
				count++;
				average=((average*(count-1))+newOrder.getAmount())/count;
				averageQueue.put(average);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
}
