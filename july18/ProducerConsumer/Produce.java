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
 * The Class Produce.
 */
public class Produce extends Thread {

	/** The queues. */
	protected BlockingQueue<Integer>[] queues = null;

	/** The input scanner. */
	Scanner in;
	
	public Produce(BlockingQueue<Integer>[] queues) {
		this.queues = queues;
		in = new Scanner(System.in);
	}

	/**
	 * Produce start
	 */
	public void run() {
			
			try {
				/**
				 * Get fruit to sell
				 */
				System.out.println("Enter fruit to sell:");
				for(int j=1;j<=Constants.mapping.size();j++){
					System.out.println(j+":"+Constants.mapping.get(j));
				}

				int fruit = in.nextInt();
				if(fruit>Constants.mapping.size()){
					System.out.println("Enter proper value");
					throw new IndexOutOfBoundsException("Proper value of fruit not given");
				}
				
				/**
				 * Get number of fruits
				 */
				System.out.println("Enter number of fruits");
				int num = in.nextInt();
				
				for(int k=0;k<num;k++){
					/**
					 * If within capacity at each fruit, add to queue
					 */
					if(queues[fruit-1].size()<Constants.capacity[fruit-1]){
						queues[fruit-1].put(1);
						System.out.println("Farmer at "+this.getName()+" Produced " + 1 +" "+Constants.mapping.get(fruit));
					}
					/**
					 * Else sleep and then add later
					 */
					else{
						System.out.println("Farmer at "+this.getName()+" waiting to sell "+1+" "+Constants.mapping.get(fruit));
						Thread.sleep(100);
					}
				}
					
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e){
				e.printStackTrace();
			} 
		
	}
}
