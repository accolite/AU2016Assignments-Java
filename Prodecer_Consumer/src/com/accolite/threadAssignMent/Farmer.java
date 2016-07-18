package com.accolite.threadAssignMent;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Farmer implements Runnable{

	
	protected BlockingQueue<Fruit> queue = null;

	public Farmer() {
		this.queue = Demo.queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try {
				System.out.println("insert the name of fruit want to insert");
				Scanner in = new Scanner(System.in);
				String name = in.next();
				Fruit fruit = new Fruit(name.toLowerCase());
				queue.put(fruit);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
