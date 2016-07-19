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
			billsToPersist.get().add(bill);	
			
			averageGetter.put((float) billsToPersist.get().stream().mapToDouble(a->a).average().getAsDouble());
			System.out.println("Average calculated: "+averageGetter.peek());
			
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
