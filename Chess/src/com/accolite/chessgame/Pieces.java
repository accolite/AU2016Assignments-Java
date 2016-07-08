package com.accolite.chessgame;

public abstract class Pieces {
	
	public String color;
	public boolean hasMoved;
	public boolean ep_able;
	
	/**
	 * This will get the color
	 * @return color of the piece
	 */
	public abstract String getColor();
	
	/**
	 * This will move the piece 
	 * 
	 * @return true if the move was valid or not.
	 */
	public abstract boolean validateMove(Pieces[][] board, int currentRow, int currentCol, int newRow, int newCol);


}
