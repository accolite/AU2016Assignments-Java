package com.accolite.chessgame;

public class ChessBoard
{
	private Block[][] square = new Block[8][8];
	
	public void setBoard() // Initialize the board with pieces
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				square[i][j] = new Block(i,j);
			}
			
		}
		 
		
		square[0][4].setPiece(new King(true,0,4,Color.BLACK));
		square[0][3].setPiece(new Queen(true,0,3,Color.BLACK));
		square[0][2].setPiece(new Bishop(true,0,2,Color.BLACK));
		square[0][2].setPiece(new Bishop(true,0,6,Color.BLACK));
		
		for(int n =0;n<8;n++)
		{
			square[1][n].setPiece(new Pawn(true,1,n,Color.BLACK));
		}
		
		square[0][0].setPiece(new Rook(true,0,0,Color.BLACK));
		square[0][7].setPiece(new Rook(true,0,7,Color.BLACK));
		
		square[0][1].setPiece(new Knight(true,0,1,Color.BLACK));
		square[0][6].setPiece(new Knight(true,0,6,Color.BLACK));
		
		square[7][4].setPiece(new King(true,7,4,Color.WHITE));
		square[7][3].setPiece(new Queen(true,7,3,Color.WHITE));
		square[7][2].setPiece(new Bishop(true,7,2,Color.WHITE));
		square[7][2].setPiece(new Bishop(true,7,6,Color.WHITE));
		
		for(int n=0;n<8;n++)
		{
			square[6][n].setPiece(new Pawn(true,6,n,Color.WHITE));
		}
		
		square[7][0].setPiece(new Rook(true,7,0,Color.WHITE));
		square[7][7].setPiece(new Rook(true,7,7,Color.WHITE));
		
		square[7][1].setPiece(new Knight(true,7,1,Color.WHITE));
		square[7][6].setPiece(new Knight(true,7,6,Color.WHITE));
	}

	public void updateBoard()
	{
		//write the code for updated positions
	}
}
