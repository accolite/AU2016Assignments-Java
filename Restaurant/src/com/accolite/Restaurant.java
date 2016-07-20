package com.accolite;

import java.util.Scanner;

public class Restaurant {
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
		
		billEmitterThread.start();
		averageCalcThread.start();
		reporterThread.start();
		
		int choice = 0;
		Double bill = 0.0D;
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.println("\n\nEnter your choice 1-Generate new bill amt 2-Exit");
		    choice = s.nextInt();
			if(choice==1){
				System.out.println("Enter new bill amount:");
				bill = s.nextDouble();
				billEmitter.setNewBill(bill);
			}
			else if(choice!=2){
				System.out.println("Invalid input");
			}
		}while(choice!=2);
		s.close();
	}
}
