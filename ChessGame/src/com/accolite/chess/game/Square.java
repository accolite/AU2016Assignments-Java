package com.accolite.chess.game;

import com.accolite.chess.pieces.Piece;

public class Square {
	
	int color;
	Piece piece;
	
	Square(int color, Piece piece){
		this.color = color;
		this.piece = piece;
	}
	
	Square(int color){
		this.color = color;
	}
	
	public int getColor(){
		return color;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	public void setPiece(Piece piece){
		this.piece = piece;
	}
	
	public boolean isEmpty(){
		return this.piece == null;
	}
	
	public void makeEmpty(){
		this.piece = null;
	}
}
