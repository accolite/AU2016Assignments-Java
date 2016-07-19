/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 7, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.assignment2;

public class ChessBoard extends ChessGame{

	int board[][][]=new int[8][8][2];//2 represnts for two players 
	
	/**
	 * Instantiates a new chess board.
	 */
	ChessBoard()
	{
		for(int i=0;i<8;i++)
		{
			board[0][i][0]=1;
			board[0][i][1]=0;//For the first player
			
			board[1][i][0]=1;
			board[0][i][1]=0;
			
		
			board[6][i][0]=1;
			board[6][i][1]=1;
		
			board[7][i][0]=1;
			board[7][i][1]=1;
			
		}
	}
	
}
