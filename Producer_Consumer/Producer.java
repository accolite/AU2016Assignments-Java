package com.accolite.Assignment1;

import java.util.Scanner;

public class Producer implements Runnable{
	Fruits fruits ;
	public Producer(Fruits fruits) {
		this.fruits = fruits;
		// TODO Auto-generated constructor stub
	}
	public void run(){
		try{
			int count = 0;
			int[] sell = {0,0,0,0};
			boolean flag = true;
			Scanner scanner = new Scanner(System.in);
			
			while(flag){
				System.out.println("Please enter apples count");
				count = scanner.nextInt();
				if((count + fruits.size(1)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					sell[0] = count;
					flag = false;
				}
			}
			
			flag = true;
			
			while(flag){
				System.out.println("Please enter oranges count");
				count = scanner.nextInt();
				if((count + fruits.size(2)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					sell[1] = count;
					flag = false;
				}
			}
			
			flag = true;
			
			while(flag){
				System.out.println("Please enter grapes count");
				count = scanner.nextInt();
				if((count + fruits.size(3)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					sell[2] = count;
					flag = false;
				}
			}
			
			flag = true;
			fruits.print();
			while(flag){
				System.out.println("Please enter watermelon count");
				count = scanner.nextInt();
				if((count + fruits.size(4)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					System.out.println("I'm here in 4th while else");
					sell[3] = count;
					flag = false;
					fruits.addFruits(sell[0], sell[1], sell[2], sell[3]);
					fruits.print();
				}
			}
			
			
			
		}
		catch(Exception e){
			System.out.println("Exception");
			e.printStackTrace();
		}
	}
}
