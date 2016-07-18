package com.accolite.multithreading.assignment;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ProducerClass extends Thread {
	protected BlockingQueue apple = null;
	protected BlockingQueue orange = null;
	protected BlockingQueue grape = null;
	protected BlockingQueue watermelon = null;

	public ProducerClass(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon) {
		this.apple = apple;
		this.orange = orange;
		this.grape = grape;
		this.watermelon = watermelon;
	}

	public void run() {
		int choice = 0,num;
		Scanner entry = new Scanner(System.in);boolean f=true;
		try {
			while(f) {
				System.out.println("1.For producing Apple?\n 2.For producing orange\n 3.For producing grape\n 4.For producing watermelon\n 5.To stop producing");
			choice = entry.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("no. of apple wants to produce");
				num = entry.nextInt();
				if(apple.size() + num <= 10) {
					for (int i = 0; i < num; i++) {
						apple.put("apple");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
				break;
			case 2:
				System.out.println("no. of orange wants to produce");
				num = entry.nextInt();
				if(orange.size() + num <= 10) {
					for (int i = 0; i < num; i++) {
						orange.put("orange");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
				break;
			case 3:
				System.out.println("no. of grape wants to produce");
				 num = entry.nextInt();
				if(grape.size() + num <= 10) {
					for (int i = 0; i < num; i++) {
						grape.put("grape");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
				break;
			case 4:
				System.out.println("no. of watermelon wants to produce");
				 num = entry.nextInt();
				if(watermelon.size() + num <= 10) {
					for (int i = 0; i < num; i++) {
						watermelon.put("watermelon");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
				break;
			default:f=false;
				break;
			}
			
		} 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

	

}
}
