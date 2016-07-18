package com.accolite.au.thread;

public class Consumer extends Thread{
	
	Market m = null;
	
	public Consumer(Market m) {
		this.m = m;
	}
	
	
	@Override
	public void run() {
		try {
			m.get("apple", 1);
			sleep(1300);
			m.get("apple", 3);
			sleep(1300);
			m.get("apple", 5);
			sleep(1300);
			m.get("apple", 5);
			sleep(1300);
			m.get("banana", 1);
			sleep(1000);
			m.get("apple", 5);
			sleep(1300);
			m.get("apple", 5);
			sleep(1000);
			m.get("orange", 4);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
