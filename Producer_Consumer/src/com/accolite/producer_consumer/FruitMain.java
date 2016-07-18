package com.accolite.producer_consumer;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FruitMain {

	public static int rm() {
		Random rn = new Random();
		int n = 5;
		int i = rn.nextInt() % n;
		return i + 1;
	}

	public static void main(String args[]) {
		BlockingQueue Apple = new ArrayBlockingQueue(5);
		BlockingQueue Orange = new ArrayBlockingQueue(5);
		BlockingQueue Grape = new ArrayBlockingQueue(5);
		BlockingQueue Watermelon = new ArrayBlockingQueue(5);

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("1.producer\n2.Consumer");
			int n = scanner.nextInt();
			if (n == 1) {
				Producer producer = new Producer(Apple, Orange, Grape, Watermelon);
				Thread thread_producer = new Thread();
				thread_producer.setName("producer");
				thread_producer.start();
			} else {
				int apple, orange, grape, watermelon;
				Consumer consumer = new Consumer(Apple, Orange, Grape, Watermelon);
				Thread thread_consumer = new Thread();
				thread_consumer.setName("consumer");
				thread_consumer.start();
			}
		}
	}
}
