package com.accolite.multithreading;

public class Bill 
{
	 	int orderNum;
	    int billAmount;

	    public Bill(int orderNum,int billAmount) {
	        this.orderNum = orderNum;
	        this.billAmount=billAmount;
	    }

	    public String toString() {
	        return "Bill " + orderNum;
	    }
}
