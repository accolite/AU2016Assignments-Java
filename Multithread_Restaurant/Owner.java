package com.accolite.assignmnet;

public class Owner extends Thread {
	public Owner() {

	}

	public void run() {
		while (true) {
			System.out.println("owner is printing " + Restaurant.bill.getAvgBillAmount());
		}
	}
}
