package com.accolite.chess.util;

public class Location {
	int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Location(String loc){
		// Method to parse the given string location to x, y co-ordinates
		this.x = 0;
		this.y = 0;
	}
	
	public boolean equals(Object l){
		Location l2 = (Location)l;
		if(this.x == l2.x && this.y == l2.y)
			return true;
		return false;
	}
	
	public int hashCode(){
		return this.x * this.y;
	}
	
}
