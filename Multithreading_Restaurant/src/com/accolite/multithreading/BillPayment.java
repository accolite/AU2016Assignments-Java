package com.accolite.multithreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BillPayment implements Runnable
{
	
	Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private Restaurant restaurant;
    private int count = 0;
    
    Random r = new Random();
	int n=r.nextInt();
	

    public BillPayment(Restaurant r) {
        restaurant = r;
        
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {

                    while (restaurant.bill != null) {
                        condition.await();//... for the bill to be taken
                    }
                } finally {
                    lock.unlock();
                }
               // System.out.println("Random Number"+n);
                if (++count == n) {
                	
                    System.out.println("closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                System.out.println("Bill Generated!");
                System.out.println("Enter the amount of bill");
                Scanner input = new Scanner(System.in);
                int amount = input.nextInt();
                
                restaurant.avgbill.lock.lock();
                try {
                    restaurant.bill = new Bill(count,amount);
                    restaurant.avgbill.condition.signalAll();
                } finally {
                    restaurant.avgbill.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Bill interrupted!");
        }
	}
	
}
