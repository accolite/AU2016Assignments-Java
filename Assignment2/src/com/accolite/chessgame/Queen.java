package com.accolite.chessgame;

public class Queen extends Piece
{

	public Queen(boolean available, int x, int y, Color color) {
		super(available, x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean valid(ChessBoard board, int fromX, int toX, int fromY, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
