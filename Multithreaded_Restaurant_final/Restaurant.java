package Multithread_Restaurant;

import java.util.Scanner;

public class Restaurant {
	
	public static void main(String args[]) {
		BillGenerator gen = new BillGenerator();
		BillCalculater cal = new BillCalculater();
		AvgCalculater avg = new AvgCalculater();
		
		double r, o;
		
		System.out.println("1. wait for customer\t2. close the restaurant");
		
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		int i = 0;
		
		while(true) {
			if(choice == 1) {
				if(i == 0) {
					gen.start();
					cal.start();
					i++;
					//avg.start();
				}
				else {
					gen.run();
					cal.run();
				}
			
			}
			else {
				System.out.println("done for the day!\ntoday's business: " + BillGenerator.getCount() + " bills");
				break;
			}	
			System.out.println("\n\n1. wait for customer\t2. close the restaurant");
			choice = s.nextInt();
		}
		
		s.close();
		
	}
	
}
