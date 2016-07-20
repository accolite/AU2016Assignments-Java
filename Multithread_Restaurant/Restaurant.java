package com.accolite.assignmnet;

import java.util.Scanner;

public class Restaurant {
	public static Table table;
	public static int avgBillAmout = 0;
	public static BillAmountThread billAmountThread;
	public static AvgBillAmountThread avgBillAmountThread;
	public static Owner ownerThread;
	public static int noOfOrders = 0;
	public static Buffer bill = new Buffer(100);
	public static int ownerFalg = 0;

	public static void main(String[] args) {
		int billAmount;
		billAmountThread = new BillAmountThread();
		avgBillAmountThread = new AvgBillAmountThread();
		ownerThread = new Owner();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String answer = null;
		billAmountThread.start();
		avgBillAmountThread.start();
		ownerThread.start();
		do {
			System.out.println("Enter the bill amount for a table");
			billAmount = scan.nextInt();
			noOfOrders += 1;
			bill.setBillAmounts(billAmount);
			System.out.println("Yes or No");
			answer = scan.next();
		} while (answer.equalsIgnoreCase("yes"));
	}

}
