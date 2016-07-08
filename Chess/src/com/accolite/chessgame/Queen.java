package com.accolite.chessgame;

public class Queen extends Pieces {
	
public String color;
	
	public Queen(String color){
		this.color = color;
	}

	
	public boolean validateMove(Pieces[][] board, int currentRow, int currentCol, int newRow, int newCol) 
	{
		
		return new Rook(color).validateMove(board, currentRow, currentCol, newRow, newCol) || new Bishop(color).validateMove(board, currentRow, currentCol, newRow, newCol);
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String toString(){
		return color.charAt(0) + "Q";
		
	}	

}
