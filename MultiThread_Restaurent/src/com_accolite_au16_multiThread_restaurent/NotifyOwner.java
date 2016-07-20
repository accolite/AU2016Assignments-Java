package com_accolite_au16_multiThread_restaurent;

public class NotifyOwner implements Runnable{
	
	CalculateAvarageBill AvgBill;
	@Override
	public void run() {
		notifyAverageBill();
		
	}
	public NotifyOwner(CalculateAvarageBill avgBill) {
		super();
		AvgBill = avgBill;
	}
	public void notifyAverageBill()
	{	
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (AvgBill)
		{	System.out.println("new average bill is: "+ AvgBill.getAvg());
			
		}
	}
}
