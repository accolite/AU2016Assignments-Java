package com.accolite.restaurant;

public class Owner extends Thread{
	
	AverageBillAmount avgBillAmt;
	public Owner()
	{
		
	}
	
	public Owner(AverageBillAmount avgBillAmt)
	{
		this.avgBillAmt=avgBillAmt;
	}
	
	public void run()
	{
		float avgValue=avgBillAmt.getAverage();
		System.out.println("Average Amount:"+avgValue);
		System.out.println("---------------------------");
	}
}
