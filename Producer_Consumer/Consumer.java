package com.accolite.Assignment1;

import java.util.Scanner;

public class Consumer implements Runnable{
	Fruits fruits ;
	public Consumer(Fruits fruits) {
		this.fruits= fruits;
		// TODO Auto-generated constructor stub
	}
	public void run(){
		try{
			int count = 0;
			int[] buy = {0,0,0,0};
			boolean flag = true;
			Scanner scanner = new Scanner(System.in);
			
			while(flag){
				System.out.println("Please enter apples count");
				count = scanner.nextInt();
				if(( fruits.size(1) - count) < 0 ){
					System.out.println("cannot buy those many fruits please enter less number"+fruits.size(1));
				}
				else{
					buy[0] = count;
					flag = false;
				}
			}
			
			flag = true;
			while(flag){
				System.out.println("Please enter oranges count");
				count = scanner.nextInt();
				if(( fruits.size(2) - count) < 0){
					System.out.println("cannot buy those many fruits please enter less number");
				}
				else{
					buy[1] = count;
					flag = false;
				}
			}
			
			flag = true;
			while(flag){
				System.out.println("Please enter grapes count");
				count = scanner.nextInt();
				if(( fruits.size(3) - count) < 0){
					System.out.println("cannot buy those many fruits please enter less number");
				}
				else{
					buy[2] = count;
					flag = false;
				}
			}
			
			flag = true;
			while(flag){
				System.out.println("Please enter watermelon count");
				count = scanner.nextInt();
				if((fruits.size(4) - count) < 0){
					System.out.println("cannot buy those many fruits please enter less number of "+fruits.size(1));
				}
				else{
					buy[3] = count;
					flag = false;
				}
			}
			
			fruits.removeFruits(buy[0], buy[1], buy[2], buy[3]);
			fruits.print();
			
		}
		catch(Exception e){
			
		}
	}
}
