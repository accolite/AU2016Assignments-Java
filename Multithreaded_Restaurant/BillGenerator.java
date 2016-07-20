package Multithread_Restaurant;

import java.util.concurrent.ThreadLocalRandom;

public class BillGenerator extends Thread {
	
	private static int count;
	
	BillGenerator() {
		count = 0;
	}

	public synchronized double generateBill() {
		try{
			wait(ThreadLocalRandom.current().nextInt(1000, 5000));
		}
		catch(Exception e) {}
		
		count++;
		return (ThreadLocalRandom.current().nextDouble(100, 1000));
	}
	
	public static synchronized int getCount() {
		return count;
	}
	
	@Override
	public void run() {
		
	}
}
