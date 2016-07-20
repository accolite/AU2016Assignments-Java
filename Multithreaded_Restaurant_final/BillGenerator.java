package Multithread_Restaurant;

import java.util.concurrent.ThreadLocalRandom;

public class BillGenerator extends Thread {
	
	private static int count;
	private static double bill;
	
	BillGenerator() {
		count = 0;
	}

	public static synchronized int getCount() {
		return count;
	}
	
	public static synchronized double getBill() {
		return bill;
	}
	
	@Override
	public void run() {
		//while(true) {
		System.out.println("bill generated");
			try {
				count++;
				bill = ThreadLocalRandom.current().nextDouble(100, 1000);
				System.out.println("Bill : "+ bill);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
	}
}
