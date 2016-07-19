/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 20, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.restaurant;

/**
 * The Class BillPayer to start processing of bills
 */
public class BillPayer implements Runnable {
	
    private String name;
    private Float bill;
    

    public BillPayer(String name, Float bill){
        this.name=name;
        this.bill=bill;
    }
    
    public Float getBill(){
    	return bill;
    }

    @Override
    public void run() {
        System.out.println(this+" starts processing for Amount "+ getBill());
    }

    @Override
    public String toString(){
        return this.name;
    }
}
