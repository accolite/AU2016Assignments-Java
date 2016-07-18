package com.accolite.Assignment1;

import java.io.BufferedReader;
import java.util.Scanner;

import com.accolite.threadintroduction.MyThread;

public class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Fruits fruits = new Fruits();
		try{
			Scanner scanner = new Scanner(System.in);
			while(true){
				System.out.println("select an option \n1. Producer \n2. Consumer");
				switch (scanner.nextInt()) {
				case 1:
					Runnable producer = new Producer(fruits);
					Thread farmer = new Thread(producer,"farmer");
					farmer.start();
					farmer.join();
					break;
				case 2:
					Runnable consumer = new Consumer(fruits);
					Thread buyer = new Thread(consumer,"Buyer");
					buyer.start();
					buyer.join();
					break;
				default:
					System.out.println("Please enter correct option");
					break;
				}
			}
		}
		catch(Exception e){
			
		}
	}
	public static void main(String[] args) {
		Runnable demo = new Demo();
		Thread t1 = new Thread(demo,"demo");
		try{
			t1.start();
		
		}
		catch(Exception e){
			
		}
	}
}
