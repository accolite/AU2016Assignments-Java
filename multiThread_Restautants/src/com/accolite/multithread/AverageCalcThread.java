/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package com.accolite.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class AverageCalcThread.
 */
public class AverageCalcThread implements Runnable {
	
	/** The prev average. */
	BlockingQueue<Double> prevAverage = null;
	
	/** The table orders. */
	BlockingQueue<TablePojo> tableOrders = null;
	
	/** The average queue. */
	BlockingQueue<Double> averageQueue = null;	
	
	/** The orders data. */
	static List<TablePojo> ordersData = new ArrayList<TablePojo>();

	/**
	 * Instantiates a new average calc thread.
	 *
	 * @param orders the orders
	 * @param averageQueue the average queue
	 * @param prevAverage the prev average
	 */
	public AverageCalcThread(BlockingQueue<TablePojo> orders, BlockingQueue<Double> averageQueue,
			BlockingQueue<Double> prevAverage) {
		super();
		this.tableOrders = orders;
		this.averageQueue = averageQueue;
		this.prevAverage = prevAverage;
	}

	/**
	 * Run.
	 */
	@Override
	public void run() {

		/*
		 * TablePojo order = null;
		 * 
		 * try { order = orders.take(); } catch (InterruptedException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * double amount = order.getBillAmount(); // System.out.println("hail "
		 * + prevAverage.peek());
		 * 
		 * double newAverage = 0; if (prevAverage.peek() == null) { newAverage =
		 * amount; try { prevAverage.put(newAverage); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } //System.out.println("New Average : " +
		 * newAverage); try { orders.put(order); } catch (InterruptedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * notifyAll(); synchronized(t1) { try { t1.wait(); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } } else { newAverage = (prevAverage.peek() +
		 * amount) / (orders.size() + 1);
		 * 
		 * if (Double.compare(prevAverage.peek(), newAverage) != 0) { try {
		 * prevAverage.put(newAverage); //System.out.println("New Average : " +
		 * newAverage); orders.put(order);
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * notifyAll(); synchronized(t1) { try { t1.wait(); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * }
		 * 
		 * 
		 */
		while (true) {

			TablePojo order = null;

			try {
				order = tableOrders.take();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			double currentAmount = order.getBill();

			double totalAmount = 0;

			for (TablePojo order2 : ordersData) {
				totalAmount += order2.getBill();
			}
			double previousAverage = totalAmount / ordersData.size();
			ordersData.add(order);
			double newAverage = (totalAmount + currentAmount) / (ordersData.size());

			if (Double.compare(previousAverage, newAverage) != 0) {
				try {
					averageQueue.put(newAverage);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
