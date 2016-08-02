package com.accolite.producerconsumer;
import java.util.Scanner;

public class Producer implements Runnable{
	Fruits fruits ;
	private int qty1;
	private int qty2;
	private int qty3;
	private int qty4;
	public Producer(Fruits fruits,int qty1,int qty2,int qty3,int qty4) {
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
			int[] sell = {0,0,0,0};
			boolean flag = true;
			Scanner scanner = new Scanner(System.in);
			
			while(flag){
				//System.out.println("Please enter apples count");
				//count = scanner.nextInt();
				if((qty1 + fruits.size(1)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					sell[0] = qty1;
					flag = false;
				}
			}
			
			flag = true;
			
			while(flag){
				//System.out.println("Please enter oranges count");
				//count = scanner.nextInt();
				if((qty2 + fruits.size(2)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					sell[1] = qty2;
					flag = false;
				}
			}
			
			flag = true;
			
			while(flag){
				//System.out.println("Please enter grapes count");
				//count = scanner.nextInt();
				if((qty3 + fruits.size(3)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					sell[2] = qty3;
					flag = false;
				}
			}
			
			flag = true;
			fruits.print();
			while(flag){
				//System.out.println("Please enter watermelon count");
				//count = scanner.nextInt();
				if((qty4 + fruits.size(4)) > 5){
					System.out.println("cannot sell those many fruits please enter less number");
				}
				else{
					System.out.println("I'm here in 4th while else");
					sell[3] = qty4;
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