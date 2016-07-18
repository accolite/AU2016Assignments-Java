/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package au.accolite.mutithreadingAssignment;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {
	
	/** The apple queue. */
	BlockingQueue appleQueue=new ArrayBlockingQueue(5);
	
	/** The orange queue. */
	BlockingQueue orangeQueue=new ArrayBlockingQueue(5);
	
	/** The grape queue. */
	BlockingQueue grapeQueue=new ArrayBlockingQueue(5);
	
	/** The watermelon queue. */
	BlockingQueue watermelonQueue=new ArrayBlockingQueue(5);
	
	/**
	 * Instantiates a new consumer.
	 *
	 * @param appleQueue the apple queue
	 * @param orangeQueue the orange queue
	 * @param grapeQueue the grape queue
	 * @param watermelonQueue the watermelon queue
	 */
	public Consumer(BlockingQueue appleQueue, BlockingQueue orangeQueue, BlockingQueue grapeQueue, BlockingQueue watermelonQueue) {
		
		this.appleQueue=appleQueue;
		this.orangeQueue=orangeQueue;
		this.grapeQueue=grapeQueue;
		this.watermelonQueue=watermelonQueue;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		int fruit,quantity;
		System.out.println("Choose fruit you want to consume:");
		System.out.println("1. apple\n 2. orange\n 3. grape\n 4. watermelon");
		
		fruit=in.nextInt();
		
		System.out.println("Enter quantity:");
		quantity=in.nextInt();
		int i,consumed;
		
		switch (fruit) {
		case 1:
			if(appleQueue.size()-quantity<0)
				System.out.println("Not enough quantity");
			for(i=0;i<quantity;i++)
				try {
					consumed=(int)appleQueue.take();
					System.out.println("Apple consumed");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		case 2:
			if(orangeQueue.size()-quantity<0)
				System.out.println("Not enough quantity");
			for(i=0;i<quantity;i++)
				try {
					consumed=(int)orangeQueue.take();
					System.out.println("Orange consumed");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
		case 3:
			if(grapeQueue.size()-quantity<0)
				System.out.println("Not enough quantity");
			for(i=0;i<quantity;i++)
				try {
					consumed=(int)grapeQueue.take();
					System.out.println("Grape consumed");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
		case 4:
			if(watermelonQueue.size()-quantity<0)
				System.out.println("Not enough quantity");
			for(i=0;i<quantity;i++)
				try {
					consumed=(int)watermelonQueue.take();
					System.out.println("Watermelon consumed");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		default:
			System.out.println("Inappropriate option");
			break;
		}
	}
	
}
