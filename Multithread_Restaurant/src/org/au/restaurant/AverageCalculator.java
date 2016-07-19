package org.au.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class AverageCalculator implements Runnable {

	BlockingQueue<Order> orders = null;
	BlockingQueue<Double> averageQueue = null;
	static List<Order> allOrders = new ArrayList<Order>();

	public AverageCalculator(BlockingQueue<Order> orders, BlockingQueue<Double> averageQueue) {
		super();
		this.orders = orders;
		this.averageQueue = averageQueue;
	}

	@Override
	public void run() {

		while (true) {

			Order order = null;
			try {
				order = orders.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			double amount = order.getBillAmount();
			double total = 0;
			for (Order order2 : allOrders) {
				total += order2.getBillAmount();
			}
			double previousAverage = total / allOrders.size();
			allOrders.add(order);
			double newAverage = (total + amount) / (allOrders.size());

			if (Double.compare(previousAverage, newAverage) != 0) {
				try {
					averageQueue.put(newAverage);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
