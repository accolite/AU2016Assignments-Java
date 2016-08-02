package com.accolite.producerconsumer;

public class ConsumerHandler implements Runnable{

	Fruits fruits;
	private int qty1;
	private int qty2;
	private int qty3;
	private int qty4;
	public ConsumerHandler(Fruits fruits,int qty1,int qty2,int qty3,int qty4) {
		// TODO Auto-generated constructor stub
		this.fruits = fruits;
		this.qty1 = qty1;
		this.qty2 = qty2;
		this.qty3 = qty3;
		this.qty4 = qty4;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			Runnable consumer = new Consumer(fruits,qty1,qty2,qty3,qty4);
			Thread buyer = new Thread(consumer,"Buyer");
			buyer.start();
			buyer.join();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
