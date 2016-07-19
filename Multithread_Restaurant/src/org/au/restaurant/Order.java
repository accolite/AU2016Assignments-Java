package org.au.restaurant;

public class Order {
	private int tableNo;
	private double billAmount;
	
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	public Order(int tableNo, double billAmount) {
		super();
		this.tableNo = tableNo;
		this.billAmount = billAmount;
	}
	
	

}
