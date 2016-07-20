package com_accolite_au16_multiThread_restaurent;

public class Bill {
	int bill_amount;
	int tableNo;
	public Bill(int bill_amount, int tableNo) {
		super();
		this.bill_amount = bill_amount;
		this.tableNo = tableNo;
	}
	public Bill() {
	}
	public int getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(int bill_amount) {
		this.bill_amount = bill_amount;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	
}
