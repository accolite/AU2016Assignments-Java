package com.accolite.au.assignment6;

import java.util.Random;

public class Farmer extends Thread {
	private Fruits fruits;

	public Farmer(Fruits fruits) {
		this.fruits = fruits;
	}

	public void run() {
		while (true) {
			System.out.println("Farmer is ready to supply fruits to market");
			Random randomValue = new Random();
			try {
				Thread.sleep(5000);
				int type = randomValue.nextInt(4);
				switch (type) {
				case 0:
					fruits.producerApple(new Apple());
					System.out.println("Apple is consumed");
					break;
				case 1:
					fruits.producerOrange(new Orange());
					System.out.println("Orange is consumed");
					break;
				case 2:
					fruits.producerGrape(new Grape());
					;
					System.out.println("Grape is consumed");
					break;
				default:
					fruits.producerWatermelon(new Watermelon());
					System.out.println("Watermelon is  consumed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
