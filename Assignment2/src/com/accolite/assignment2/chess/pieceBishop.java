package com.accolite.assignment2.chess;

public class pieceBishop extends ChessPiece {
	public pieceBishop(int x,int y,boolean b, String string)
	{
		this.x=x;
		this.y=y;
		this.statusOfPiece=b;
		this.color=string;
	}
	
	public pieceBishop() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidPosition(int initXPosition, int initYPosition, int finalXPosition, int finalYPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean moveBishop() {
		return statusOfPiece;
		// TODO Auto-generated method stub
		
	}

}
