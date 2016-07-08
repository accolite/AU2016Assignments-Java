/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Shrema Singh

* ***************************************************************************

*/
package com.accolite.assignment2.chess;

// TODO: Auto-generated Javadoc
/**
 * The Class pieceBishop.
 */
public class pieceBishop extends ChessPiece {
	
	/**
	 * Instantiates a new piece bishop.
	 *
	 * @param x the x
	 * @param y the y
	 * @param b the b
	 * @param string the string
	 */
	public pieceBishop(int x,int y,boolean b, String string)
	{
		this.x=x;
		this.y=y;
		this.statusOfPiece=b;
		this.color=string;
	}
	
	/**
	 * Instantiates a new piece bishop.
	 */
	public pieceBishop() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.accolite.assignment2.chess.ChessPiece#isValidPosition(int, int, int, int)
	 */
	@Override
	public boolean isValidPosition(int initXPosition, int initYPosition, int finalXPosition, int finalYPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Move bishop.
	 *
	 * @return true, if successful
	 */
	public boolean moveBishop() {
		return statusOfPiece;
		// TODO Auto-generated method stub
		
	}

}
