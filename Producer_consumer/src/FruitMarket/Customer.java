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
				while (true) {
					if (Fruits.apple.size() >= number) {
						for (int i = 0; i < number; i++)
							Fruits.apple.take();
						System.out.println("apples taken by " + Thread.currentThread().getName());
						
						break;
					} else {
						number = number - Fruits.apple.size();
						for (int i = 0; i < Fruits.apple.size(); i++)
							Fruits.apple.take();

						System.out.println("there are less/no number of apples please wait "+  Thread.currentThread().getName());
						Thread.currentThread().sleep(5000);
					}
				}

				break;
			case 2:
				System.out.println(Fruits.orange.size());
				System.out.println("enter the number of orange to buy");
				int number1 = sc.nextInt();
				while (true) {
					if (Fruits.orange.size() >= number1) {
						for (int i = 0; i < number1; i++)
							Fruits.orange.take();
						System.out.println("orange taken by " + Thread.currentThread().getName());
						Thread.currentThread().stop();
						break;
					} else {
						number1 = number1 - Fruits.orange.size();
						for (int i = 0; i < Fruits.orange.size(); i++)
							Fruits.orange.take();

						System.out.println("there are less/no number of orange please wait "+  Thread.currentThread().getName());
						Thread.currentThread().sleep(5000);
					}
				}
				break;
			case 3:
				System.out.println(Fruits.banana.size());
				System.out.println("enter the number of banana to buy");
				number = sc.nextInt();
				while (true) {
					if (Fruits.banana.size() >= number) {
						for (int i = 0; i < number; i++)
							Fruits.banana.take();
						System.out.println("banana taken by " + Thread.currentThread().getName());
						break;
					} else {
						number = number - Fruits.banana.size();
						for (int i = 0; i < Fruits.banana.size(); i++)
							Fruits.banana.take();

						System.out.println("there are less/no number of banana please wait"+  Thread.currentThread().getName());
						Thread.currentThread().sleep(5000);
					}
				}
				break;
			case 4:
				System.out.println(Fruits.watermelon.size());
				System.out.println("enter the number of watermelon to buy");
				number = sc.nextInt();
				while (true) {
					if (Fruits.watermelon.size() >= number) {
						for (int i = 0; i < number; i++)
							Fruits.watermelon.take();
						System.out.println("watermelon taken by " + Thread.currentThread().getName());
						break;
					} else {
						number = number - Fruits.watermelon.size();
						for (int i = 0; i < Fruits.watermelon.size(); i++)
							Fruits.watermelon.take();

						System.out.println("there are less/no number of watermelon please wait "+  Thread.currentThread().getName() );
						Thread.currentThread().sleep(5000);
					}
				}
				break;

			}
		} catch (Exception e) {

		}
	}
}
