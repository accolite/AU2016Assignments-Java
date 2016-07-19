/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.Restaurant;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurant.
 */
public class Restaurant {

	//Using Blocking Queue to maintain Synchronization
	
	/** The Waiter Queue. */
	BlockingQueue WaiterBill=null;
	
	/** The Cashier Queue. */
	BlockingQueue CashierBill=null;
	
	/** The Aggregator Queue. */
	BlockingQueue AggregatorBill=null;
	
	/** The waiter object. */
	Waiter waiter;
	
	/** The cashier object. */
	Cashier cashier;
	
	/** The aggregator object. */
	Aggregator aggregator;
	
	/** The waiter,cashier and aggregator threads. */
	Thread waiter_thread,cashier_thread,aggregator_thread;
	
	/**
	 * Instantiates a new restaurant.
	 */
	public Restaurant() {
		super();
		WaiterBill=new ArrayBlockingQueue<>(2);
		CashierBill=new ArrayBlockingQueue<>(2);
		AggregatorBill=new ArrayBlockingQueue<>(1);
		waiter=new Waiter(WaiterBill,CashierBill);
		waiter_thread=new Thread(waiter);
		cashier=new Cashier(CashierBill,AggregatorBill);
		cashier_thread=new Thread(cashier);
		aggregator=new Aggregator(AggregatorBill);
		aggregator_thread=new Thread(aggregator);
		
	}
	
	/**
	 * Start restaurant.
	 * starting the threads
	 */
	private void startRestaurant() {
		// TODO Auto-generated method stub
		waiter_thread.start();
		cashier_thread.start();
		aggregator_thread.start();
	}
	
	/**
	 * Paying Bill
	 * giving the values to Waiter to process
	 *
	 * @param table_no the table no
	 * @param bill_amount the bill amount
	 * @throws InterruptedException the interrupted exception
	 */
	public void PayBill(int table_no, double bill_amount) throws InterruptedException {
		// TODO Auto-generated method stub
		WaiterBill.put(table_no);
		WaiterBill.put(bill_amount);
	}
	
	/**
	 * Interupt threads.
	 * To stop all the running threads by handling interrupts
	 * 
	 */
	public void InteruptThreads(){
		waiter_thread.interrupt();
		cashier_thread.interrupt();
		aggregator_thread.interrupt();
	}
	
	/**
	 * The main method to start Restaurant and all threads
	 * 
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Restaurant restaurant=new Restaurant();
		String flag="true";
		int table_no;
		double bill_amount;
		Scanner sc=new Scanner(System.in);
		/** Starting Threads */
		restaurant.startRestaurant();             
		System.out.println("Welcome to the Restaurant\n---------------------------");
		System.out.println("Pick Any Table:0 to 5");
		while(flag.equalsIgnoreCase("true")){
			try{
				System.out.println("Enter table number and bill amount:");
				table_no=sc.nextInt();
				bill_amount=sc.nextDouble();
				restaurant.PayBill(table_no,bill_amount);
				System.out.println("Continue??  yes->true/No->false");
				flag=sc.next();
			}catch(InterruptedException e){
				System.out.println("Exception");
			}
		}
		/** Interrupting Threads */
		restaurant.InteruptThreads();      
		System.out.println("\t\tRestaurant Closed\n\tThank You\tVisit Again");
	}
	
}
