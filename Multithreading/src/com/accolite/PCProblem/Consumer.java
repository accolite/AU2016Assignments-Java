package com.accolite.PCProblem;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue apple = null;
	 BlockingQueue orange = null;
	 BlockingQueue grape = null;
	 BlockingQueue watermelon = null;
	 int apples_no=0;
	 int orange_no=0;
	 int grape_no=0;
	 int watermelon_no=0;
	 static int MAX_SIZE;
	 public Consumer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon,int apples_no,int orange_no,int grape_no,int watermelon_no) {
		super();
		this.apple = apple;
		this.orange = orange;
		this.grape = grape;
		this.watermelon = watermelon;
		this.apples_no=apples_no;
		this.orange_no=orange_no;
		this.grape_no=grape_no;
		this.watermelon_no=watermelon_no;
	}
	public void ConsumeFruits()
	{
		try{
			
				if(apple.size()<apples_no)
				{
					System.out.println("Not much apples available");
					//Thread.currentThread().wait();
				}
				else
				{
					for(int i=0;i<apples_no;i++)
					{
						apple.take();
					}
					System.out.println(apples_no + "apples removed");
					//notify();
				}
					
			
			
				if(orange.size()<orange_no)
				{
					System.out.println("Not much oranges available");
					//Thread.currentThread().wait();
				}
				else
				{
					for(int i=0;i<orange_no;i++)
					{
						orange.take();
					}
					//Thread.currentThread().notify();
				}
					
			
			
				if(grape.size()<grape_no)
				{
					System.out.println("Not much grapes available");
					//Thread.currentThread().wait();
				}
				else
				{
					for(int i=0;i<grape_no;i++)
					{
						grape.take();
					}
					//Thread.currentThread().notify();
				}
					
			
			
				if(watermelon.size()<watermelon_no)
				{
					System.out.println("Not much watermelons available");
					//Thread.currentThread().wait();
				}
				else
				{
					for(int i=0;i<watermelon_no;i++)
					{
						watermelon.take();
					}
					//Thread.currentThread().notify();
				}
					
			
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ConsumeFruits();
		

	}

}
