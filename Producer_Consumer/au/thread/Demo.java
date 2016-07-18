package com.au.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;

public class Demo {
	public static void main(String args[]){
		BlockingQueue Apple = new ArrayBlockingQueue<>(10);
		BlockingQueue Orange = new ArrayBlockingQueue<>(10);
		BlockingQueue Grape = new ArrayBlockingQueue<>(10);
		BlockingQueue Watermelon = new ArrayBlockingQueue<>(10);
		int fruit[] = new int[4];
		Farmers farmer = new Farmers(Apple,Orange,Grape,Watermelon);
		Buyers  buyer= new Buyers(Apple,Orange,Grape,Watermelon);
		//Thread fThread = new Thread(farmer);
		//Thread bThread = new Thread(buyer);
		while(true){
		Scanner input = new Scanner(System.in);
		System.out.println("Input choice from Farmer and Buyer 1-Farmer, 2-Buyer");
		int choice = input.nextInt();
		int Acount=0,Ocount=0,Gcount=0,Wcount=0;
		if(choice==1){
			System.out.println("Enter values of fruit produced Apple,Orange,Grapes,Watermelon ");
			fruit[0] = input.nextInt();
			fruit[1] = input.nextInt();
			fruit[2] = input.nextInt();
			fruit[3] = input.nextInt();
			farmer.getFruits(fruit);
			 new  Thread(farmer).start();
			 
		}
		else{
			System.out.println("Enter values of fruit consumed Apple,Orange,Grapes,Watermelon ");
			fruit[0] = input.nextInt();
			fruit[1] = input.nextInt();
			fruit[2] = input.nextInt();
			fruit[3] = input.nextInt();
			
			buyer.getFruits(fruit);
			new Thread(buyer).start();
		}
		}
	}
}
