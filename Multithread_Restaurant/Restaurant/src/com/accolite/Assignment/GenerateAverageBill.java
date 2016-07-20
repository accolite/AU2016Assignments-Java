package com.accolite.Assignment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GenerateAverageBill implements Runnable  {
	
	Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private Restaurant restaurant;
    int avgbill=0;

    public GenerateAverageBill(Restaurant r) {
        restaurant = r;
    }


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

                restaurant.genrateBill.lock.lock();
                try {
                   
                   
                    avgbill = ((avgbill * (restaurant.bill.orderNum-1) ) + restaurant.bill.totalbillAmount)/restaurant.bill.orderNum;
                    System.out.println("Generated Average bill = "+avgbill);
                    restaurant.bill = null;
                    restaurant.genrateBill.condition.signalAll(); //Ready for another
                } finally {
                    restaurant.genrateBill.lock.unlock();
                }

                try {
                    restaurant.notifyowner.lock.lock();
                    System.out.println("Owner has notified about the new Bill...");
                    restaurant.notifyowner.condition.signalAll();
                } finally {
                    restaurant.notifyowner.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("AvgBill interrupted!");
        }

		
	}

}
