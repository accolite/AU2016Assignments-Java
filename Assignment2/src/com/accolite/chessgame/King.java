package com.accolite.chessgame;

public class King extends Piece{

	

	public King(boolean available, int x, int y, Color color) {
		super(available, x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean valid(ChessBoard board, int fromX, int toX, int fromY, int toY)
	{
		// TODO Auto-generated method stub
		if(super.valid(board,fromX,toX,fromY,toY)==false)
		{
			// check if the move is within the desired coordinates
			return false;
		}
		
		// Write conditions to check valid move of King
		return true;
	}

}
