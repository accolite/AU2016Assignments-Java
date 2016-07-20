package com.accolite.restaurant;

public class AverageBillAmount extends Thread{
	
	public AverageBillAmount() {
		// TODO Auto-generated constructor stub
	}
	
	BillAmount billAmount;
	
	public AverageBillAmount(BillAmount billAmount) {
		// TODO Auto-generated constructor stub
		 this.billAmount=billAmount;
    }
	
	static float averageBillAmount=0;
	static float totalBillAmount=0;
	static int count=0;
		 
	public void run() {
		try {
			 	count+=1;
		        double currentBillAmount = billAmount.getBillAmount();
		        System.out.println("Current bill amount: " + currentBillAmount);
		        setAverage(currentBillAmount,count);
		    } 
		    catch( InterruptedException e ) { 
		    	e.printStackTrace();
		    }
	}
	
	private static void setAverage(double currentBillAmount,int count)
	{
		totalBillAmount+=currentBillAmount;
		System.out.println("Total Bill Amount:"+totalBillAmount);
		averageBillAmount=totalBillAmount/count;
	}
	
	public float getAverage()
	{
		return averageBillAmount;
	}
}

