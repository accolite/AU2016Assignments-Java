package com.accolite.fruitMarket;

import java.util.Scanner;

public class RunningClass implements  Runnable{
	int[] empty;
	int capacity;
	int[] full;
	int[] mutex;
	public RunningClass(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		empty=new int[4];
		full=new int[4];
		mutex=new int[4];
		for(int i=0;i<4;i++)
		{
			empty[i]=capacity;
			full[i]=0;
			mutex[i]=1;
		}
	}

	public void run()  {

		Scanner sc=new Scanner(System.in);
		//System.out.println(Thread.currentThread().getName());
		if(Thread.currentThread().getName().equals("Producer"))
		{


			int choice,quant;
			System.out.println("Enter name of fruit you want to prouduce: \n1.Apple\n 2.Orange\n 3.Grape\n 4.WaterMelon");
			choice=sc.nextInt();
			System.out.println("Enter the quantity of fruit to be produced ");
			quant=sc.nextInt();
			System.out.println(quant+" "+choice);
			if(choice>=1&&choice<=4)
			{

				if(choice==1)
				{
					if(empty[choice-1]>=quant)
					{
						empty[choice-1]-=quant;
						System.out.println("Produced " +quant+" Apple");
						full[choice-1]+=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
					}
				}
				else if(choice==2)
				{
					if(empty[choice-1]>=quant)
					{
						empty[choice-1]-=quant;
						System.out.println("Produced " +quant+" Orange");
						full[choice-1]+=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						//Thread.currentThread().wait();

					}
				}
				else if(choice==3)
				{
					if(empty[choice-1]>=quant)
					{
						empty[choice-1]-=quant;
						System.out.println("Produced " +quant+" Grape");
						full[choice-1]+=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						//Thread.currentThread().wait();
					}
				}
				else
				{
					if(empty[choice-1]>=quant)
					{
						empty[choice-1]-=quant;
						System.out.println("Produced " +quant+" Watermelon");
						full[choice-1]+=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						//Thread.currentThread().wait();
					}
				}


			}

		}
		else
		{
			int choice,quant;
			System.out.println("Enter name of fruit you want to consume: \n1.Apple\n 2.Orange\n 3.Grape\n 4.WaterMelon");
			choice=sc.nextInt();
			System.out.println("Enter the quantity of fruit to be consumed ");
			quant=sc.nextInt();
			if(choice>=1&&choice<=4)
			{

				if(choice==1)
				{
					if(full[choice-1]>=quant)
					{
						empty[choice-1]+=quant;
						System.out.println("Consumed " +quant+" Apple");
						full[choice-1]-=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						//Thread.currentThread().wait();
					}
				}
				else if(choice==2)
				{
					if(full[choice-1]>=quant)
					{
						empty[choice-1]+=quant;
						System.out.println("Consumed " +quant+" Orange");
						full[choice-1]-=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						//Thread.currentThread().wait();
					}
				}
				else if(choice==3)
				{
					if(full[choice-1]>=quant)
					{
						empty[choice-1]+=quant;
						System.out.println("Consumed " +quant+" Grape");
						full[choice-1]-=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						////Thread.currentThread().wait();
					}
				}
				else
				{
					if(full[choice-1]>=quant)
					{
						empty[choice-1]+=quant;
						System.out.println("Consumed " +quant+" Watermelon");
						full[choice-1]-=quant;
					}
					else 
					{
						System.out.println("Not Possible ");
						////Thread.currentThread().wait();
					}
				}

			}

		}
	}


}
