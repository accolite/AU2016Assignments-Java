/**
 * 
 */
package com.accolite.assignment2.chess;

/**
 * @author Shrema Singh
 *
 */
public class piecePawn extends ChessPiece {
	public piecePawn(int x,int y,boolean b, String string)
	{
		this.x=x;
		this.y=y;
		this.statusOfPiece=b;
		this.color=string;
	}
	
	@Override
	public boolean isValidPosition(int initXPosition, int initYPosition, int finalXPosition, int finalYPosition) {
		// TODO Auto-generated method stub
		return false;
	}
}
