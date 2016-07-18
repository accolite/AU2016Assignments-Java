/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.MultiThreading;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Market.
 */
public class Market {

	/** Using Concurrent Packages */
	BlockingQueue apple,orange,grape,watermelon;
	
	/** The Customer name and Farmer name. */
	String farmer_name,customer_name;
	
	/** The variables to get fruits */
	int var_apple,var_orange,var_grape,var_watermelon;
	
	/** The farmer. */
	Producer farmer;
	
	/** The customer. */
	Consumer customer;
	
	/**
	 * Instantiates a new market.
	 */
	public Market() {
		super();
		apple = new ArrayBlockingQueue(5);
		orange = new ArrayBlockingQueue(5);
		grape = new ArrayBlockingQueue(5);
		watermelon = new ArrayBlockingQueue(5);
	}
	
	/**
	 * Creates the farmer and starts the thread.
	 */
	public void createFarmer(){
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Your Name");
		farmer_name=sc1.nextLine();
		System.out.println("Enter No of Apples to Sell:");
		var_apple=sc1.nextInt();
		System.out.println("Enter No of Grapes to Sell:");
		var_grape=sc1.nextInt();
		System.out.println("Enter No of Orange to Sell:");
		var_orange=sc1.nextInt();
		System.out.println("Enter No of Watermelon to Sell:");
		var_watermelon=sc1.nextInt();
		farmer=new Producer(apple,orange,grape,watermelon,var_apple,var_orange,var_grape,var_watermelon);
		Thread t1=new Thread(farmer,farmer_name);
		t1.start();
	}

	/**
	 * Creates the consumer and starts the thread.
	 */
	public void createConsumer(){
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Your Name");
		customer_name=sc1.nextLine();
		System.out.println("Enter No of Apples to Buy:");
		var_apple=sc1.nextInt();
		System.out.println("Enter No of Grapes to Buy:");
		var_grape=sc1.nextInt();
		System.out.println("Enter No of Orange to Buy:");
		var_orange=sc1.nextInt();
		System.out.println("Enter No of Watermelon to Buy:");
		var_watermelon=sc1.nextInt();
		customer=new Consumer(apple,orange,grape,watermelon,var_apple,var_orange,var_grape,var_watermelon);
		Thread t1=new Thread(customer,customer_name);
		t1.start();
	
	}
	
	/**
	 * The main method to enter the market.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		
		Market market=new Market();
		Scanner sc=new Scanner(System.in);
		int choice;
		boolean flag=true;
		
		System.out.println("Welcome to the Market\n--------------------------------------------\n");
		while(flag==true){
			System.out.println("1.Producer\t2.Consumer\nEnter your choice:");
			choice=sc.nextInt();
			switch(choice){
				case 1:{
					market.createFarmer();
					break;
				}
				case 2:{
					market.createConsumer();
					break;
				}
				default:{
					System.out.println("Enter a valid choice:");
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Continue? Yes->true/No->false");
			flag=sc.nextBoolean();
		}
		System.out.println("Thank You\tVisit Again");
		
					
		
		
		
	}

}
