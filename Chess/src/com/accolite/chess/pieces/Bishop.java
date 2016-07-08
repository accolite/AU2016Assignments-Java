package com.accolite.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.accolite.chess.Color;
import com.accolite.chess.Game;
import com.accolite.chess.Piece;
import com.accolite.chess.PieceStatus;
import com.accolite.chess.Position;

public class Bishop extends Piece {

	public Bishop(String name, Position position, Color color, PieceStatus pieceStatus) {
		super(name, position, color, pieceStatus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Position> moves() {
		List<Position> result = new ArrayList<Position>();
		List<Position> finalResult = new ArrayList<Position>();
		Position initial = getPosition();
		
		for (int i = 0; i < Game.NUM_ROWS; i++) {
			if(initial.changeDelta( i,  i) != null)	result.add(initial.changeDelta( i,  i));
			if(initial.changeDelta( i, -i) != null)	result.add(initial.changeDelta( i, -i));
			if(initial.changeDelta(-i,  i) != null)	result.add(initial.changeDelta(-i,  i));
			if(initial.changeDelta(-i, -i) != null)	result.add(initial.changeDelta(-i, -i));
		}
		for (Position position : result) {
			if(!position.equals(initial)){
				finalResult.add(position);
			}
		}
		
		return finalResult;
	}

}
