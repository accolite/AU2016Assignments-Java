/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	
	/** The total. */
	public static BlockingQueue<Float> total=new ArrayBlockingQueue<>(1);
	
	/** The average. */
	public static BlockingQueue<Float> average=new ArrayBlockingQueue<>(1);
	
	/** The avgamount. */
	public  static float amount,avgamount=0;
	
	/** The table no. */
	public static int table_no;
	
	/** The count. */
	public static int count=0;
	
	/** The total amount. */
	public static float total_amount=0;
	
	/** The choice. */
	public static int choice;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	
			
	totalbill t1=new totalbill();
	average t2=new average();
	notifyowner t3=new notifyowner();
	t1.start();
	t2.start();
	t3.start();
	
		

}
}
