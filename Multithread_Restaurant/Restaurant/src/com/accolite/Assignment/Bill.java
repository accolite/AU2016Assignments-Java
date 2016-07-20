package com.accolite.Assignment;

public class Bill 
{
	 	int orderNum;
	    int totalbillAmount;

	    public Bill(int orderNum,int billAmount) {
	        this.orderNum = orderNum;
	        this.totalbillAmount=billAmount;
	    }

	    public String toString() {
	        return " " + orderNum;
	    }
}
