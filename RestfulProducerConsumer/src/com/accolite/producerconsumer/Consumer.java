	package com.accolite.producerconsumer;

import java.util.Scanner;
public class Consumer implements Runnable{
	Fruits fruits ;
	private int qty1;
	private int qty2;
	private int qty3;
	private int qty4;
	public Consumer(Fruits fruits,int qty1,int qty2,int qty3,int qty4) {
		this.fruits = fruits;
		this.qty1 = qty1;
		this.qty2 = qty2;
		this.qty3 = qty3;
		this.qty4 = qty4;
		// TODO Auto-generated constructor stub
	}
	public void run(){
		try{
			int count = 0;
			int[] buy = {0,0,0,0};
			boolean flag = true;
			//Scanner scanner = new Scanner(System.in);
			
			while(flag){
				//System.out.println("Please enter apples count");
				//count = scanner.nextInt();
				if(( fruits.size(1) - qty1) < 0 ){
					System.out.println("cannot buy those many fruits please enter less number"+fruits.size(1));
				}
				else{
					buy[0] = qty1;
					flag = false;
				}
			}
			
			flag = true;
			while(flag){
				if(( fruits.size(2) - qty2) < 0){
					System.out.println("cannot buy those many fruits please enter less number");
				}
				else{
					buy[1] = qty2;
					flag = false;
				}
			}
			
			flag = true;
			while(flag){
				
				if(( fruits.size(3) - qty3) < 0){
					System.out.println("cannot buy those many fruits please enter less number");
				}
				else{
					buy[2] = qty3;
					flag = false;
				}
			}
			
			flag = true;
			while(flag){
				
				if((fruits.size(4) - qty4) < 0){
					System.out.println("cannot buy those many fruits please enter less number of "+fruits.size(1));
				}
				else{
					buy[3] = qty4;
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