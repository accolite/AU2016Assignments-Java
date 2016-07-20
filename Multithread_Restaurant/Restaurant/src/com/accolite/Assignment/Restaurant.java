package com.accolite.Assignment;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {

	Bill bill;

	ExecutorService exec = Executors.newCachedThreadPool();

	GenerateTotalBill genrateBill = new GenerateTotalBill(this);
	GenerateAverageBill calculateaverageBill = new GenerateAverageBill(this);
	NotifyOwner notifyowner = new NotifyOwner(this);

	public Restaurant() {
		exec.execute(genrateBill);
		exec.execute(calculateaverageBill);
		exec.execute(notifyowner);
	}

	public static void main(String[] args) {

		new Restaurant();
	}
}
