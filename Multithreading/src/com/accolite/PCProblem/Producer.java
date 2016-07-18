package com.accolite.PCProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue apple = null;
	 BlockingQueue orange = null;
	 BlockingQueue grape = null;
	 BlockingQueue watermelon = null;
	 int apples_no=0;
	 int orange_no=0;
	 int grape_no=0;
	 int watermelon_no=0;
	 static int MAX_SIZE;
	public Producer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon,int apples_no,int orange_no,int grape_no,int watermelon_no) {
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
	public void InsertFruits()
	{
		try{
		
			if(MAX_SIZE-apple.size()<apples_no)
			{
				System.out.println("Not much space for apples");
				//Thread.currentThread().wait();
			}
			else
			{
				for(int i=0;i<apples_no;i++)
				{
					apple.put(23);
				}
				//System.out.println(apples_no+ "apples inserted");
				//notify();
			}
				
		
		
			if(MAX_SIZE-orange.size()<orange_no)
			{
				System.out.println("Not much space for orange");
				//Thread.currentThread().wait();
			}
			else
			{
				for(int i=0;i<orange_no;i++)
				{
					orange.put(23);
				}
				//Thread.currentThread().notify();
			}
				
		
		
			if(MAX_SIZE-grape.size()<grape_no)
			{
				System.out.println("Not much space for grape");
				//Thread.currentThread().wait();
			}
			else
			{
				for(int i=0;i<grape_no;i++)
				{
					grape.put(23);
				}
				//Thread.currentThread().notify();
			}
				
		
		
			//System.out.println("hello");
			if(MAX_SIZE-watermelon.size()<watermelon_no)
			{
				System.out.println("Not much space for watermelon");
				//Thread.currentThread().wait();
			}
			else
			{
				for(int i=0;i<watermelon_no;i++)
				{
					watermelon.put(23);
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
		InsertFruits();
		
		

	}

}
