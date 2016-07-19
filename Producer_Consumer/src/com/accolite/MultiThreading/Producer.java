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
import java.util.concurrent.atomic.AtomicInteger;

// TODO: Auto-generated Javadoc
/**
 * The Class Producer.
 */
public class Producer implements Runnable{

	/** The apple queue. */
	protected BlockingQueue apple = null;
	
	/** The orange queue. */
	protected BlockingQueue orange = null;
	
	/** The grape queue. */
	protected BlockingQueue grape = null;
	
	/** The watermelon queue. */
	protected BlockingQueue watermelon = null;
	
	/** the variables for fruits */
	int var_apple,var_orange,var_grape,var_watermelon;
	
	/** The scanner to get input */
	Scanner sc;

	/**
	 * Instantiates a new producer.
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
	public Producer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon,int var_apple,int var_orange,int var_grape,int var_watermelon) {
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
	 * method to insert fruits into the queue
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		int i;
		try {
			for(i=0;i<var_apple;i++)
			{
				System.out.println(name+" waiting to add Apple");
				apple.put(name);
				System.out.println(name+" Added 1 Apple :"+apple.size());
				
			}
			for(i=0;i<var_orange;i++)
			{
				System.out.println(name+" waiting to add Orange");
				orange.put(name);
				System.out.println(name+" Added 1 Orange :"+orange.size());
				
			}
			for(i=0;i<var_grape;i++)
			{
				System.out.println(name+" waiting to add Grape");
				grape.put(name);
				System.out.println(name+" Added 1 Grape :"+grape.size());
				
			}
			for(i=0;i<var_watermelon;i++)
			{
				System.out.println(name+" waiting to add Watermelon");
				watermelon.put(name);
				System.out.println(name+" Added 1 Watermelon : "+watermelon.size());
				
			}
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
}
