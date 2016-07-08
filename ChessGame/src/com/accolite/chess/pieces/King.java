package com.accolite.chess.pieces;

import com.accolite.chess.util.Location;

public class King extends Piece {

	public King(int color){
		this.color = color;
	}
	
	@Override
	public int getColor() {
		return color;
	}

	@Override
	public boolean canMove(Location curPos, Location nextPos) {
		/* Find whether the move is possible */
		return true;
	}

}
