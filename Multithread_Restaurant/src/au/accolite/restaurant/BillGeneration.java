/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package au.accolite.restaurant;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class BillGeneration.
 */
public class BillGeneration implements Runnable{

	/** The bill queue. */
	BlockingQueue<Order> billQueue=new ArrayBlockingQueue<>(1);
	
	/** The amount. */
	int amount;
	
	/**
	 * Instantiates a new bill generation.
	 *
	 * @param billQueue the bill queue
	 */
	public BillGeneration(BlockingQueue<Order> billQueue) {
		
		this.billQueue=billQueue;
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		Order order=new Order();
		Scanner input=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Enter table number");
			order.setTableNo(input.nextInt());
			System.out.println("Enter bill amount\n");
			order.setAmount(input.nextDouble());
			
			try {
				billQueue.put(order);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
