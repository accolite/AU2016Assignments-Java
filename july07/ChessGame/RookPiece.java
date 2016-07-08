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
 * The Class RookPiece.
 */
public class RookPiece extends Piece {
	
	/**
	 * Instantiates a new rook piece.
	 * @param belongsTo 
	 */
	public RookPiece(short belongsTo){
		this.belongsTo = belongsTo;
		points = 10;
	}

	@Override
	boolean checkCustomMove() {
		// TODO Auto-generated method stub
		return false;
	}



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
