package com.accolite.chess.pieces;

import com.accolite.chess.util.Location;

public abstract class Piece {
	int color;
	
	public abstract int getColor();
	public abstract boolean canMove(Location current, Location next);
}