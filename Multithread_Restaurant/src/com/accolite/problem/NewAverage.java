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
 * The Class NewAverage.
 */
public class NewAverage implements Runnable {

	/** The data 1. */
	int[] data1={0,0};
	
	/**
	 * Instantiates a new new average.
	 */
	public NewAverage() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new new average.
	 *
	 * @param data1 the data 1
	 */
	public NewAverage(int[] data1){
		this.data1=data1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			if(data1[0]==data1[1])
				System.out.println("No change in Average: "+data1[1]);
			else
				System.out.println("New Average: "+data1[1]);
			notify();
			
		}
	}

}
