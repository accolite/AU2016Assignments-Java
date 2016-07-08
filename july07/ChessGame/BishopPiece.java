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
 * The Class BishopPiece.
 */
public class BishopPiece extends Piece {

	/**
	 * Instantiates a new bishop piece.
	 * @param belongsTo 
	 */
	public BishopPiece(short belongsTo){
		this.belongsTo = belongsTo;
		points = 15;
	}


	/* This piece's move validity */
	@Override
	boolean checkCustomMove() {
		// TODO Auto-generated method stub
		return false;
	}

	
	/* Move Bishop after validity check */
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
