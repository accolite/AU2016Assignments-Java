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
 * The Class KingPiece.
 */
public class KingPiece extends Piece {
	
	/**
	 * Instantiates a new king piece.
	 * @param belongsTo 
	 */
	public KingPiece(short belongsTo){
		this.belongsTo = belongsTo;
		points = 25;
	}

	/* This piece's move validity */
	@Override
	boolean checkCustomMove() {
		// TODO Auto-generated method stub
		return false;
	}

	/* Move King after validity check */
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
