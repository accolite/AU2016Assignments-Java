package Assignment;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Assignment2 {
	
	public static void main(String[] args) {
	
		BlockingQueue<Boolean> apple = new ArrayBlockingQueue<Boolean>(10);
	    BlockingQueue<Boolean> orange = new ArrayBlockingQueue<Boolean>(10);
	    BlockingQueue<Boolean> grape = new ArrayBlockingQueue<Boolean>(10);
	    BlockingQueue<Boolean> waterMelon = new ArrayBlockingQueue<Boolean>(10);

	    Thread2 farmer = new Thread2(apple, orange, grape, waterMelon);
	    Thread1 customer = new Thread1(apple, orange, grape, waterMelon);
	    
	    Thread t1 = new Thread(farmer);
	    Thread t2 = new Thread(customer);
	    
	    t1.setPriority(10);
	    t2.setPriority(4);
	    
        t1.start();
        
        /*try {
        	t1.join();
        }
        catch(Exception e) {}*/
        t2.start();

	    
		
	}
}
