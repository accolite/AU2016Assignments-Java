package com.accolite.Assignment1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Fruits {
	BlockingQueue<Integer> appleBlockingDeque = new ArrayBlockingQueue<Integer>(5);
	BlockingQueue<Integer> orangeBlockingDeque = new ArrayBlockingQueue<Integer>(5);
	BlockingQueue<Integer> grapeBlockingDeque = new ArrayBlockingQueue<Integer>(5);
	BlockingQueue<Integer> wmBlockingDeque = new ArrayBlockingQueue<Integer>(5);
	
	public void print(){
		System.out.println("apple: "+appleBlockingDeque.size()+" orange: "+orangeBlockingDeque.size());
		System.out.println("Grape: "+grapeBlockingDeque.size()+" wm: "+wmBlockingDeque.size());
	}
	
	public void addFruits(int apple, int orange, int grape, int wm){
		System.out.println("I'm in add fruits");
		int size;
		while(apple-- > 0){
			appleBlockingDeque.add(1);
		}
		
		while(orange-- > 0){
			orangeBlockingDeque.add(1);
		}
		
		while(grape-- > 0){
			grapeBlockingDeque.add(1);
		}
		
		while(wm-- > 0){
			wmBlockingDeque.add(1);
		}
	}
	
	public int size(int i){
		System.out.println("I am here");
		switch (i) {
		case 1:return appleBlockingDeque.size();
		case 2: return orangeBlockingDeque.size();
		case 3: return grapeBlockingDeque.size();
		case 4: return wmBlockingDeque.size();
		default: return 0;
		}
	}

	public void removeFruits(int apple, int orange, int grape, int wm) {
		// TODO Auto-generated method stub
		
		while(apple-- > 0){
			appleBlockingDeque.remove(1);
		}
		
		while(orange-- > 0){
			orangeBlockingDeque.remove(1);
		}
		
		while(grape-- > 0){
			grapeBlockingDeque.remove(1);
		}
		
		while(wm-- > 0){
			wmBlockingDeque.remove(1);
		}
		
	}
}
