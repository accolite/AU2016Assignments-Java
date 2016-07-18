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
 * The Class Farmer.
 */
public class Farmer implements Runnable {

	/** The c. */
	ConcurrentHashMap<String, Integer> c=null;
	
	/** The input. */
	Scanner input=new Scanner(System.in);
	
	/**
	 * Instantiates a new farmer.
	 *
	 * @param c the c
	 */
	public Farmer(ConcurrentHashMap<String, Integer> c) {
		this.c=c;
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String string;
		int q;
		// TODO Auto-generated method stub
		while(true){
			
			System.out.println("Enter Fruit to put in market");
			string=input.next();
			System.out.println("Enter Quantity to put in market");
			q=input.nextInt();
			try {
				produce(string, q);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	/**
	 * Produce.
	 *
	 * @param s the s
	 * @param q the q
	 * @throws InterruptedException the interrupted exception
	 */
	public void produce(String s,int q) throws InterruptedException{
		int value;
		value=c.get(s)+q;
		synchronized (c) {
			while(value>100){
				try {
					System.out.println("Queue is full for"+s);
					c.wait();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
			}
			System.out.println("Quantity of "+s+" is "+value);
			c.put(s, value);
			c.notifyAll();
		}
	}
	
	

}
