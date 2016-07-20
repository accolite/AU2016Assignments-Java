package com.accolite.RestaurantApplication;

import java.util.Scanner;

public class Demo {
	float avg_bill_so_far ;
	public static void main(String... strings) {
		Demo demo = new Demo();
		demo.startThread();
	}
	
	public  void startThread() {
		// TODO Auto-generated method stub
		TableBill t;
		while (true) {
			System.out.println("Pay or know average bill so far? 1 or 2");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if (choice == 1) {
				System.out.println("Enter bill");
				float bill = in.nextFloat();
				t = new TableBill();
				t.setBill(bill);
				t.demo = this;
				t.start();
			}
			else if(choice == 2)
			{
				System.out.println("Avg bill so far is "+avg_bill_so_far);
			}
			
			else {
				System.exit(0);
			}
		}
	}

	public void printAverageOfBills(float avg_bill){
		avg_bill_so_far = avg_bill;
	}
}
