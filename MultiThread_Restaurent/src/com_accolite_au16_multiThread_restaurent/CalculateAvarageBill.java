package com_accolite_au16_multiThread_restaurent;

public class CalculateAvarageBill implements Runnable{
	int sum=0;
	int count=0;
	 Bill bill;
	 int avg;
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	@Override
	public void run() {
		calculateAverage();
		
	}
	synchronized public int getSum() {
		return sum;
	}
	synchronized public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	synchronized void calculateAverage()
	{	try {
			this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		setCount(getCount()+1);
		synchronized (bill) {
			setSum(getSum()+bill.getBill_amount());
			setAvg( getSum()/getCount());
			this.notify();
		}
	}
	public CalculateAvarageBill(Bill bill) {
		super();
		this.bill = bill;
	}
}
