/**
 * 
 */
package com.accolite.assignment2.chess;

// TODO: Auto-generated Javadoc
/**
 * The Class ChessPiece.
 *
 * @author Shrema Singh
 */
public abstract class ChessPiece {
	
	/** The status of piece. */
	public boolean statusOfPiece;
	
	/** The x. */
	public int x;
	
	/** The y. */
	public int y;
	
	/** The color. */
	public String color;
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Checks if is piece active.
	 *
	 * @return true, if is piece active
	 */
	public boolean isPieceActive() {
		return statusOfPiece;
	}
	
	/**
	 * Sets the status of piece.
	 *
	 * @param statusOfPiece the new status of piece
	 */
	public void setStatusOfPiece(boolean statusOfPiece) {
		this.statusOfPiece = statusOfPiece;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Checks if is valid position.
	 *
	 * @param initXPosition the init X position
	 * @param initYPosition the init Y position
	 * @param finalXPosition the final X position
	 * @param finalYPosition the final Y position
	 * @return true, if is valid position
	 */
	public abstract boolean isValidPosition(int initXPosition,int initYPosition,int finalXPosition,int finalYPosition);
	
	//define movement for each piece here
 
}
