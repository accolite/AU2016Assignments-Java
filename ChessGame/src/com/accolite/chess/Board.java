/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 7, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.chess;

// TODO: Auto-generated Javadoc
/**
 * The Class Board.
 */
public class Board {
	
	/** The board. */
	Square[][] board=new Square[8][8];

	/**
	 * Instantiates a new board.
	 */
	public Board() {
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				this.board[i][j] = new Square((char)(i+65)+""+(j+1));
		
		
	}
	
}
