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
 * The Class NotificationToOwner.
 */
public class NotificationToOwner implements Runnable {

/** The bill queue. */
BlockingQueue<Order> billQueue;

/** The average queue. */
BlockingQueue<Double> averageQueue;

	/**
	 * Instantiates a new notification to owner.
	 *
	 * @param billQueue the bill queue
	 * @param averageQueue the average queue
	 */
	public NotificationToOwner(BlockingQueue<Order> billQueue, BlockingQueue<Double> averageQueue){
		
		this.billQueue=billQueue;
		this.averageQueue=averageQueue;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		double average;
		
		while(true){
			
			try {
				average=averageQueue.take();
				System.out.println("New Average is: "+average);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
}
