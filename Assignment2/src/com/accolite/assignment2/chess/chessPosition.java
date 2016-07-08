/**
 * 
 */
package com.accolite.assignment2.chess;

/**
 * @author Shrema Singh
 *
 */
public class chessPosition {
	int x;
	int y;
	ChessPiece piece;
// to check if empty position
	chessPosition(int i, int j)
	{
		x=i;y=j;piece=null;
	}
	public boolean isPositionEmpty(chessPosition p)
	{
		if(p.piece==null)
			return true;
		else
			return false;
	}
	//to move to a position
	public void occupyPosition(ChessPiece piece,chessPosition poss)
	{
		if(isPositionEmpty(poss))
		{
		piece.x=poss.x;
		piece.y=poss.y;
		piece.statusOfPiece=true;
		poss.piece=piece;
	}
	}
		public void leavePosition(ChessPiece piece ,chessPosition poss)
		{
			poss.piece=null;
		}
		
	}

