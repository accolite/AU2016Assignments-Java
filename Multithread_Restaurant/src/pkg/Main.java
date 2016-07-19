package pkg;

	import java.util.Scanner;
	import java.util.concurrent.ArrayBlockingQueue;
	import java.util.concurrent.BlockingQueue;


	public class Main {
		public static void main(String args[]) throws InterruptedException
		{

			 BlockingQueue input = new ArrayBlockingQueue(1);
			 Scanner sc = new Scanner(System.in);
			 String s ;
			 int i;
				Average p = new Average(input);
				Output q = new Output(input);

				while (true) {
					System.out.println("Enter the bill");
					i=sc.nextInt();
					p.meth(i);
					Thread t1 = new Thread(p);
					t1.start();
					Thread t2 = new Thread(q);
					t2.start();
					
				}

		}

}
