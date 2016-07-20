/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.Restaurant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// TODO: Auto-generated Javadoc
/**
 * The Class Waiter.
 */
public class Waiter implements Runnable {
	
	/** The Waiter Queue. */
	BlockingQueue WaiterBill=null;
	
	/** The Cashier Queue. */
	BlockingQueue CashierBill=null;
	
	/** The customer. */
	AtomicInteger customer=null;
	
	/** The Table. */
	double Table[]=null;
	
	/**
	 * Instantiates a new waiter.
	 *
	 * @param waiterBill the waiter bill
	 * @param cashierBill the cashier bill
	 */
	public Waiter(BlockingQueue waiterBill, BlockingQueue cashierBill) {
		super();
		WaiterBill = waiterBill;
		CashierBill = cashierBill;
		customer=new AtomicInteger(0);
		Table=new double[6];
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int table_no;
		double bill_amount;
		for(int i=0;i<6;i++)
			Table[i]=0;
		while(true){
			try {
				/** Getting the input from WaiterQueue */
				table_no=(int) WaiterBill.take();        
				bill_amount=(double)WaiterBill.take();
				Table[table_no]+=bill_amount;
				System.out.println("Waiter to Cashier:");
				for(int i=0;i<6;i++)
					System.out.println("Table "+i+": "+Table[i]);
				/** Inserting the values into Cashier Queue */
				CashierBill.put(customer.incrementAndGet());   
				CashierBill.put(bill_amount);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				/** Handling Interruption */
				System.out.println("Waiter Thread Stopped");     
				break;
			}
			
		}
	}
	

}
