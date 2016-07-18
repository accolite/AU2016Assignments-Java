package com.accolite.fruitmarket;


public class MyBuffer {
	public int capacity;	
	private int counter = 0;
	private Object[] fruits;
	

	public MyBuffer (int capacity) {
		this.capacity = capacity;
		fruits = new Object[capacity];
	}
	
	public synchronized void addFruit (Object object) throws Exception {
		
		while (counter == capacity-1) {
			wait();
		}
		
		fruits[counter] = object;
		counter++;
		notifyAll();
		
		System.out.println("Adding: "+object.getClass().getName() + counter);
	}
	
	public synchronized Object consumeFruit() throws Exception {
		
		while (counter == 0) {
			wait();
		}

		counter--;
		Object object = fruits[counter];
		notifyAll();
		
		System.out.println("Consuming: "+object.getClass().getName()+ "Counter Value:" + counter);
		return object;
	}
}