package com.accolite.BillProblem;

import java.util.concurrent.ArrayBlockingQueue;

public class NotifyManager implements Runnable {
	ArrayBlockingQueue average=null;

	public NotifyManager() {
	super();
}

	public NotifyManager(ArrayBlockingQueue average) {
	super();
	this.average = average;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(average.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
