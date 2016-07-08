/**
 * 
 */
package com.accolite.assignment2.chess;

/**
 * @author Shrema Singh
 *
 */
public abstract class ChessPiece {
	public boolean statusOfPiece;
	public int x;
	public int y;
	public String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isPieceActive() {
		return statusOfPiece;
	}
	public void setStatusOfPiece(boolean statusOfPiece) {
		this.statusOfPiece = statusOfPiece;
	}
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
	
	public abstract boolean isValidPosition(int initXPosition,int initYPosition,int finalXPosition,int finalYPosition);
	
	//define movement for each piece here
 
}
