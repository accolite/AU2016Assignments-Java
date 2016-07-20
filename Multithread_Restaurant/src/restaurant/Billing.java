package restaurant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import restaurant.Restaurant;

public class Billing implements Runnable {
	ArrayBlockingQueue<Order> order;
	AtomicInteger incrementer;
	private Scanner sc;

	Billing(ArrayBlockingQueue<Order> order, AtomicInteger incrementer) {
		this.incrementer = incrementer;
		this.order = order;

	}

	@Override
	public void run() {
		sc = new Scanner(System.in);
		System.out.println(" Thread billnig started ; enter the bill amount");
		int bill = sc.nextInt();
		Order o = new Order(incrementer.incrementAndGet(), bill);
		try {
			order.put(o);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
