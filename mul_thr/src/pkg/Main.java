package pkg;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {
	public static void main(String args[])
	{
		 BlockingQueue apple = new ArrayBlockingQueue(10);
		 BlockingQueue orange = new ArrayBlockingQueue(10);
		 BlockingQueue grape = new ArrayBlockingQueue(10);
		 BlockingQueue watermelon = new ArrayBlockingQueue(10);
		 Scanner sc = new Scanner(System.in);
			int app;
			int ora;
			int melon;
			int gra;

			while (true) {
				System.out.println("1 for producer and 2 for consumer");
				int ch = sc.nextInt();
				
				if (ch == 1) {
					System.out.println("enter no of apples,oranges,melons,grapes to produce");
					app = sc.nextInt();
					ora = sc.nextInt();
					melon = sc.nextInt();
					gra = sc.nextInt();
					
					Producer p = new Producer(apple, orange, watermelon, grape, app, ora, melon, gra);
					Thread t1 = new Thread(p, "producer");
					t1.start();
					
				} else {
					System.out.println("enter no of apples,oranges,melons,grapes to consumer");
					app = sc.nextInt();
					ora = sc.nextInt();
					melon = sc.nextInt();
					gra = sc.nextInt();
					
					Consumer c = new Consumer(apple, orange, watermelon, grape, app, ora, melon, gra);
					Thread t2 = new Thread(c, "consumer");
					t2.start();
				}

			}



	}

}
