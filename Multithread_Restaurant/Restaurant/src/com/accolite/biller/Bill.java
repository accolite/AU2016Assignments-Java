/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.biller;

// TODO: Auto-generated Javadoc
/**
 * The Class Bill.
 */
public class Bill {
	
	/** The table. */
	private int tableNumber;
	
	/** The bill amount. */
	private double billAmount;

	/**
	 * Instantiates a new bill.
	 *
	 * @param table the table
	 * @param billAmount the bill amount
	 */
	public Bill(int table, double billAmount) {
		super();
		this.tableNumber = table;
		this.billAmount = billAmount;
	}

	/**
	 * Instantiates a new bill.
	 */
	public Bill() {
		super();
	}

	/**
	 * Gets the tableNumber.
	 *
	 * @return the tableNumber
	 */
	public int getTableNumber() {
		return tableNumber;
	}

	/**
	 * Sets the tableNumber.
	 *
	 * @param table the new tableNumber
	 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	/**
	 * Gets the bill amount.
	 *
	 * @return the bill amount
	 */
	public double getBillAmount() {
		return billAmount;
	}

	/**
	 * Sets the bill amount.
	 *
	 * @param billAmount the new bill amount
	 */
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
}
