package FruitMarket;

import FruitMarket.Fruits;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Farmer implements Runnable {

	Farmer() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hey " + Thread.currentThread().getName());
		System.out.println("enter the choice of fruit");
		System.out.println("enter choice 1.apple 2.orange 3. banana 4.watermelon ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		int number;
		try {

			switch (choice) {
			case 1:
				System.out.println("enter the number of apples");
				number = sc.nextInt();
				if (Fruits.apple.remainingCapacity() >= Fruits.apple.size() + number) {
					for (int i = 0; i < number; i++)
						Fruits.apple.put("producer " + Thread.currentThread().getName());
					System.out.println(Fruits.apple.size());
					break;
				} else {
					System.out.println("array size limit exceeded");
					Thread.currentThread().stop();
				}

				break;
			case 2:
				System.out.println("enter the number of orange");
				number = sc.nextInt();
				if (Fruits.orange.remainingCapacity() >= Fruits.orange.size() + number) {
					for (int i = 0; i < number; i++)
						Fruits.orange.put("producer " + Thread.currentThread().getName());

				} else {
					System.out.println("array size limit exceeded");
					Thread.currentThread().stop();
				}

				break;
			case 3:
				System.out.println("enter the number of banana");
				number = sc.nextInt();
				if (Fruits.banana.remainingCapacity() >= Fruits.banana.size() + number) {
					for (int i = 0; i < number; i++)
						Fruits.banana.put("producer " + Thread.currentThread().getName());
				} else {
					System.out.println("array size limit exceeded");
					Thread.currentThread().stop();
				}

				break;
			case 4:
				System.out.println("enter the number of water melon");
				number = sc.nextInt();
				if (Fruits.watermelon.remainingCapacity() >= Fruits.watermelon.size() + number) {
					for (int i = 0; i < number; i++)
						Fruits.watermelon.put("producer " + Thread.currentThread().getName());
				} else {
					System.out.println("array size limit exceeded");
					Thread.currentThread().stop();
				}

				break;
			default:
				break;
			}

		}

		catch (Exception e) {

		}
	}
}
