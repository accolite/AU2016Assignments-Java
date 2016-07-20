package com.accolite.MultithreadedRestaurant;

public class ReporterClass implements Runnable{
	BillClass billClass = new BillClass();
	public ReporterClass(BillClass billClass) {
		// TODO Auto-generated constructor stub
		this.billClass = billClass;
	}
	public void run(){
		System.out.println("In reporter run");
		//billClass.checkIfAvgUpdated();
		System.out.println(billClass.getAvg());
	}
}
