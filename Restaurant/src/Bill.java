import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Bill implements Runnable{
	  ArrayBlockingQueue qu; 
		
		public Bill(ArrayBlockingQueue qu) {
			this.qu = qu;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			char c = 'y';
			while (c == 'y') {			
			try {
				System.out.println("enter the amount of bill :");
				int amt= sc.nextInt();
				qu.put(amt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("you want to add more y/n");
			c = sc.next().charAt(0);
		}
}
}