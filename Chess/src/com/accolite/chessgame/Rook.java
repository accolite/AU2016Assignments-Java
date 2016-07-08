package com.accolite.chessgame;

public class Rook extends Pieces {
	
public String color;
	
	public Rook(String color){
		this.color = color;
	}
	
	public boolean validateMove(Pieces[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		// TODO Auto-generated method stub
		

		
		if(currentRow != newRow && currentCol != newCol)
		{
			
			return false;
		}
		
		
		//My Initial assumption is that the Rook is moving along the rows.
		int offset;
		
		if(currentRow != newRow)
		{
			if(currentRow < newRow)
			{
				offset = 1;
			}
			else{
				offset = -1;
			}
			
			for(int x = currentRow + offset; x != newRow; x += offset)
			
			{
				//While checking every space,go from currentRow to newRow 
				if(board[x][currentCol] != null)
				
				{
					
					return false;
				}
			}
		}
	
		//Now i will do same procedure for columns
		if(currentCol != newCol)
		{
			if(currentCol < newCol)
			{
				offset = 1;
			}
			else{
				offset = -1;
			}
			
			for(int x = currentCol + offset; x != newCol; x += offset)
			{
				//WHile checking every space,go from currentCol to newCol 
				if(board[currentRow][x] != null)
				{
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public String toString()
	{
		return color.charAt(0) + "R";
		
	}

}
