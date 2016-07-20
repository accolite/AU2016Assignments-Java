package com.au.restaurant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Average implements Runnable{
	BlockingQueue B=null;
	BlockingQueue N=null;
	int count;
	double av;
	public Average(double av,int count,BlockingQueue B,BlockingQueue N){
		this.av=av;
		this.count=count;
		this.B=B;
		this.N=N;
	}
	
	@Override
	public void run() {
		double sum=0;
		while(true){
			try {
				sum=(double) B.take();
				count++;
				av=(sum+av*(count-1))/count;
				String p=(count==1)?" bill:-":" bills:-";
				N.put(av);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
