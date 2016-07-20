package com.accolite.Assignment;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GenerateTotalBill implements Runnable 
{
	
	Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private Restaurant restaurant;
    private int count = 1;
    
    Random r = new Random();
	int n=r.nextInt();

    public GenerateTotalBill(Restaurant r) {
        restaurant = r;
        
    }


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

                System.out.println("Enter the amount of bill to generate bill");
                Scanner input = new Scanner(System.in);
                int rs = input.nextInt();
                
                restaurant.calculateaverageBill.lock.lock();
                try {
                    restaurant.bill = new Bill(count,rs);
                    count++;
                    restaurant.calculateaverageBill.condition.signalAll();
                } finally {
                    restaurant.calculateaverageBill.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Bill generation interrupted!");
        }
	}

}
