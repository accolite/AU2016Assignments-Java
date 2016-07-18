/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package au.accolite.mutithreadingAssignment;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class FruitMarket.
 */
public class FruitMarket {
	
/**
 * The main method.
 *
 * @param args the arguments
 * @throws InterruptedException the interrupted exception
 */
public static void main(String[] args) throws InterruptedException {
	
		Thread t1;
		Thread t2;
		int cont=1;
		BlockingQueue appleQueue=new ArrayBlockingQueue(5);
		BlockingQueue orangeQueue=new ArrayBlockingQueue(5);
		BlockingQueue grapeQueue=new ArrayBlockingQueue(5);
		BlockingQueue watermelonQueue=new ArrayBlockingQueue(5);
		while(cont==1)
		{
		
			System.out.println("Enter desired option:");
			System.out.println("1. Producer");
			System.out.println("2. Consumer");
			System.out.println("3. Quantity of each fruit");
			
			Scanner in=new Scanner(System.in);
			int input,fruit;
			input=in.nextInt();
		
			switch (input) {
			case 1:
				Farmer farmer=new Farmer(appleQueue, orangeQueue, grapeQueue, watermelonQueue);
				t1=new Thread(farmer);
				t1.start();
				t1.join();
				break;
	
			case 2:
				Consumer consumer=new Consumer(appleQueue, orangeQueue, grapeQueue, watermelonQueue);
				t2=new Thread(consumer);
				t2.start();
				t2.join();
				break;
				
			case 3:
				System.out.println("Apple: "+appleQueue.size());
				System.out.println("Orange: "+orangeQueue.size());
				System.out.println("Grape: "+grapeQueue.size());
				System.out.println("Watermelon: "+watermelonQueue.size());
				
			default:
				System.out.println("Inappropriate option");
				break;
			}
			
			System.out.println("Want to continue (0/1)");
			cont=in.nextInt();
			if(cont!=0 && cont!=1)
			{
				System.out.println("Incorrect option");
				System.exit(0);
			}
		}
	}


}
