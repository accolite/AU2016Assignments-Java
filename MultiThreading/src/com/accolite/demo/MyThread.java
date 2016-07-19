package com.accolite.demo;

import java.util.Scanner;

public class MyThread implements Runnable{
	
	int cap;
	int apple;
	int orange;
	int grape;
	int watermalon;
	int curr_capacty;
	
	public MyThread(int cap) {
		// TODO Auto-generated constructor stub
		this.curr_capacty=0;
		this.cap=cap;
		this.apple=0;
		this.orange=0;
		this.watermalon=0;
		this.grape=0;
	}
	public void run() {
		
		if(Thread.currentThread().getName().equals("producer")){
			System.out.println("enter the fruit you want to enter 1.Apple 2.Orange 3.Grape 4. Watermalon");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			int a;
			switch(choice)
			{
			case 1:
				System.out.println("enter the no of apple u want to add");
				 a=sc.nextInt();
				 if(a+this.curr_capacty>this.cap)
					 System.out.println("Can't Produce");
				 else 
				 {
					 curr_capacty+=a;
					 apple+=a;
				 }
				 break;
			
			case 2:
				System.out.println("enter the no of orange u want to add");
				 a=sc.nextInt();
				 if(a+this.curr_capacty>this.cap)
					 System.out.println("Can't Produce");
				 else 
				 {
					 curr_capacty+=a;
					 orange+=a;
				 }
				 break;
			
			
			
			case 3:
				System.out.println("enter the no of grape u want to add");
				 a=sc.nextInt();
				 if(a+this.curr_capacty>this.cap)
					 System.out.println("Can't Produce");
				 else 
				 {
					 curr_capacty+=a;
					 grape+=a;
				 }
				break;
			
				
			case 4:
				System.out.println("enter the no of watermalon u want to add");
				 a=sc.nextInt();
				 if(a+this.curr_capacty>this.cap)
					 System.out.println("Can't Produce");
				 else 
				 {
					 curr_capacty+=a;
					 watermalon+=a;
				 }
				break;
			
			default:
				System.out.println("invalid choice");
				break;
			
			
		}
		}
		else 
		{
				System.out.println("enter the fruit you want to consume 1.Apple 2.Orange 3.Grape 4. Watermalon");
				Scanner sc=new Scanner(System.in);
				int choice=sc.nextInt();
				int a;
				switch(choice)
				{
				case 1:
					System.out.println("enter the no. of apple u want to consume");
					 a=sc.nextInt();
					 if(apple<a)
						 System.out.println("Can't Consume");
					 else 
					 {
						 curr_capacty-=a;
						 apple-=a;
					 }
					 break;
				
				case 2:
					System.out.println("enter the no of orange u want to consume");
					 a=sc.nextInt();
					 if(orange<a)
						 System.out.println("Can't Consume");
					 else 
					 {
						 curr_capacty-=a;
						 orange-=a;
					 }
					 break;
				
				
				
				case 3:
					System.out.println("enter the no of grape u want to consume");
					 a=sc.nextInt();
					 if(grape<a)
						 System.out.println("Can't Consume");
					 else 
					 {
						 curr_capacty-=a;
						 grape-=a;
					 }
					break;
				
					
				case 4:
					System.out.println("enter the no of watermalon u want to consume");
					 a=sc.nextInt();
					 if(watermalon<a)
						 System.out.println("Can't Consume");
					 else 
					 {
						 curr_capacty-=a;
						 watermalon-=a;
					 }
					break;
				
				default:
					System.out.println("invalid choice");
					break;
				
				
			}
			
		}
	}
	
	}
		