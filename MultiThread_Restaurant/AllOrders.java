package com.accolite.restaurant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;


public class AllOrders {

    private static Scanner in;
    public static int count = 0;
    
    
    public static void main(String[] args) {
    
    	/**
    	 * Saving all the bills using Thread-safe Atomic reference
    	 */
    	AtomicReference<ArrayList<Float>> billsToPersist = new AtomicReference<ArrayList<Float>>();
    	billsToPersist.set(new ArrayList<>());
    	
    	/**
    	 * Continuation criteria
    	 */
        boolean cnt = true;
        
        /**
         * Average blocking queue for Reporter(Consumer) and Calculator(Producer)
         */
        BlockingQueue<Float> averageGetter = new ArrayBlockingQueue<>(1);
        
        /**
         * Reporter
         */
        Runnable reporter = new Reporter(averageGetter);
        new Thread(reporter).start();
        
        while(cnt){
        	/**
        	 * Bill payment
        	 */
        	System.out.println("Enter bill to pay @order-"+count++);
        	Float bill = in.nextFloat();
            Runnable payableBill = new BillPayer("order-" + count, bill);
            new Thread(payableBill).start();
            
            /**
             * Average calculation
             */
            Runnable calculation = new Calculator(bill, averageGetter, billsToPersist);
            new Thread(calculation).start();
            
            /**
             * Continue?
             */
            System.out.println("Continue? y/n");
            if(in.next().equals("y"))
            	cnt = true;
            else
            	cnt = false;
        }
        
    }

}
