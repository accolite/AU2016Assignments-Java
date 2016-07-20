/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package com.accolite.multithread;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class TableBiller.
 */
public class TableBiller implements Runnable {

	/** The table orders. */
	BlockingQueue<TablePojo> tableOrders = null;
	
	/**
	 * Instantiates a new table biller.
	 *
	 * @param orders the orders
	 */
	public TableBiller(BlockingQueue<TablePojo> orders) {
		this.tableOrders = orders;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("--------------Please Enter TableID and bill --------------- ");
			int tableId = sc.nextInt();
			double amount = sc.nextDouble();
			try {
				tableOrders.put(new TablePojo(tableId,amount));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
