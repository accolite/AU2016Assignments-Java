package farmerConsumers;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
	public static void main(String[] args) {
		 BlockingQueue apple = new ArrayBlockingQueue(50);
		 BlockingQueue orange = new ArrayBlockingQueue(50);
		 BlockingQueue grapes = new ArrayBlockingQueue(50);
		 BlockingQueue watermelon = new ArrayBlockingQueue(50);
		// BlockingQueue farmers = new ArrayBlockingQueue(10);
		 	//BlockingQueue apple;
			Farmer producer = new Farmer(apple,orange,grapes,watermelon);
	        Consumer consumer = new Consumer(apple,orange,grapes,watermelon);
	        Thread t1=new Thread(producer);
	        
	        Thread t2=new Thread(consumer);
	        
	        Scanner in = new Scanner(System.in);
	        System.out.println("Eneter 1 to produce and 2 to consume 3 to exit");
	        int choice = in.nextInt();
	        while(choice!=3)
	        {	switch(choice)
	        	{	case 1:	t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        				break;
	        	case 2:	 t2.start(); 
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        			break;
	        
	        	}
	        
	        System.out.println("Eneter 1 to produce and 2 to consume 3 to exit");
	        choice = in.nextInt();
	        	
	        }
	        
	      
	        
	}
	

}
