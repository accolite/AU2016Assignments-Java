package com.accolite.threadAssignMent;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {

	protected BlockingQueue<Fruit> queue = null;

	public Customer() {
		this.queue = Demo.queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//while (!queue.isEmpty()) {
			try {
				System.out.println("insert the name of fruit want to take out");
				Scanner in = new Scanner(System.in);
				String name = in.next(); 
				//Thread.sleep(1000);
				synchronized (this) {
					ArrayList<Fruit> list = new ArrayList<Fruit>();
					int initial_size = queue.size();
			        Fruit takenFruit = queue.take();
					int found_position = -1;
					while (takenFruit != null) {
						if (takenFruit.getName().equals(name.toLowerCase())) {
							found_position = initial_size - queue.size();
							break;
						}
						list.add(takenFruit);
						takenFruit = queue.take();
					}
					if (found_position > -1)
						System.out.println("Fruit Consumed at position " + found_position);
					else
						System.out.println("Fruit not found you have to wait");

					while (!list.isEmpty()) {
						queue.put(list.get(list.size() - 1));
						list.remove(list.size() - 1);
					}
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//}
}
