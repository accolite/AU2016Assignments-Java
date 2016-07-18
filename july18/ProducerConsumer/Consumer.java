/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.assignmentthread;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumer.
 */
public class Consumer extends Thread {
	
	/** The in. */
	Scanner in;
	
	/** The queue. */
	protected BlockingQueue<Integer>[] queues = null;

	public Consumer(BlockingQueue<Integer>[] queues) {
		this.queues = queues;
		in = new Scanner(System.in);
	}

	/**
	 * Consume start
	 */
	public void run() {
		try {
				/**
				 * Get fruit to buy
				 */
				System.out.println("Enter fruit to buy:");
				for(int j=1;j<=Constants.mapping.size();j++){
					System.out.println(j+":"+Constants.mapping.get(j));
				}
				int fruit = in.nextInt();
				
				/**
				 * Get number of fruits
				 */
				System.out.println("Enter number of fruits");
				int num = in.nextInt();
				
				for(int k=0;k<num;k++){
					/**
					 * If any fruit at each fruit, buy 1 fruit
					 */
					if(queues[fruit-1].isEmpty()==false){
						queues[fruit-1].take();
						System.out.println("Consumer at "+this.getName()+" bought "+1+" "+Constants.mapping.get(fruit));
					}
					/**
					 * Else try later when available
					 */
					else{
						System.out.println("Consumer at "+this.getName()+" waiting to buy "+1+" "+Constants.mapping.get(fruit));
						Thread.sleep(1000);
					}
				}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	} 
}
