package Assignment;

import java.util.concurrent.BlockingQueue;

public class Thread2 implements Runnable {

	protected BlockingQueue<Boolean> apple = null;
	protected BlockingQueue<Boolean> orange = null;
	protected BlockingQueue<Boolean> grape = null;
	protected BlockingQueue<Boolean> waterMelon = null;

	public Thread2(BlockingQueue<Boolean> a, BlockingQueue<Boolean> o, BlockingQueue<Boolean> g, BlockingQueue<Boolean> w) {
		this.apple = a;
		this.orange = o;
		this.grape = g;
		this.waterMelon = w;
	}

	public synchronized void farmer(String fruit) {
		
		// if added fruit is apple
		if(fruit.equalsIgnoreCase("apple")) {
			if (apple.remainingCapacity() == 0) {
				System.out.println("We can not accept more fruites at the moment !!");
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interruption");
				}
			}
			apple.add(true);
			System.out.printf("fruit : %s is added !!!%n", fruit);
		}
		
		//if added fruit is orange
		else if(fruit.equalsIgnoreCase("orange")) {
			if (apple.remainingCapacity() == 0) {
				System.out.println("We can not accept more fruites at the moment !!");
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interruption");
				}
			}
			orange.add(true);
			System.out.printf("fruit : %s is added !!!%n", fruit);
		}
		
		//if added fruit is grape
		else if(fruit.equalsIgnoreCase("grape")) {
			if (apple.remainingCapacity() == 0) {
				System.out.println("We can not accept more fruites at the moment !!");
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interruption");
				}
			}
			grape.add(true);
			System.out.printf("fruit : %s is added !!!%n", fruit);
		}
		
		//if added fruit is water melon
		else if(fruit.equalsIgnoreCase("waterMelon")) {
			if (apple.remainingCapacity() == 0) {
				System.out.println("We can not accept more fruites at the moment !!");
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interruption");
				}
			}
			waterMelon.add(true);
			System.out.printf("fruit : %s is added !!!%n", fruit);
		}
		
		else {
			System.out.println("Invalid fruit\n\n");
		}
	}
	
	public void run() {
			
			try {
				Thread.sleep(100);
				farmer("apple");
				farmer("orange");
				farmer("grape");
				farmer("waterMelon");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}
