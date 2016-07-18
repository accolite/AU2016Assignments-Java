package com.accolite.au.assignment6;

import java.util.Scanner;

public class Market {
	public static void main(String[] args) {
		Fruits fruits = new Fruits();
		Scanner scan = new Scanner(System.in);
		// Taking inputs
		System.out.println("Enter number of farmers");
		int farmers = scan.nextInt();
		System.out.println("Enter number of consumers");
		int comsumers = scan.nextInt();
		// for farmer threads
		for (int i = 0; i < farmers; i++) {
			new Farmer(fruits).start();
		}
		// for consumer threads
		for (int i = 0; i < comsumers; i++) {
			new Consumer(fruits).start();
		}
	}
}
