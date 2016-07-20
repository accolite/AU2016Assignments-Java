package com.accolite.assignmnet;

public class AvgBillAmountThread extends Thread {

	public static int order = 0;

	public void run() {
		int total = 0;

		while (order < 100) {
			total += (int) Restaurant.bill.getBillAmounts();
			Restaurant.avgBillAmout = total / (order + 1);
			Restaurant.bill.setAvgBillAmount(Restaurant.avgBillAmout);
			order++;
			System.out.println("The average bill is" + Restaurant.avgBillAmout);
		}
	}
}