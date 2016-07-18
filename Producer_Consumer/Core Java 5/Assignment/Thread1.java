package Assignment;

import java.util.concurrent.BlockingQueue;

public class Thread1 implements Runnable {

	protected BlockingQueue<Boolean> apple = null;
	protected BlockingQueue<Boolean> orange = null;
	protected BlockingQueue<Boolean> grape = null;
	protected BlockingQueue<Boolean> waterMelon = null;

	public Thread1(BlockingQueue<Boolean> a, BlockingQueue<Boolean> o, BlockingQueue<Boolean> g, BlockingQueue<Boolean> w) {
		this.apple = a;
		this.orange = o;
		this.grape = g;
		this.waterMelon = w;
	}
	
	public synchronized void consumer(int a, int o, int g, int w) {
		if (apple.isEmpty() && a > 0) {
			System.out.println("we don't have any apples yet");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				System.out.println("interruption occure !!!");
			}
		}
		
		if (orange.isEmpty() && o > 0) {
			System.out.println("we don't have any oranges yet");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				System.out.println("interruption occure !!!");
			}
		}
		
		if (grape.isEmpty() && g > 0) {
			System.out.println("we don't have any grapes yet");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				System.out.println("interruption occure !!!");
			}
		}
		
		if (waterMelon.isEmpty() && a > 0) {
			System.out.println("we don't have any water melon yet");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				System.out.println("interruption occure !!!");
			}
		}
		
		System.out.println("in consumer");
		int i  = consume(a, o, g, w);
		if(i == 1) System.out.println("success");
	}
	
	
	public synchronized int consume(int a, int o, int g, int w) {

		int i;
		
		System.out.println("in consume");
		//buy apple
		if(a <= apple.size()) {
			for(i = a; i > 0; i--) {
				try {
					apple.take();
				}
				catch(Exception e) {}
			}
		}
		else {
			return -1;
		}
		
		//buy oranges
		if(o <= orange.size()) {
			for(i = o; i > 0; i--) {
				try {
					orange.take();
				}
				catch(Exception e) {}
			}
		}
		else {
			return -2;
		}
		
		//buy grapes
		if(g <= grape.size()) {
			for(i = g; i > 0; i--) {
				try {
					grape.take();
				}
				catch(Exception e) {}
			}
		}
		else {
			return -3;
		}
		
		//buy water melon
		if(w <= waterMelon.size()) {
			for(i = a; i > 0; i--) {
				try {
					waterMelon.take();
				}
				catch(Exception e) {}
			}
		}
		else {
			return -4;
		}
		
		return 1;		
	}
	
	public void run() {
		consumer(1,1,1,1);
	}
	
}
