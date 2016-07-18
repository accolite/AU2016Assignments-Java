package com.accolite.fruitmarket;


public class Market {
	
	private MyBuffer appleQ = new MyBuffer (5);
	private MyBuffer orangeQ = new MyBuffer (5);
	private MyBuffer grapeQ = new MyBuffer (5);
	private MyBuffer watermelonQ = new MyBuffer (5);
		
	public void produceApple(Apple apple) throws Exception {
		appleQ.addFruit(apple);
	}

	public void produceOrange(Orange orange) throws Exception {
		orangeQ.addFruit(orange);
	}
	
	public void produceGrape(Grape grape) throws Exception {
		grapeQ.addFruit(grape);
	}
	
	public void produceWatermelon(Watermelon watermelon) throws Exception {
		watermelonQ.addFruit(watermelon);
	}
	
	public void consumeApple() throws Exception {
		appleQ.consumeFruit();
	}

	public void consumeOrange() throws Exception {
		orangeQ.consumeFruit();
	}
	
	public void consumeGrape() throws Exception {
		grapeQ.consumeFruit();
	}
	
	public void consumeWatermelon() throws Exception {
		watermelonQ.consumeFruit();
	}
}

