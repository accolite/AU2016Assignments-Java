/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class DynamicInput.
 */
public class DynamicInput {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		/** Console input scanner. */
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of the queue for apple, orange, grape, watermelon:");
		/** The number of apples */
		int apples = in.nextInt();

		/** The number of oranges. */
		int oranges = in.nextInt();

		/** The number of grapes */
		int grapes = in.nextInt();

		/** The number of watermelons. */
		int watermelons = in.nextInt();

		/** The marketPlace which maintains the queues */
		MarketPlace marketPlace = new MarketPlace(apples, oranges, grapes, watermelons);
		
		/** The map of threads for farmers */
		HashMap<String,Thread> farmers=new HashMap<>();
		
		/** The map of threads for consumers */
		HashMap<String,Thread> consumers=new HashMap<>();

		boolean doLoop = true; // loop variable
		while (doLoop) {
			System.out.println("Enter\n1.Farmer\n2.Consumer");
			switch (in.nextInt()) {
			case 1: System.out.println("Enter\n1.Add farmer\n2.Remove farmer\n3.Modify farmer");
					handleFarmer(in.nextInt(),farmers,marketPlace,in); // to handle farmer inputs
					break;
			case 2: System.out.println("Enter\n1.Add consumer\n2.Remove consumer\n3.Modify consumer");
					handleConsumer(in.nextInt(),consumers,marketPlace,in); // to handle consumer inputs
					break;
			default:
				doLoop = false;
			}
		}
	}

	/**
	 * Handle consumer.
	 *
	 * @param choose the choice
	 * @param consumers the consumer threads
	 * @param marketPlace the market place
	 * @param in the console input
	 */
	@SuppressWarnings("deprecation")
	private static void handleConsumer(int choose, HashMap<String, Thread> consumers, MarketPlace marketPlace,Scanner in) {
		int watermelons;
		int grapes;
		int oranges;
		int apples;
		String name;
		Thread newThread;
		Thread consumer;
		switch(choose){
			case 1: System.out.println("Enter consumer name, #apples, #oranges, #grapes, #watermelons");
					name=in.next();
					apples=in.nextInt();
					oranges=in.nextInt();
					grapes=in.nextInt();
					watermelons=in.nextInt();
					newThread=new Thread(new Consumer(apples,oranges,grapes,watermelons,marketPlace),name);
					consumers.put(name, newThread);
					newThread.start();
					break;
			case 2: System.out.println("Enter consumer name:");
					name = in.next();
					consumer=consumers.remove(name);
					consumer.stop();
					break;
			case 3: System.out.println("Enter consumer name, #apples, #oranges, #grapes, #watermelons");
					name=in.next();
					apples=in.nextInt();
					oranges=in.nextInt();
					grapes=in.nextInt();
					watermelons=in.nextInt();
					newThread=new Thread(new Consumer(apples,oranges,grapes,watermelons,marketPlace),name);
					consumer=consumers.remove(name);
					consumer.stop();
					consumers.put(name, newThread);
					newThread.start();
					break;
		}
	}

	/**
	 * Handle farmer.
	 *
	 * @param choose the choice
	 * @param consumers the consumer threads
	 * @param marketPlace the market place
	 * @param in the console input
	 */
	private static void handleFarmer(int choose, HashMap<String, Thread> farmers, MarketPlace marketPlace,Scanner in) {
		int watermelons;
		int grapes;
		int oranges;
		int apples;
		String name;
		Thread newThread;
		Thread farmer;
		switch(choose){
			case 1: System.out.println("Enter farmer name, #apples, #oranges, #grapes, #watermelons");
					name=in.next();
					apples=in.nextInt();
					oranges=in.nextInt();
					grapes=in.nextInt();
					watermelons=in.nextInt();
					newThread=new Thread(new Farmer(apples,oranges,grapes,watermelons,marketPlace),name);
					farmers.put(name, newThread);
					newThread.start();
					break;
			case 2: System.out.println("Enter farmer name:");
					name = in.next();
					farmer=farmers.remove(name);
					farmer.stop();
					break;
			case 3: System.out.println("Enter farmer name, #apples, #oranges, #grapes, #watermelons");
					name=in.next();
					apples=in.nextInt();
					oranges=in.nextInt();
					grapes=in.nextInt();
					watermelons=in.nextInt();
					newThread=new Thread(new Consumer(apples,oranges,grapes,watermelons,marketPlace),name);
					farmer=farmers.remove(name);
					farmer.stop();
					farmers.put(name, newThread);
					newThread.start();
					break;
		}
	}
}
