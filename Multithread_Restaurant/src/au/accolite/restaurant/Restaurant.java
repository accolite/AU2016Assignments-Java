/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package au.accolite.restaurant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurant.
 */
public class Restaurant {

	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
	
		BlockingQueue<Order> billQueue=new ArrayBlockingQueue<>(1);
		BlockingQueue<Double> averageQueue=new ArrayBlockingQueue<>(1);
		
		Thread billGenerationThread;
		Thread calculateAverageThread;
		Thread notificationToOwnerThread;
		
		BillGeneration billGeneration;
		CalculateAverage calculateAverage;
		NotificationToOwner notificationToOwner;
		
		billGeneration=new BillGeneration(billQueue);
		billGenerationThread=new Thread(billGeneration);
			
		calculateAverage=new CalculateAverage(billQueue,averageQueue);
		calculateAverageThread=new Thread(calculateAverage);
			
		notificationToOwner=new NotificationToOwner(billQueue,averageQueue);
		notificationToOwnerThread=new Thread(notificationToOwner);
					
		billGenerationThread.start();
		
		calculateAverageThread.start();
		
		notificationToOwnerThread.start();
				
	
	}

	
}
