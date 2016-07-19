package com.accolite.restaurant;

import java.util.concurrent.BlockingQueue;

public class Reporter implements Runnable {

	BlockingQueue<Float> averageGetter = null;

	/**
	 * Instantiates a reporter
	 * @param averageGetter
	 */
	public Reporter(BlockingQueue<Float> averageGetter){
		this.averageGetter = averageGetter;
	}
	
	/**
	 * Gets new Average when an item is put into AverageGetter
	 */
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("New average is : "+averageGetter.take() );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
