package com.accolite.fruitmarket;

import java.util.Random;

public class Farmer extends Thread{
	private Market market;
	
	public Farmer (Market market) {
		this.market = market;
	}
	
	public void run () {
		while (true) {
		System.out.println ("Producing Fruit:");
		Random random = new Random();
		try {
			Thread.sleep(1000);
			
			int type = random.nextInt(4);		
			
			switch (type) {
			case 0: 
				market.produceApple(new Apple());
				System.out.println ("Apple produced");
				break;
			case 1: 
				market.produceOrange(new Orange());
				System.out.println ("Orange produced");
				break;
			case 2: 
				market.produceGrape(new Grape());
				System.out.println ("Grape produced");
				break;
			default: 
				market.produceWatermelon(new Watermelon());			
				System.out.println ("Watermelon produced");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
