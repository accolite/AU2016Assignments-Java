package org.au.restaurant;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Biller implements Runnable {

	BlockingQueue<Order> orders = null;
	
	public Biller(BlockingQueue<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.print("Enter Table and bill amount : ");
			int tableNo = in.nextInt();
			double amount = in.nextDouble();
			try {
				orders.put(new Order(tableNo,amount));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
