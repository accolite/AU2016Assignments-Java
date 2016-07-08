package com.accolite.chessgame;

public class Rook extends Piece{

	

	public Rook(boolean available, int x, int y, Color color) {
		super(available, x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean valid(ChessBoard board, int fromX, int toX, int fromY, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
