/**
 * 
 */
/**
 * @author Shrema Singh
 *
 */

package com.accolite.assignment2.chess;

// TODO: Auto-generated Javadoc
/**
 * The Class ChessGame.
 */
public class ChessGame{
	
	/** The pos. */
	chessPosition pos[][]=new chessPosition[8][8];
	
	/**
	 * Instantiates a new chess game.
	 */
	public ChessGame() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				this.pos[i][j]=new chessPosition(i,j);
			}
		}
		
		
	}
	
	/**
	 * Initialize board at beg.
	 */
	public void initializeBoardAtBeg()
	{
		
		for(int i=0;i<8;i++)
		{
			pos[1][i].piece=new piecePawn(1,i,true,"black");
			pos[6][i].piece=new piecePawn(1,i,true,"white");
		}
		pos[0][0].piece=new pieceRook(0,0,true,"black");
		pos[0][7].piece=new pieceRook(0,7,true,"black");
		pos[7][0].piece=new pieceRook(7,0,true,"white");
		pos[7][7].piece=new pieceRook(7,7,true,"white");
		pos[0][1].piece=new pieceKnight(0,1,true,"black");
		pos[0][6].piece=new pieceKnight(0,6,true,"black");
		pos[7][1].piece=new pieceKnight(0,1,true,"white");
		pos[7][6].piece=new pieceKnight(0,1,true,"white");
		pos[0][2].piece=new pieceBishop(0,2,true,"black");
		pos[0][5].piece=new pieceBishop(0,5,true,"black");
		pos[7][2].piece=new pieceBishop(7,2,true,"white");
		pos[7][5].piece=new pieceBishop(7,5,true,"white");
		pos[0][3].piece=new pieceQueen(0,3,true,"black");
		pos[7][3].piece=new pieceQueen(7,3,true,"white");
		pos[0][4].piece=new pieceKing(0,4,true,"black");
		pos[7][4].piece=new pieceKing(7,4,true,"white");
		
		
	}
	
	/**
	 * Gets the pos.
	 *
	 * @return the pos
	 */
	public chessPosition[][] getPos() {
		return pos;
	}
	
	/** The Player 1. */
	chessPlayer Player1=new chessPlayer("white");
	
	/** The Player 2. */
	chessPlayer Player2=new chessPlayer("black");
		
		/** The turn. */
		int turn=0;
		
		/**
		 * Decide turn.
		 */
		public void decideTurn()
		{
		if(turn%2==0)
			{
			Player1.playgame();
			turn++;
			}
		else
			Player2.playgame();
		}
		
		/**
		 * Gets the result.
		 *
		 * @return the result
		 */
		public void getResult()
		{
			if(Player1.checkmate())
				System.out.println("Player1 wins");
			else if(Player2.checkmate())
				System.out.println("Player2 wins");
				else
					System.out.println("DRAW");
		}
		
		/**
		 * Gets the status at A point.
		 *
		 * @return the status at A point
		 */
		public void getStatusAtAPoint()
		{
			
		}
}

