package com.accolite;

import java.util.concurrent.atomic.AtomicInteger;

public class Reporter implements Runnable{

	AtomicInteger atom = new AtomicInteger(0);
	
	Double average;
	
	public Reporter(){
		this.average = 0.0D;
	}
	
	public void setNewAverage(Double average){
		synchronized (this) {
			this.average = average;
			atom.set(1);
		}
	}
	

	
	@Override
	public void run() {
		while(true){
			while(atom.get()==0);
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+" :: Average changed to "+this.average);
				atom.set(0);
			}
		}
	}

}
