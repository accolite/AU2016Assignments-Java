package com.accolite.au.assignment6;

public class Buffer {
	public int capacity;
	private int counter = 0;
	private Object[] fruits;

	public Buffer(int capacity) {
		this.capacity = capacity;
		fruits = new Object[capacity];
	}

	public synchronized void addFruit(Object object) throws Exception {
		while (counter == capacity - 1) {
			wait();
		}
		fruits[counter] = object;
		counter++;
		notifyAll();
	}

	public synchronized Object consumeFruit() throws Exception {
		while (counter == 0) {
			wait();
		}
		counter--;
		Object object = fruits[counter];
		notifyAll();
		return object;
	}
}
