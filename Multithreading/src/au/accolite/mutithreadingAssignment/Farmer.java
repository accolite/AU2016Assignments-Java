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
 * The Class Farmer.
 */
public class Farmer implements Runnable {
	
	/** The watermelon. */
	private int apple=0, orange=0, grape=0, watermelon=0;
	
	/** The apple queue. */
	BlockingQueue appleQueue=new ArrayBlockingQueue(5);
	
	/** The orange queue. */
	BlockingQueue orangeQueue=new ArrayBlockingQueue(5);
	
	/** The grape queue. */
	BlockingQueue grapeQueue=new ArrayBlockingQueue(5);
	
	/** The watermelon queue. */
	BlockingQueue watermelonQueue=new ArrayBlockingQueue(5);
	
	/**
	 * Instantiates a new farmer.
	 *
	 * @param appleQueue the apple queue
	 * @param orangeQueue the orange queue
	 * @param grapeQueue the grape queue
	 * @param watermelonQueue the watermelon queue
	 */
	public Farmer(BlockingQueue appleQueue, BlockingQueue orangeQueue, BlockingQueue grapeQueue, BlockingQueue watermelonQueue) {
		
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
		System.out.println("Choose fruit you want to produce:");
		System.out.println("1. apple\n 2. orange\n 3. grape\n 4. watermelon");
		
		fruit=in.nextInt();
		
		System.out.println("Enter quantity:");
		quantity=in.nextInt();
		//System.out.println(appleQueue.size());
		int i;
		switch (fruit) {
		case 1:
			if((appleQueue.size()+quantity)>5)
				System.out.println("Not enough space");
			for(i=0;i<quantity;i++)
				try {
					appleQueue.put(1);
					System.out.println("Apple added");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		case 2:
			if((orangeQueue.size()+quantity)>5)
				System.out.println("Not enough space");
			for(i=0;i<quantity;i++)
				try {
					orangeQueue.put(2);
					System.out.println("Orange added");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
		case 3:
			if((grapeQueue.size()+quantity)>5)
				System.out.println("Not enough space");
			for(i=0;i<quantity;i++)
				try {
					grapeQueue.put(3);
					System.out.println("Grape added");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
		case 4:
			if((watermelonQueue.size()+quantity)>5)
				System.out.println("Not enough space");
			for(i=0;i<quantity;i++)
				try {
					watermelonQueue.put(4);
					System.out.println("Watermelon added");
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
