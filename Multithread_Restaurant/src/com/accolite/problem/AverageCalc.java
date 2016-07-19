/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.problem;

// TODO: Auto-generated Javadoc
/**
 * The Class AverageCalc.
 */
public class AverageCalc implements Runnable {
	
	
	/** The data. */
	int[] data=new int[3];
	
	/** The data 1. */
	int[] data1=new int[2];
	
	/**
	 * Instantiates a new average calc.
	 */
	public AverageCalc() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new average calc.
	 *
	 * @param data the data
	 */
	public AverageCalc(int[] data){
		this.data=data;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		synchronized (this) {
			
			if(data[2]==0)
				data1[0]=0;
			else
				data1[0]=data[1]/data[2];
			
			data[2]++;
			
			data1[1]=(data[0]+data[1])/data[2];
			
			data[1]=data[0]+data[1];
			
//			System.out.println("Avg: "+data1[1]);
//			System.out.println("c: "+data[2]);
//			System.out.println("s: "+data[1]);
			
			NewAverage newAverage=new NewAverage(data1);
			Thread t2=new Thread(newAverage);
			t2.start();
			
			synchronized (t2) {
				try {
					//System.out.println("Waiting for t2 to complete");
					t2.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
			}
			notify();
		}
		
		// TODO Auto-generated method stub
		
	}

	
	

}
