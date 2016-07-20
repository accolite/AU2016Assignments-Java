package com_accolite_au16_multiThread_restaurent;

import java.util.Scanner;

public class EmitBill implements Runnable  {
	Bill bill;
	int sum=0;
	int count=0;
	int avg;
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public int getSum() {
		return sum;
	}
	 public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while(true){
		synchronized(bill)
		{	/*try {
			this.wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}*/
			System.out.println("Enter the bill amount ");
			int bill_amount=in.nextInt();
			bill.setBill_amount(bill_amount);
			System.out.println("Enter Table no ");
			int tableNo=in.nextInt();
			bill.setTableNo(tableNo);
			this.notify();		 
		}
	}
	}
	public void notifyAverageBill()
	{	
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this)
		{	System.out.println("new average bill is: "+ getAvg());
			
		}
	}
	public EmitBill(Bill bill) {
		super();
		this.bill = bill;
	}
	void calculateAvg()
	{
		synchronized(this)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				setSum(getSum()+bill.getBill_amount());
				setAvg( getSum()/getCount());
				this.notify();
			
		}
	}
	
	

}
