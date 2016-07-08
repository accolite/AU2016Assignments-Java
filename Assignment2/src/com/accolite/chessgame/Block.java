package com.accolite.chessgame;

// This class tells keeps records of each block on chess board.

public class Block
{
	int x_coordinate;
	int y_coordinate;
	Piece piece;
	
	public Block (int x, int y)
	{
		this.x_coordinate=x;
		this.y_coordinate=y;
		piece=null;
	}

	public int getX_coordinate() {
		return x_coordinate;
	}

	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	public int getY_coordinate() {
		return y_coordinate;
	}

	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}
