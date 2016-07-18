import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Market market = new Market();

		Thread t1 = null;
		Thread t2 = null;
		
		Scanner in = new Scanner(System.in);
				
		while(true){
			System.out.println("1. Farmer\n2. Customer\n3. Exit");
			int choice = in.nextInt();
			if(choice == 1){
				t1 = new Thread(new Farmer(market));
				t1.start();
				t1.join();
			} else if (choice == 2) {
				t2 = new Thread(new Customer(market));
				t2.start();
				t2.join();
			} else {
				return;
			}
		}
	}
}
