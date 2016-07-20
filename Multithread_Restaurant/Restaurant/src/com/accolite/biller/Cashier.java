/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.biller;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Biller.
 */
public class Cashier implements Runnable {
	
	/** The bills. */
	private LinkedList<Bill> bills;
	
	/** The bill queue where we get bill from user. */
	private BlockingQueue<Bill> bill;
	
	/** The last bill queue which is made available for AverageFinder to calculate the average. */
	private BlockingQueue<Bill> lastBill;
	
	/**
	 * Instantiates a new biller.
	 *
	 * @param bill the bill
	 * @param lastBill the last bill
	 */
	public Cashier(BlockingQueue<Bill> bill, BlockingQueue<Bill> lastBill) {
		this.bill=bill;
		this.lastBill=lastBill;
		this.bills= new LinkedList<>();
		myThread=new Thread(this,"Cashier");
	}
	
	/** The Biller thread*/
	Thread myThread;
	
	public LinkedList<Bill> getBills() {
		return bills;
	}
	public void setBills(LinkedList<Bill> bills) {
		this.bills = bills;
	}
	public void start(){
		myThread.start();
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("cashier waiting to get new bill");
				Bill newBill = bill.take();
				bills.add(newBill);
				System.out.println("cahier added the new bill '"+newBill.getTableNumber()+"-"+newBill.getBillAmount()+"'");
				lastBill.put(newBill); //AverageFinder will get this newBill data for computing the average
			} catch (InterruptedException e) {
				System.out.println("Cashier got interrupted");
				break;
			}
		}
	}

}
