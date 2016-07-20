package restaurant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Restaurant {
	static Scanner sc;
	static int no_of_tables;
	static Thread bill;
	static Thread avg;
	Thread new_avg;
	static Thread avg_output;
	static BlockingQueue<Float> avgvalue;
	static BlockingQueue<Float> avgvalue_display;


	

	public static void main(String atgs[]) {

		sc = new Scanner(System.in);
		System.out.println("hello welcome to restaurant");
		System.out.println(" enter the number of tables");
		no_of_tables = sc.nextInt();
		avgvalue = new ArrayBlockingQueue<>(1);
		avgvalue_display = new ArrayBlockingQueue<>(1);

		AtomicInteger incrementer = new AtomicInteger(0);
		BlockingQueue<Order> order = new ArrayBlockingQueue<>(no_of_tables);
		System.out.println("hey customer want to eat if yes press 'y'else press 'n");
		
		char option = sc.next().charAt(0);
		try {
			avgvalue.put((float) 0);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		while (option != 'n') {
			bill = new Thread(new Billing((ArrayBlockingQueue<Order>) order, incrementer));
			bill.start();
		
			try {
				Thread.currentThread().sleep(2000);
				avg = new Thread(new Avg(order));
				avg.start();
				avg_output=new Thread(new Output_Avg());
				avg_output.start();
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//	System.out.println(order.peek().amount);
			//System.out.println(order.size());


			System.out.println("hey customer want to eat if yes press 'y'else press 'n");
			String s= sc.next();
			if(s.length()!=0)
				option=s.charAt(0);
		}

	}
}