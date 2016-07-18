package com.accolite.multithread;
import java.util.Scanner;
import java.util.concurrent.*;
public class Producer extends Thread {

		ConcurrentHashMap<String,Integer> space;
		Scanner inp = new Scanner(System.in);
		Producer(ConcurrentHashMap<String,Integer> market)
		{
			this.space = market;
		}
		
		public void run()
		{
			
			while(true)
			{	System.out.println("Enter Fruit name");
				String fruit = inp.next();
				System.out.println("Enter Quantity");
				int num = inp.nextInt();
				int temp = space.get(fruit);
				if((num + temp) > 30)
				{
					System.out.println("Quantity overexcceded:- ONLY" + (30 - temp) + " Space is left");
					/*try to wait this Producer*/
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					space.put(fruit, num);
					System.out.println("Your production of" + fruit +" with quantity of" + num + " was successful");
					
				}
				/*try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
			
		}
		
}
