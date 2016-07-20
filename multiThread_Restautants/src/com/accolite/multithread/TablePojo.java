/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package com.accolite.multithread;

// TODO: Auto-generated Javadoc
/**
 * The Class TablePojo.
 */
public class TablePojo {
	
	/** The table no. */
	private int tableNo;
	
	/** The bill amount. */
	private double bill;
	
	/**
	 * Instantiates a new table pojo.
	 *
	 * @param tableNo the table no
	 * @param billAmount the bill amount
	 */
	public TablePojo(int tableNo, double billAmount) {
		super();
		this.tableNo = tableNo;
		this.bill = billAmount;
	}
	
	
	/**
	 * Gets the bill amount.
	 *
	 * @return the bill amount
	 */
	public double getBill() {
		return bill;
	}
	
	/**
	 * Sets the bill amount.
	 *
	 * @param billAmount the new bill amount
	 */
	public void setBill(double billAmount) {
		this.bill = billAmount;
	}
	
	/**
	 * Gets the table no.
	 *
	 * @return the table no
	 */
	public int getTableNo() {
		return tableNo;
	}
	
	/**
	 * Sets the table no.
	 *
	 * @param tableNo the new table no
	 */
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	
	
	
}
