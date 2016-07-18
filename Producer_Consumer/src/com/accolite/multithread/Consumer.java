package com.accolite.multithread;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Consumer extends Thread {
	

	ConcurrentHashMap<String,Integer> space;
	Scanner inp1 = new Scanner(System.in);
	Consumer(ConcurrentHashMap<String,Integer> market)
	{
		this.space = market;
	}
	
		public void run()
		{
				while(true)
				{
					if(space.isEmpty())
					{
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("What would you like to eat from Apple,Orange,Grape,Watermelon");
						String to_consume = inp1.next();
						int available = space.get(to_consume);
						if(available > 0)
						{
							System.out.println("Enter Quantity you wish to consume");
							int wanted = inp1.nextInt();
							if(wanted <= available)
							{
								System.out.println("You Consumed " + wanted + " amount of" + to_consume);
								space.put(to_consume, (available - wanted));							
							}
							else
							{
								System.out.println("Sorry the quantity you ordered is not available");
							}
						}
						else
						{
							try {
								this.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			
		}
}
