package com.accolite.MultithreadedRestaurant;

public class AveragerClass implements Runnable{
	BillClass billClass = new BillClass();
	boolean startReporter = false;
	public AveragerClass(BillClass billClass) {
		// TODO Auto-generated constructor stub
		this.billClass = billClass;
	}
	
	public void run(){
		System.out.println("In avg run");
		startReporter = billClass.updateAvg();
		if(startReporter){
			Runnable reportClass = new ReporterClass(billClass);
			Thread reportThread = new Thread(reportClass,"reportThread");
			reportThread.start();
		}
	}
}
