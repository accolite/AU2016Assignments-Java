/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 7, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.chessgame;

/**
 * The Class KnightPiece.
 */
public class KnightPiece extends Piece {
	
	/**
	 * Instantiates a new knight piece.
	 * @param belongsTo 
	 */
	public KnightPiece(short belongsTo){
		this.belongsTo = belongsTo;
		points = 12;
	}

	/* This piece's move validity */
	@Override
	boolean checkCustomMove() {
		// TODO Auto-generated method stub
		return false;
	}

	/* Move Knight after validity check */
	@Override
	boolean move(short player, String startPosition, String endPosition) {
		// TODO Auto-generated method stub
		if(super.move(player, startPosition, endPosition)){
			if(checkCustomMove()){
				return true;
			}else{
				return false;
			}
		}else
			return false;
		
	}

}
