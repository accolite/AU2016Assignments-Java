package com.accolite;

import java.util.concurrent.atomic.AtomicInteger;

public class AverageCalculator implements Runnable {

	Double average;
	Double total;
	int count;
	
	Reporter reporter = null;
	
	AtomicInteger atom = new AtomicInteger(0);
	
	public AverageCalculator(Reporter reporter) {
		this.average = 0D;
		this.total = 0D;
		this.count = 0;
		this.reporter = reporter;
	}
	
	public void addNewBill(double newBill){
		synchronized (this) {
			this.count++;
			this.total += newBill;
			atom.set(1);
		}
	}
	
	@Override
	public void run() {
		while(true){
			while(atom.get() == 0);
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+" :: Got new bill. Calculating average");
				Double oldAverage = this.average;
				this.average = total/count;
				if(!this.average.equals(oldAverage)){
					System.out.println(Thread.currentThread().getName()+" :: Average changed from "+oldAverage+" to "+this.average);
					reporter.setNewAverage(this.average);
				}
				else
					System.out.println(Thread.currentThread().getName()+" :: Average didn't change");
				atom.set(0);				
			}
		}
	}

}