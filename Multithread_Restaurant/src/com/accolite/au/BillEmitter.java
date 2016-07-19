package com.accolite.au;

import java.util.concurrent.atomic.AtomicInteger;

public class BillEmitter implements Runnable{

	AtomicInteger atom = new AtomicInteger(0);
	
	Double bill;
	
	AverageCalculator avgCalc = null;
	
	public BillEmitter(AverageCalculator avgCalc) {
		this.avgCalc = avgCalc;
		this.bill = 0.0D;
	}
	
	public void setNewBill(Double bill){
		synchronized (this) {
			this.bill = bill;
			this.atom.set(1);			
		}
	}
	
	@Override
	public void run() {
		while(true){
			while(atom.get()==0);
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+" :: New bill amount : "+this.bill);
				avgCalc.addNewBill(this.bill);
				this.atom.set(0);
			}
		}
	}

}
