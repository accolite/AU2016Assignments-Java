package com.accolite.fruitmarket;

import java.util.Random;

public class Consumer extends Thread{
private Market market;
	
	public Consumer (Market market) {
		this.market = market;
	}
	
	public void run () {
		while (true) {
		System.out.println ("Consumer ready to eat");
		Random random = new Random();
		try {
			Thread.sleep(1000);		
			int type = random.nextInt(4);			
			switch (type) {
			
			case 0: 
				market.consumeApple();
				System.out.println ("Apple Consumed");
				break;
			case 1: 
				market.consumeOrange();
				System.out.println ("Orange Consumed");
				break;
			case 2: 
				market.consumeGrape();;
				System.out.println ("Grape Consumed");
				break;
			default: 
				market.consumeWatermelon();			
				System.out.println ("Watermelon Consumed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("In Consumer Block : Exception");
			e.printStackTrace();
		}
	}
		}
}
