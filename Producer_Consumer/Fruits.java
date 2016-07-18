package com.accolite.au.assignment6;

public class Fruits {

	private Buffer apples = new Buffer(9);
	private Buffer oranges = new Buffer(9);
	private Buffer grapes = new Buffer(9);
	private Buffer watermelons = new Buffer(9);

	public void producerApple(Apple apple) throws Exception {
		apples.addFruit(apple);
	}

	public void producerOrange(Orange orange) throws Exception {
		oranges.addFruit(orange);
	}

	public void producerGrape(Grape grape) throws Exception {
		grapes.addFruit(grape);
	}

	public void producerWatermelon(Watermelon watermelon) throws Exception {
		watermelons.addFruit(watermelon);
	}

	public void consumeApple() throws Exception {
		apples.consumeFruit();
	}

	public void consumeOrange() throws Exception {
		oranges.consumeFruit();
	}

	public void consumeGrape() throws Exception {
		grapes.consumeFruit();
	}

	public void consumeWatermelon() throws Exception {
		watermelons.consumeFruit();
	}
}
