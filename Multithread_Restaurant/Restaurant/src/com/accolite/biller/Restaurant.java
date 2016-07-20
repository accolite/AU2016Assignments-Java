/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.biller;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurant.
 */
public class Restaurant {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		//system input
		Scanner in = new Scanner(System.in);
		//queue where bill gets added which will be read by Cashier thread
		BlockingQueue<Bill> bill=new ArrayBlockingQueue<>(1);
		//queue where last bill is added by Cashier thread and it is read by AverageFinder thread
		BlockingQueue<Bill> lastBill=new ArrayBlockingQueue<>(1);
		//queue where computed average is added by AverageFinder and it is read by NewAverageInformer
		BlockingQueue<Double> averageBill=new ArrayBlockingQueue<>(1);
		//cashier thread sharing bill with main thread and lastBill with AverageFinder thread
		Cashier cashier=new Cashier(bill,lastBill);
		cashier.start();
		//AverageFinder thread sharing lastBill with Cashier thread and averageBill with NewAverageFinder finder thread
		AverageFinder averageFinder = new AverageFinder(lastBill,averageBill);
		averageFinder.start();
		//NewAverageFinder thread sharing averageBill with AverageFinder thread
		NewAverageInformer newAverageInformer = new NewAverageInformer(averageBill);
		newAverageInformer.start();
		//loop variable
		boolean doLoop=true;
		while(doLoop){
			System.out.println("Enter\n1.Add bill\n2.exit");
			switch(in.nextInt()){
				case 1: System.out.println("Enter #table,bill amount:");
						int tableNumber = in.nextInt();
						double billAmount = in.nextDouble();
						//give the new bill to cashier
						try {
							bill.put(new Bill(tableNumber,billAmount));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				default:
					cashier.myThread.interrupt();
					averageFinder.myThread.interrupt();
					newAverageInformer.myThread.interrupt();
					doLoop=false;
			}
		}
	}

}