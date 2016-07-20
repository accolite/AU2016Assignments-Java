package com.accolite.MultithreadedRestaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdaterClass implements Runnable{
	BillClass billClass = new BillClass();
	int bill = 0;
	public UpdaterClass(BillClass billClass, int bill) {
		// TODO Auto-generated constructor stub
		this.billClass = billClass;
		this.bill = bill;
	}
	public void run(){
		
		billClass.addBillItem(bill);
		Runnable averagerClass= new AveragerClass(billClass);
		Thread averageThread = new Thread(averagerClass,"averagerThread");
		averageThread.start();
		try {
			averageThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
