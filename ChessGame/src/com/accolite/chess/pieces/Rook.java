package com.accolite.chess.pieces;

import com.accolite.chess.util.Location;

public class Rook extends Piece{

	public Rook(int color) {
		this.color = color;
	}
	
	@Override
	public int getColor() {
		return this.color;
	}

	@Override
	public boolean canMove(Location current, Location next) {
		// TODO Auto-generated method stub
		return true;
	}

}
