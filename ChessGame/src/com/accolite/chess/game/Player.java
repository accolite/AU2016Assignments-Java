package com.accolite.chess.game;

public class Player {
	
	private int color;
	private String name;
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player(int color, String name) {
		this.color = color;
		this.name = name;
	}
	
}
