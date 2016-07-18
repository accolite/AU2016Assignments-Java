package com.accolite.threadAssignMent;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
	public static BlockingQueue<Fruit> queue = new ArrayBlockingQueue<Fruit>(15);
	public static void main(String...strings){
		Farmer farmer;
		Customer customer;
		
		Scanner in = new Scanner(System.in);
		//do{
			//System.out.println("farmer or consumer");
			//String c = in.next();
			//if(c.equals("farmer")){
				farmer = new Farmer();
				Thread t = new Thread(farmer);
				t.start();
			//}
			//else{
				customer = new Customer();
				Thread t1 = new Thread(customer);
				t1.start();
			//}			
		//}while((in.next().equals("y")));
	}
}
