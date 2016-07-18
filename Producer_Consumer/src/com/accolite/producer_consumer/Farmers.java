package com.accolite.producer_consumer;

import java.util.concurrent.ConcurrentHashMap;

public class Farmers {
	
	ConcurrentHashMap<Integer,String> ch;
	
	public Farmers(int apple,int orange,int grape,int watermelon){
		ch.put(apple, "apple");
		ch.put(orange, "orange");
		ch.put(grape, "grape");
		ch.put(watermelon, "watermelon");
	}
}
