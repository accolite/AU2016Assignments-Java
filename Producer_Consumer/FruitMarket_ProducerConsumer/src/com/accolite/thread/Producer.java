package com.accolite.thread;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	protected BlockingQueue apple = null;
	protected BlockingQueue orange = null;
	protected BlockingQueue grape = null;
	protected BlockingQueue watermelon = null;

	public Producer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon) {
		this.apple = apple;
		this.orange = orange;
		this.grape = grape;
		this.watermelon = watermelon;
	}

	public void run() {
		int option = 0;
		Scanner input = new Scanner(System.in);
		try {
			while(true) {
			System.out.println("1.Want to produce Apple 2.Want to produce orange 3.Want to produce grape 4.Want to produce watermelon 5.terminate");
			option = input.nextInt();
			if(option == 1) {
				System.out.println("no. of apple wants to produce");
				int no = input.nextInt();
				if(apple.size() + no <= 10) {
					for (int i = 0; i < no; i++) {
						apple.put("apple");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
			} else if(option == 2) {
				System.out.println("no. of orange wants to produce");
				int no = input.nextInt();
				if(orange.size() + no <= 10) {
					for (int i = 0; i < no; i++) {
						orange.put("orange");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
				
			} else if(option == 3) {
				System.out.println("no. of grape wants to produce");
				int no = input.nextInt();
				if(grape.size() + no <= 10) {
					for (int i = 0; i < no; i++) {
						grape.put("grape");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
				
			} else if(option == 4) {
				System.out.println("no. of watermelon wants to produce");
				int no = input.nextInt();
				if(watermelon.size() + no <= 10) {
					for (int i = 0; i < no; i++) {
						watermelon.put("watermelon");
						System.out.println("Produce");
					}
				} else {
					System.out.println("not possible");
				}
			} else {
				break;
			}
			
		} 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

	

}
}
