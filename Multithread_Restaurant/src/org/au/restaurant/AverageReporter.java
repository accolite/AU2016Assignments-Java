package org.au.restaurant;

import java.util.concurrent.BlockingQueue;

import javax.tools.ToolProvider;

public class AverageReporter implements Runnable {

	BlockingQueue<Double> averageQueue = null;	
	
	public AverageReporter(BlockingQueue<Double> averageQueue) {
		super();
		this.averageQueue = averageQueue;
	}


	@Override
	public void run() {
		while(true){
			Double toPrint = 0.0;
			try {
				toPrint = averageQueue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("New Average : " + toPrint);
		}
	}

}
