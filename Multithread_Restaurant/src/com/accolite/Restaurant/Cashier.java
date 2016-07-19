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

// TODO: Auto-generated Javadoc
/**
 * The Class Cashier.
 */
public class Cashier implements Runnable{
	
	/** The Cashier Queue. */
	BlockingQueue CashierBill=null;
	
	/** The Aggregator Queue. */
	BlockingQueue AggregatorBill=null;
	
	/** The Total average. */
	double Total_Average;
	
	/**
	 * Instantiates a new cashier.
	 *
	 * @param cashierBill the cashier bill
	 * @param aggregatorBill the aggregator bill
	 */
	public Cashier(BlockingQueue cashierBill, BlockingQueue aggregatorBill) {
		super();
		CashierBill = cashierBill;
		AggregatorBill = aggregatorBill;
		Total_Average=0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int no_of_customer;
		double current_bill;
		while(true){
			try {
				/**   Getting the value from Cashier Queue   */
				no_of_customer=(int) CashierBill.take();     
				current_bill=(double) CashierBill.take();
				/** Calculating Average */
				Total_Average=((Total_Average*(no_of_customer-1))+current_bill)/no_of_customer;
				/** Inserting the values into Aggregator Queue  */
				AggregatorBill.put(Total_Average);          
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				/** Handling Interruption */
				System.out.println("Cashier Thread Stopped");     
				break;
			}
		}
		
	}
	

}
