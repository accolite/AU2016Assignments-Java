package com.accolite.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AverageBill implements Runnable  {
	
	Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private Restaurant restaurant;
    int avgbill=0;

    public AverageBill(Restaurant r) {
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

                restaurant.payment.lock.lock();
                try {
                   // 
                    System.out.println("Calculating Average Bill");
                    avgbill = ((avgbill * (restaurant.bill.orderNum-1) ) + restaurant.bill.billAmount)/restaurant.bill.orderNum;
                    System.out.println("Computed Bill->"+avgbill);
                    restaurant.bill = null;
                    restaurant.payment.condition.signalAll(); //Ready for another
                } finally {
                    restaurant.payment.lock.unlock();
                }

                try {
                    restaurant.owner.lock.lock();
                    System.out.println("Notifying Owner about the new bill...");
                    restaurant.owner.condition.signalAll();
                } finally {
                    restaurant.owner.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("AvgBill interrupted!");
        }

		
	}

}
