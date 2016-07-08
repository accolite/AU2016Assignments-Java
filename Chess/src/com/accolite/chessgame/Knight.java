package com.accolite.chessgame;

public class Knight extends Pieces {
	
public String color;
	
	public Knight(String color)
	{
		this.color = color;
	}
	
	
	public boolean validateMove(Pieces[][] board, int currentRow, int currentCol, int newRow, int newCol) 
	{
		
		if(Math.abs(newRow - currentRow) == 2 && Math.abs(newCol - currentCol) == 1)
		{
			return true;
		}
		
		if(Math.abs(newRow - currentRow) == 1 && Math.abs(newCol - currentCol) == 2)
		{
			return true;
		}
		
		return false;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public String toString()
	{
		return color.charAt(0) + "A";
	}

}
