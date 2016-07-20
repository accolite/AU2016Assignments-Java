package multithread_restaurant;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	public static void main(String[] args) {
		BlockingQueue BillQueue = new ArrayBlockingQueue(10);
		BlockingQueue AverageQueue = new ArrayBlockingQueue(10);
		Waiter w= new Waiter(BillQueue);
		Thread t1=new Thread(w);
		t1.start();
		Average_Bill a= new Average_Bill(BillQueue,AverageQueue);
		Thread t2=new Thread(a);
		t2.start();
		Average_Notify n= new Average_Notify(BillQueue,AverageQueue);
		Thread t3=new Thread(n);
		t3.start();
    }
}
