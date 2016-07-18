import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	public static void main(String[] args) {

		BlockingQueue aqueue = new ArrayBlockingQueue(10);
		BlockingQueue oqueue = new ArrayBlockingQueue(10);
		BlockingQueue wqueue = new ArrayBlockingQueue(10);
		BlockingQueue gqueue = new ArrayBlockingQueue(10);

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
				
				Farmer producer = new Farmer(aqueue, oqueue, wqueue, gqueue, app, ora, melon, gra);
				Thread t1 = new Thread(producer, "producer");
				t1.start();
				
			} else {
				System.out.println("enter no of apples,oranges,melons,grapes to consumer");
				app = sc.nextInt();
				ora = sc.nextInt();
				melon = sc.nextInt();
				gra = sc.nextInt();
				
				Customer consumer = new Customer(aqueue, oqueue, wqueue, gqueue, app, ora, melon, gra);
				Thread t2 = new Thread(consumer, "consumer");
				t2.start();
			}

		}

	}

}
