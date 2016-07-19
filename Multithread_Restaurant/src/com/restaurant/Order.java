/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.restaurant;

// TODO: Auto-generated Javadoc
/**
 * The Class Order.
 */
public class Order {
	
	/** The tableno. */
	int tableno;
	
	/** The amount. */
	float amount;

	/**
	 * Instantiates a new order.
	 */
	Order() {
	};

	/**
	 * Instantiates a new order.
	 *
	 * @param tableno the tableno
	 * @param amount the amount
	 */
	Order(int tableno, float amount) {
		this.tableno = tableno;
		this.amount = amount;
	}

	/**
	 * Gets the tableno.
	 *
	 * @return the tableno
	 */
	public int getTableno() {
		return tableno;
	}

	/**
	 * Sets the tableno.
	 *
	 * @param tableno the new tableno
	 */
	public void setTableno(int tableno) {
		this.tableno = tableno;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
