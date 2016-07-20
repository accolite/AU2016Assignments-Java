package com.accolite.assignmnet;

public class BillAmountThread extends Thread {

	public void run() {
		while (true) {
			System.out.println("In bill amount thread :" + Restaurant.bill.getBillAmounts());
		}
	}
}
