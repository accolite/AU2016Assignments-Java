/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.market;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	/**  The number of grapes. */
	int apples;

	/**  The number of grapes. */
	int grapes;

	/** The number of oranges. */
	int oranges;

	/** The number of watermelons. */
	int watermelons;

	/**  The flag which denotes whether consumer quits or not. */
	boolean consumerQuit;
	
	/** The marketPlace which maintains the queues */
	MarketPlace marketPlace;
	
	/** The thread object */
	Thread myThread;
	
	/**
	 * Instantiates a new farmer.
	 *
	 * @param apples the number of apples
	 * @param grapes the number of grapes
	 * @param oranges the number of oranges
	 * @param watermelons the number of watermelons
	 * @param marketPlace the market place where various queues present
	 * @param name the name of the consumer
	 */
	public Consumer(int apples, int oranges, int grapes, int watermelons, MarketPlace marketPlace,String name) {
		super();
		this.apples = apples;
		this.grapes = grapes;
		this.oranges = oranges;
		this.watermelons = watermelons;
		this.marketPlace = marketPlace;
		myThread = new Thread(this,name);
	}
	
	/**
	 * Starts the thread.
	 */
	public void start(){
		myThread.start();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (!isConsumerQuit()) {
			/** take apples if consumer wants*/
			if(apples>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to get apples");
					String farmerName=marketPlace.apple.take(); //takes the front of the apple queue in the market place
					apples--; //consumed one apple
					System.out.println(Thread.currentThread().getName()+" have got an apple from "+farmerName);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(consumerQuit)
						break;
				}
			}
			/** take oranges if consumer wants*/
			if(oranges>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to get oranges");
					String farmerName=marketPlace.orange.take(); //takes the front of the orange queue in the market place
					oranges--; //consumed one orange
					System.out.println(Thread.currentThread().getName()+" have got an orange from "+farmerName);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(consumerQuit)
						break;
				}
			}
			/** take grapes if consumer wants*/
			if(grapes>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to get grapes");
					String farmerName=marketPlace.grape.take(); //takes the front of the grape queue in the market place
					grapes--; //consumed one grape
					System.out.println(Thread.currentThread().getName()+" have got a grape from "+farmerName);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(consumerQuit)
						break;
				}
			}
			/** take watermelons if consumer wants*/
			if(watermelons>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to get watermelons");
					String farmerName=marketPlace.watermelon.take(); //takes the front of the watermelon queue in the market place
					watermelons--; //consumed one watermelon
					System.out.println(Thread.currentThread().getName()+" have got a watermelon from "+farmerName);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(consumerQuit)
						break;
				}
			}
			/**wait for update*/
			if(apples+oranges+grapes+watermelons==0)
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(consumerQuit)
						break;
				} catch (Exception e){
					e.printStackTrace();
				}
		}
	}

	/**
	 * Sets the consumer quit.
	 */
	public void setConsumerQuit() {
		consumerQuit = true;
	}

	/**
	 * Checks if is consumer quit.
	 *
	 * @return true, if is consumer quit
	 */
	private boolean isConsumerQuit() {
		return consumerQuit;
	}
}
