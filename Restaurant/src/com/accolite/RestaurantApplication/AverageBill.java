package com.accolite.RestaurantApplication;

public class AverageBill extends Thread{
	
	public Demo demo;
	private float sum;
	static int timeBillPaid;
	public AverageBill(float tot_bill) {
		// TODO Auto-generated constructor stub
		this.sum = tot_bill;
	}
	
	public AverageBill() {
		// TODO Auto-generated constructor stub
	}


	public void setTotBill(float tot_bill){
		this.sum = tot_bill;
	}
	
	@Override
	public void run(){
		timeBillPaid++;
		float avg = sum/timeBillPaid;
		demo.printAverageOfBills(avg);
	}

}
