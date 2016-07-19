package com.accolite.au;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Reporter reporter = new Reporter();
		AverageCalculator averageCalculator = new AverageCalculator(reporter);
		BillEmitter billEmitter = new BillEmitter(averageCalculator);
		
		Thread reporterThread = new Thread(reporter);
		reporterThread.setName("Reporter");
		
		Thread averageCalcThread = new Thread(averageCalculator);
		averageCalcThread.setName("Average calculator");
		
		Thread billEmitterThread = new Thread(billEmitter);
		billEmitterThread.setName("Bill emitter");
		
		reporterThread.start();
		averageCalcThread.start();
		billEmitterThread.start();
		
		/*billEmitter.setNewBill(100D);
		Thread.currentThread().sleep(500);
		System.out.println("\n\n");
		billEmitter.setNewBill(100D);
		Thread.currentThread().sleep(500);
		System.out.println("\n\n");
		billEmitter.setNewBill(200D);*/
		
		int op = 0;
		Double bill = 0.0D;
		Scanner scr = new Scanner(System.in);
		
		do{
			System.out.println("\n\nAdd new bill(1)/ Exit(2) ");
			op = scr.nextInt();
			if(op==1){
				System.out.println("New bill amount ? ");
				bill = scr.nextDouble();
				billEmitter.setNewBill(bill);
			}
			else if(op!=2){
				System.out.println("Enter valid input");
			}
		}while(op!=2);
		scr.close();
	}
}
