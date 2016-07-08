/**
 * 
 */
package com.accolite.assignment2.chess;

// TODO: Auto-generated Javadoc
/**
 * The Class piecePawn.
 *
 * @author Shrema Singh
 */
public class piecePawn extends ChessPiece {
	
	/**
	 * Instantiates a new piece pawn.
	 *
	 * @param x the x
	 * @param y the y
	 * @param b the b
	 * @param string the string
	 */
	public piecePawn(int x,int y,boolean b, String string)
	{
		this.x=x;
		this.y=y;
		this.statusOfPiece=b;
		this.color=string;
	}
	
	/* (non-Javadoc)
	 * @see com.accolite.assignment2.chess.ChessPiece#isValidPosition(int, int, int, int)
	 */
	@Override
	public boolean isValidPosition(int initXPosition, int initYPosition, int finalXPosition, int finalYPosition) {
		// TODO Auto-generated method stub
		return false;
	}
}
