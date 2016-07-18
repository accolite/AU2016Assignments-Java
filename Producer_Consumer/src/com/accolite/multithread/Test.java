package com.accolite.multithread;
import java.util.Scanner;
import java.util.concurrent.*;

public class Test {
	
		public static void main(String[] args) throws InterruptedException
		{
			ConcurrentHashMap<String,Integer> market = new ConcurrentHashMap<>(4);
			market.put("Apple", 0);
			market.put("Orange", 0);
			market.put("Grape", 0);
			market.put("Watermelon",0);
			Scanner in = new Scanner(System.in);
			int choice;
			
			int count1,count2;
			count1 = count2 = 0;
			
			while(true)
			{	
				System.out.println("1->Producer\n 2->Consumer\n 3->Exit\n");
				choice = in.nextInt();
				switch(choice)
				{
				case 1:
					Producer producer;
					
					if( count1 == 0)
					{
						count1++;
						producer = new Producer(market);
						producer.setName("Producer");
						
						producer.start();
						//producer.join();
					}
					else
					{
						Producer.currentThread().notifyAll();
					}
					break;
				case 2:
					Consumer consumer;
					if( count2 == 0)
					{
						count2++;
						consumer = new Consumer(market);
						consumer.setName("Consumer");
						consumer.start();
						//consumer.join();
					}
					else
					{
						Consumer.currentThread().notifyAll();
					}
					break;
				default:
						break;
				}
				if(choice == 3)
					break;
		}
	
	
	}
}

