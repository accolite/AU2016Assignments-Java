package FruitMarket;

import java.util.Scanner;

public class Customer implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hey " + Thread.currentThread().getName());
		System.out.println("enter the choice of fruit to buy");
		System.out.println("enter choice 1.apple 2.orange 3. banana 4.watermelon ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		try {

			switch (choice) {
			case 1:
				System.out.println(Fruits.apple.size());
				System.out.println("enter the number of apples to buy");
				int number = sc.nextInt();

				for (int i = 0; i < number; i++) {
					Fruits.apple.take();
					System.out.println("apples taken by " + Thread.currentThread().getName() + i);
				}

				break;
			case 2:
				System.out.println(Fruits.orange.size());
				System.out.println("enter the number of orange to buy");
				int number1 = sc.nextInt();
				

				for (int i = 0; i < number1; i++) {
					Fruits.orange.take();
					System.out.println("orange taken by " + Thread.currentThread().getName() + i);
				}
				break;
			case 3:
				System.out.println(Fruits.banana.size());
				System.out.println("enter the number of banana to buy");
				number = sc.nextInt();

				for (int i = 0; i < number; i++) {
					Fruits.banana.take();
					System.out.println("banana taken by " + Thread.currentThread().getName() + i);
				}
				break;
			case 4:
				System.out.println(Fruits.watermelon.size());
				System.out.println("enter the number of watermelon to buy");
				number = sc.nextInt();

				for (int i = 0; i < number; i++) {
					Fruits.watermelon.take();
					System.out.println("watermelon taken by " + Thread.currentThread().getName() + i);
				}
				break;

			}
		} catch (Exception e) {

		}
	}
}
