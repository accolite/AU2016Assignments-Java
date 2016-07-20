/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 20, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.restaurant;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * The Calculator to calculate running average
 *
 */
public class Calculator implements Runnable{

	Float bill;
	BlockingQueue<Float> averageGetter = null;
	AtomicReference<ArrayList<Float>> billsToPersist = null;
	
	/**
	 * Instantiates a calculator
	 * @param bill
	 * @param averageGetter
	 * @param billsToPersist
	 */
	public Calculator(Float bill, BlockingQueue<Float> averageGetter, AtomicReference<ArrayList<Float>> billsToPersist){
		this.averageGetter = averageGetter;
		this.bill = bill;
		this.billsToPersist = billsToPersist;
	}
	
	/**
	 * Change average 
	 */
	private void changeAverage(){
		try {
			
			Thread.sleep(5000);
			OptionalDouble prevAverage = billsToPersist.get().stream().mapToDouble(a->a).average();
			Float prevAvg = 0.0F;
			
			/**
			 * Check if any element exist in billsToPersist
			 */
			if(prevAverage.isPresent())
				prevAvg = (float) prevAverage.getAsDouble();
			billsToPersist.get().add(bill);	
			Float newAvg = (float) billsToPersist.get().stream().mapToDouble(a->a).average().getAsDouble();
			
			/**
			 * Only update Average when new average is found
			 */
			if(!prevAvg.equals(newAvg))
				averageGetter.put((float) billsToPersist.get().stream().mapToDouble(a->a).average().getAsDouble());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		changeAverage();
	}

}
