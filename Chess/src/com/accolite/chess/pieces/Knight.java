package com.accolite.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.accolite.chess.Color;
import com.accolite.chess.Piece;
import com.accolite.chess.PieceStatus;
import com.accolite.chess.Position;

public class Knight extends Piece {

	public Knight(String name, Position position, Color color, PieceStatus pieceStatus) {
		super(name, position, color, pieceStatus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Position> moves() {
		List<Position> result = new ArrayList<Position>();
		Position initial = getPosition();
		
		if(initial.changeDelta( 1,  2) != null)	result.add(initial.changeDelta( 1,  2));
		if(initial.changeDelta( 2,  1) != null)	result.add(initial.changeDelta( 2,  1));
		if(initial.changeDelta(-1,  2) != null)	result.add(initial.changeDelta(-1,  2));
		if(initial.changeDelta( 1, -2) != null)	result.add(initial.changeDelta( 1, -2));
		if(initial.changeDelta(-1, -2) != null)	result.add(initial.changeDelta(-1, -2));
		if(initial.changeDelta(-2, -1) != null)	result.add(initial.changeDelta(-2, -1));
		if(initial.changeDelta(-2,  1) != null)	result.add(initial.changeDelta(-2,  1));
		if(initial.changeDelta( 2, -1) != null)	result.add(initial.changeDelta( 2, -1));
		
		return result;
	}

}
