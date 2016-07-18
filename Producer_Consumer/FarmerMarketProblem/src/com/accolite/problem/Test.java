/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.problem;

//import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class Test {
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String arg[]) throws InterruptedException{
		
		ConcurrentHashMap<String, Integer> concurrentHashMap=new ConcurrentHashMap<>(4);
		//int i;
		//Scanner input=new Scanner(System.in);
		//Max Quantity=100 per fruit
		concurrentHashMap.put("Apple", 0);
		concurrentHashMap.put("Orange", 0);
		concurrentHashMap.put("Grapes", 0);
		concurrentHashMap.put("WaterMelon", 0);
		
		Farmer farmer=new Farmer(concurrentHashMap);
		Consumer consumer=new Consumer(concurrentHashMap);
		Thread t1=new Thread(farmer);
		Thread t2=new Thread(consumer);
		t1.start();
		t2.start();
		
		
	}

}
