package com.accolite.au.thread;

import java.util.Scanner;

public class Producer extends Thread {

	Market m = null;
	
	public Producer(Market m) {
		this.m = m;
	}

	@Override
	public void run() {
		try{	
			m.add("apple", 6);
			sleep(800);
			m.add("apple", 5);	
			sleep(200);
			m.add("apple", 3);
			sleep(200);
			m.add("banana", 3);
			sleep(200);
			m.add("banana", 8);
			sleep(200);
			m.add("apple", 6);
			sleep(300);
			m.add("orange", 4);
			sleep(300);
			m.add("apple", 5);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Market m = new Market();
		Producer p = new Producer(m);
		p.setName("Producer");
		Consumer c = new Consumer(m);
		c.setName("Consumer");
		c.start();
		p.start();
	}
}
