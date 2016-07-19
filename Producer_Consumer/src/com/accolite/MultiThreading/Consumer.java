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
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumer.
 */
public class Consumer implements Runnable{

	/** The apple. */
	protected BlockingQueue apple = null;
	
	/** The orange. */
	protected BlockingQueue orange = null;
	
	/** The grape. */
	protected BlockingQueue grape = null;
	
	/** The watermelon. */
	protected BlockingQueue watermelon = null;
	
	/** The variables for fruits */
	int var_apple,var_orange,var_grape,var_watermelon;
	
	/** The sc. */
	Scanner sc;

	/**
	 * Instantiates a new consumer.
	 *
	 * @param apple the apple
	 * @param orange the orange
	 * @param grape the grape
	 * @param watermelon the watermelon
	 * @param var_apple the var apple
	 * @param var_orange the var orange
	 * @param var_grape the var grape
	 * @param var_watermelon the var watermelon
	 */
	public Consumer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon,int var_apple,int var_orange,int var_grape,int var_watermelon) {
		super();
		this.apple = apple;
		this.orange = orange;
		this.grape = grape;
		this.watermelon = watermelon;
		this.var_apple=var_apple;
		this.var_orange=var_orange;
		this.var_grape=var_grape;
		this.var_watermelon=var_watermelon;
		sc=new Scanner(System.in);
	}


	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * method to consume fruits from market
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		int i=0;
		try {
			for(i=0;i<var_apple;i++)
			{	
				System.out.println(name+" waiting for Apple");
				apple.take();
				System.out.println(name+" bought 1 apple");
			}
			for(i=0;i<var_orange;i++)
			{	
				System.out.println(name+" waiting for Orange");
				orange.take();
				System.out.println(name+" bought 1 orange");
				
			}
			for(i=0;i<var_grape;i++)
			{	
				System.out.println(name+" waiting for Grape");
				grape.take();
				System.out.println(name+" bought 1 grape");
				
			}
			for(i=0;i<var_watermelon;i++)
			{
				System.out.println(name+" waiting for Watermelon");
				watermelon.take();
				System.out.println(name+" bought 1 watermelon");
				
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
}

	

