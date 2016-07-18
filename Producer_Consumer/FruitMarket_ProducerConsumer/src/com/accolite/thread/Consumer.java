package com.accolite.thread;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	protected BlockingQueue apple = null;
	 protected BlockingQueue orange = null;
	 protected BlockingQueue grape = null;
	 protected BlockingQueue watermelon = null; 

	 public Consumer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grape, BlockingQueue watermelon ) {
	  this.apple = apple;
	  this.orange = orange;
	  this.grape = grape;
	  this.watermelon = watermelon;  
	 }
	 public void run() {
			int option = 0;
			Scanner input = new Scanner(System.in);
			while(true) {
			System.out.println("1.Want to consume Apple 2.Want to consume orange 3.Want to consume grape 4.Want to consume watermelon 5.terminate");
			option = input.nextInt();
			if(option == 1) {
				System.out.println("no. of apple wants to consume");
				int no = input.nextInt();
				if(apple.size()>=no) {
					for (int i = 0; i < no; i++) {
						apple.remove();
						System.out.println("Consume");
						
					}
				} else {
					System.out.println("not possible");
				}
			} else if(option == 2) {
				System.out.println("no. of orange wants to consume");
				int no = input.nextInt();
				if(orange.size() >= no) {
					for (int i = 0; i < no; i++) {
						orange.remove();
						System.out.println("Consume");
					}
				} else {
					System.out.println("not possible");
				}
				
			} else if(option == 3) {
				System.out.println("no. of grape wants to consume");
				int no = input.nextInt();
				if(grape.size() >= no) {
					for (int i = 0; i < no; i++) {
						grape.remove();
						System.out.println("Consume");
					}
				} else {
					System.out.println("not possible");
				}
				
			} else if(option == 4) {
				System.out.println("no. of watermelon wants to consume");
				int no = input.nextInt();
				if(watermelon.size() >= no) {
					for (int i = 0; i < no; i++) {
						watermelon.remove();
						System.out.println("Consume");
					}
				} else {
					System.out.println("not possible");
				}
			} else {
				break;
			}
			
}

		

	}
	 
}
