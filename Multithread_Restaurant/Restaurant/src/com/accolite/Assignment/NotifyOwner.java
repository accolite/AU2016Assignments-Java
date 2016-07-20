package com.accolite.Assignment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyOwner implements Runnable  {
	
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
	    Condition condition = lock.newCondition();

	    Restaurant restaurant;

	    NotifyOwner(Restaurant r) {
	        restaurant = r;
	    }
	    public void run() {
	        try {
	            while (!Thread.interrupted()) {

	                lock.lock();
	                try {
	                    condition.await();
	                    System.out.println("Owner has been notified by Thread!\n");
	                } finally {
	                    lock.unlock();
	                }
	            }
	        } catch (InterruptedException e) {
	            System.out.println("Owner notification interrupted!");
	        }
	    

	}

}
