package multithreading;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Market {
	public static void main(String[] args)
	{
		BlockingQueue Apple = new ArrayBlockingQueue(5);
		BlockingQueue Orange = new ArrayBlockingQueue(5);
		BlockingQueue Watermelon = new ArrayBlockingQueue(5);
		BlockingQueue Grape = new ArrayBlockingQueue(5);
	    int numberApple,numberOrange,numberWatermelon,numberGrape;
		Scanner input= new Scanner(System.in);
		int choice;
		while(true)
		{
			System.out.println("1. Farmer\n2.Consumer");
			choice=input.nextInt();
			if(choice==1)
			{
				System.out.println("Number of Apple,Orange,Watermelon,Grape:");
				numberApple=input.nextInt();
				numberOrange=input.nextInt();
				numberWatermelon=input.nextInt();
				numberGrape=input.nextInt();
				Farmer farmer= new Farmer(Apple,Orange,Watermelon,Grape,numberApple,numberOrange,numberWatermelon,numberGrape);
				new Thread(farmer).start();
			}
			else
			{
				System.out.println("Number of Apple,Orange,Watermelon,Grape:");
				numberApple=input.nextInt();
				numberOrange=input.nextInt();
				numberWatermelon=input.nextInt();
				numberGrape=input.nextInt();
				Consumer consumer= new Consumer(Apple,Orange,Watermelon,Grape,numberApple,numberOrange,numberWatermelon,numberGrape);
				new Thread(consumer).start();
			}
					
		}
	}
}
