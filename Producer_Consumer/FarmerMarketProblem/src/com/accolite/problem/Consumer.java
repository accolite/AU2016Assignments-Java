/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.problem;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	/** The c. */
	ConcurrentHashMap<String, Integer> c=null;
	
	/** The input. */
	Scanner input=new Scanner(System.in);
	
	
	/**
	 * Instantiates a new consumer.
	 *
	 * @param c the c
	 */
	public Consumer(ConcurrentHashMap<String, Integer> c) {
		this.c=c;
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String string;
		int q;
		// TODO Auto-generated method stub
		while(true){
			
			System.out.println("Enter Fruit to buy");
			string=input.next();
			System.out.println("Enter Quantity to buy");
			q=input.nextInt();
			try {
				consume(string, q);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	/**
	 * Consume.
	 *
	 * @param s the s
	 * @param q the q
	 * @throws InterruptedException the interrupted exception
	 */
	public void consume(String s,int q) throws InterruptedException{
		int value;
		value=c.get(s)-q;
		synchronized (c) {
			while(value<0){
				System.out.println("Queue doesn't have enough "+s);
				try {
					c.wait();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
			}
			System.out.println(" Consume Quantity of "+s+" is "+value);
			c.put(s, value);
			c.notifyAll();
		}
	}
}
