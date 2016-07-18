package com.accolite.au.thread;

import java.util.concurrent.ConcurrentHashMap;

public class Market {
	
	ConcurrentHashMap<String, Integer> basket = new ConcurrentHashMap<>();
	
	String waitingToProduce = null;
	int neededQtyToProduce = 0;
	
	String waitingToConsume = null;
	int neededQtyToConsume = 0;
	
	public synchronized boolean add(String fruit, int qty) throws InterruptedException{
		if(qty > 10 || qty < 1)
			return false;
		if(qty + availability(fruit) > 10){
			waitingToConsume = fruit;
			neededQtyToConsume = availability(fruit) - (10 - qty);
			System.out.println(Thread.currentThread().getName()+" : Waiting for "+neededQtyToConsume+" of "+ waitingToConsume+" to be consumed");
			wait();
		}
		basket.put(fruit, availability(fruit)+qty);
		System.out.println(Thread.currentThread().getName()+" : Produced "+qty+"  "+fruit+" ("+availability(fruit)+")");
		if(fruit.equals(waitingToProduce)){
			if(qty >= neededQtyToProduce){
				waitingToProduce = null;
				neededQtyToProduce = 0;
				notify();
				System.out.println(Thread.currentThread().getName()+" : Notified");
			}
			else
				neededQtyToProduce -= qty;
		}
		return true;
	}
	
	public synchronized boolean get(String fruit, int qty) throws InterruptedException{
		if(qty < 1 || qty > 10)
			return false;
		if(qty > availability(fruit)){
			waitingToProduce = fruit;
			neededQtyToProduce = qty - availability(fruit);
			System.out.println(Thread.currentThread().getName()+" : Waiting for "+neededQtyToProduce+" of "+waitingToProduce+" to be produced");
			wait();
		}
		basket.put(fruit, availability(fruit)-qty);
		System.out.println(Thread.currentThread().getName()+" : Consumed "+qty+"  "+fruit+" ("+availability(fruit)+")");
		if(fruit.equals(waitingToConsume)){
			if(qty >= neededQtyToConsume){
				neededQtyToConsume = 0;
				waitingToConsume = null;
				notify();
				System.out.println(Thread.currentThread().getName()+" : Notified");
			}
			else
				neededQtyToConsume -= qty;
		}
		return true;
	}
	
	public synchronized int availability(String fruit){
		int ans = 0;
		if(basket.get(fruit)!=null)
			ans = basket.get(fruit);
		return ans;
	}
	
}
