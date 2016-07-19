package FruitMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class Market {
	static int p = 0;
	static int c = 0;
	static ArrayList<Thread>Consumer=new ArrayList<>();
	 static ArrayList<Thread> Producer=new ArrayList<>();
	 
	public Market() {

		// TODO Auto-generated constructor stub

}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello welcome to fruit market");
		System.out.println("enter who u are? 1.producer 2.consumer 3. quit ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		while (choice != 3&&(p<3||c<3)) {
			switch (choice) {
			case 1:
				
				System.out.println("you are creating a producer");
				Thread newProducer=new Thread(new Farmer());
				newProducer.setName("Farmer"+p);
				Producer.add(newProducer);
				Producer.get(p).start();
				try {
					Producer.get(p).sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p++;
				
				break;
			case 2:
				System.out.println("you are creating a consumer");
				Thread newConsumer=new Thread(new Customer());
				newConsumer.setName("Consumer"+c);
				Consumer.add(newConsumer);
				Consumer.get(c).start();
				try {
					Consumer.get(c).sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				c++;
				break;
			default:
				break;
			}
			System.out.println("enter who u are? 1.producer 2.consumer 3. quit ");
			choice=sc.nextInt();
		}

	}

}
