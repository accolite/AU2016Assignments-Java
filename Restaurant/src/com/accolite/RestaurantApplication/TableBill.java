package com.accolite.RestaurantApplication;

public class TableBill extends Thread{
	
	public Demo demo;
	private float bill;
	private static float tot_bill;
	public TableBill(float bill){
		this.bill = bill;
	}
	
	public TableBill() {
		// TODO Auto-generated constructor stub
	}

	public void setBill(float bill){
		this.bill = bill;
	}
	@Override
	public void run(){
		tot_bill += bill;
		AverageBill avg = new AverageBill();
		avg.setTotBill(tot_bill);
		avg.demo = demo;
		avg.start();
	}

}
