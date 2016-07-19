/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.market;

// TODO: Auto-generated Javadoc
/**
 * The Class Farmer. Represents the farmer who have got set of fruits to sell in
 * the market
 */
public class Farmer implements Runnable {

	/**  The number of apples. */
	int apples;

	/**  The number of grapes. */
	int grapes;

	/** The number of oranges. */
	int oranges;

	/** The number of watermelons. */
	int watermelons;

	/**  The flag which denotes whether farmer quits or not. */
	boolean farmerQuit;

	/** The marketPlace which maintains the queues */
	MarketPlace marketPlace;
	
	/** The thread object */
	Thread myThread;
	
	/**
	 * Instantiates a new consumer.
	 *
	 * @param apples the number of apples
	 * @param grapes the number of grapes
	 * @param oranges the number of oranges
	 * @param watermelons the number of watermelons
	 * @param marketPlace the market place where various queues present
	  * @param name the name of the farmer
	 */
	public Farmer(int apples, int grapes, int oranges, int watermelons, MarketPlace marketPlace,String name) {
		super();
		this.apples = apples;
		this.grapes = grapes;
		this.oranges = oranges;
		this.watermelons = watermelons;
		this.marketPlace = marketPlace;
		myThread = new Thread(this,name);
	}
	
	/**
	 * Start the thread.
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
		while (!isFarmerQuit()) {
			/** sell apples if farmer wants*/
			if(apples>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to bring apples to market place");
					marketPlace.apple.put(Thread.currentThread().getName());; //puts the apple into back of the apple queue in the market place
					apples--; //brought one apple
					System.out.println(Thread.currentThread().getName()+" have brought an apple into market place");
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(farmerQuit)
						break;
				}
			}
			/** sell oranges if farmer wants*/
			if(oranges>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to bring oranges to market place");
					marketPlace.orange.put(Thread.currentThread().getName());; //puts the orange into back of the orange queue in the market place
					oranges--; //brought one orange
					System.out.println(Thread.currentThread().getName()+" have brought an orange into market place");
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(farmerQuit)
						break;
				}
			}
			/** sell grapes if farmer wants*/
			if(grapes>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to bring grapes to market place");
					marketPlace.grape.put(Thread.currentThread().getName());; //puts the grape into back of the grape queue in the market place
					grapes--; //brought one grape
					System.out.println(Thread.currentThread().getName()+" have brought a grape into market place");
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(farmerQuit)
						break;
				}
			}
			/** sell watermelons if farmer wants*/
			if(watermelons>0){
				try {
					System.out.println(Thread.currentThread().getName()+" waiting to bring watermelons to market place");
					marketPlace.watermelon.put(Thread.currentThread().getName());; //puts the watermelon into back of the watermelon queue in the market place
					watermelons--; //brought one watermelon
					System.out.println(Thread.currentThread().getName()+" have brought a watermelon into market place");
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(farmerQuit)
						break;
				}
			}
			/**wait for update*/
			if(apples+oranges+grapes+watermelons==0)
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" interrupted");
					if(farmerQuit)
						break;
				} catch (Exception e){
					e.printStackTrace();
				}
		}
	}

	/**
	 * Sets the farmer quit.
	 */
	public void setFarmerQuit() {
		farmerQuit = true;
	}

	/**
	 * Checks if is farmer quit.
	 *
	 * @return true, if is farmer quit
	 */
	private boolean isFarmerQuit() {
		return farmerQuit;
	}

}
