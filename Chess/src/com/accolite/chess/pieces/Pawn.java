package com.accolite.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.accolite.chess.Color;
import com.accolite.chess.Piece;
import com.accolite.chess.PieceStatus;
import com.accolite.chess.Position;

public class Pawn extends Piece {

	public Pawn(String name, Position position, Color color, PieceStatus pieceStatus) {
		super(name, position, color, pieceStatus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Position> moves() {
		
		List<Position> moves = new ArrayList<Position>();
		Position initial = getPosition();
		if(getColor() == Color.BLACK){
			moves.add(initial.changeDelta(1, 0));
			if(initial.getX()==1)
				moves.add(initial.changeDelta(2, 0));
			if(initial.changeDelta(1,  1) != null) moves.add(initial.changeDelta(1,  1));
			if(initial.changeDelta(1, -1) != null) moves.add(initial.changeDelta(1, -1));
		} else {
			moves.add(initial.changeDelta(-1, 0));
			if(initial.getX()==6)
				moves.add(initial.changeDelta(-2, 0));
			if(initial.changeDelta(-1,  1) != null) moves.add(initial.changeDelta(-1,  1));
			if(initial.changeDelta(-1, -1) != null) moves.add(initial.changeDelta(-1, -1));
		}
		
		return moves;
	}

}
