/**
 * 
 */
package com.accolite.assignment2.chess;

// TODO: Auto-generated Javadoc
/**
 * The Class chessPosition.
 *
 * @author Shrema Singh
 */
public class chessPosition {
	
	/** The x. */
	int x;
	
	/** The y. */
	int y;
	
	/** The piece. */
	ChessPiece piece;

/**
 * Instantiates a new chess position.
 *
 * @param i the i
 * @param j the j
 */
// to check if empty position
	chessPosition(int i, int j)
	{
		x=i;y=j;piece=null;
	}
	
	/**
	 * Checks if is position empty.
	 *
	 * @param p the p
	 * @return true, if is position empty
	 */
	public boolean isPositionEmpty(chessPosition p)
	{
		if(p.piece==null)
			return true;
		else
			return false;
	}
	
	/**
	 * Occupy position.
	 *
	 * @param piece the piece
	 * @param poss the poss
	 */
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
		
		/**
		 * Leave position.
		 *
		 * @param piece the piece
		 * @param poss the poss
		 */
		public void leavePosition(ChessPiece piece ,chessPosition poss)
		{
			poss.piece=null;
		}
		
	}

