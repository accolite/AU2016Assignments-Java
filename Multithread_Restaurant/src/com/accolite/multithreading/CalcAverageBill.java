package com.accolite.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CalcAverageBill implements Runnable  {
	
	Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private Restaurant restaurant;
    int avgbill=0;

    public CalcAverageBill(Restaurant r) {
        restaurant = r;
    }


	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.bill == null) {
                        condition.await(); //... for the bill to be generated
                    }
                } finally {
                    lock.unlock();
                }
                System.out.println("Got Bill " + restaurant.bill);

                restaurant.genbill.lock.lock();
                try {
                   // 
                    System.out.println("Average Bill Under Calculation");
                    avgbill = ((avgbill * (restaurant.bill.orderNum-1) ) + restaurant.bill.billAmount)/restaurant.bill.orderNum;
                    System.out.println("Average bill computed->"+avgbill);
                    restaurant.bill = null;
                    restaurant.genbill.condition.signalAll(); //Ready for another
                } finally {
                    restaurant.genbill.lock.unlock();
                }

                try {
                    restaurant.reportToOwner.lock.lock();
                    System.out.println("Notifying Owner about the new bill...");
                    restaurant.reportToOwner.condition.signalAll();
                } finally {
                    restaurant.reportToOwner.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("AvgBill interrupted!");
        }

		
	}

}
