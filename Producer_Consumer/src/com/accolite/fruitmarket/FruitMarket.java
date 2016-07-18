package com.accolite.fruitmarket;

import java.util.Scanner;

public class FruitMarket {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
			int noOfFarmers = 0;
			int noOfConsumers = 0;
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter no. of Farmers:");
			noOfFarmers=scanner.nextInt();
			System.out.println("Enter no. of Consumers:");
			noOfConsumers=scanner.nextInt();
		
			Market market = new Market();
			
			for (int i = 0; i < noOfFarmers; i++) {
				new Farmer (market).start();
			}

			for (int i = 0; i < noOfConsumers; i++) {
				new Consumer (market).start();
			}
			scanner.close();
	}

}
