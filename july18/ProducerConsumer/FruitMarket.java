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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.accolite.assignmentthread.Constants;

/**
 * The Class FruitMarket.
 */
public class FruitMarket {

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		@SuppressWarnings("unchecked")
		BlockingQueue<Integer>[] queue = new ArrayBlockingQueue[Constants.mapping.size()];
		
		/**
		 * Enter initial capacity for each fruits at the market
		 */
		for (int i = 1; i <= queue.length; i++) {
			System.out.println("Enter capacity of items for "+Constants.mapping.get(i));
			Constants.capacity[i-1] = in.nextInt();
			queue[i-1] = new ArrayBlockingQueue<Integer>(Constants.capacity[i-1]);
		}
		
		
		Produce producer;
		Consumer consumer;
		
		boolean cont=true;
		
		while(cont){
			
			System.out.println("New \n1.Produce \n2.Customer");
			String opt = in.next();
			
			/**
			 * Produce
			 */
			if(opt.equals("1")){ 
				producer = new Produce(queue);
				producer.start();
				try {
					producer.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			
			/**
			 * Consume
			 */
			else if(opt.equals("2")){
				consumer = new Consumer(queue);
				consumer.start();
				try {
					consumer.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Continue y/n");
			opt = in.next();
			
			if(opt.equals("y"))
				cont=true;
			else 
				cont=false;
		}


	  in.close();  
	}

}
