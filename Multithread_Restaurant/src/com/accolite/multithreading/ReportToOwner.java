package com.accolite.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReportToOwner implements Runnable  {
	
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
	    Condition condition = lock.newCondition();

	    Restaurant restaurant;

	    ReportToOwner(Restaurant r) {
	        restaurant = r;
	    }
	    @Override
	    
	    public void run() {
	        try {
	            while (!Thread.interrupted()) {

	                lock.lock();
	                try {
	                    condition.await();
	                    System.out.println("Owner has been notified!\n");
	                } finally {
	                    lock.unlock();
	                }
	            }
	        } catch (InterruptedException e) {
	            System.out.println("Owner notification interrupted!");
	        }
	    

	}

}
