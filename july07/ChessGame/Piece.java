/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 7, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.chessgame;

// TODO: Auto-generated Javadoc
/**
 * The Class Piece.
 */
public abstract class Piece {
	
	/** The position. */
	Square square;
	
	/** The points. */
	Integer points;
	
	/** The belongs to player variable. */
	short belongsTo;
	
	/* If the particular piece belongs to the same player */
	boolean isValidMove(short player, Square startPosition){
		return ((player^getPiece(startPosition).belongsTo)==0);
	}
	
	/* For all pieces, try if piece belongs to same player */ 
	boolean move(short player, String startPosition, String endPosition){
		return isValidMove(player, getSquare(startPosition));
	}
	
	/* For different kinds of pieces, check validity */
	abstract boolean checkCustomMove();
	
	/* Set Square of Piece */
	void setSquare(Square square){
		this.square = square;
	}
	
	/* Get Square of Piece */
	Square getSquare(){
		return square;
	}
	
	/* Get square of particular position */
	Square getSquare(String position){
		short column = (short) ((short)position.charAt(0) - (short)65);
		short row = (short) ((short)position.charAt(1) - (short)48);
		return ChessBoard.squares[row][column];
	}
	
	/* Check if particular piece's been captured */
	Boolean isCaptured(){
		return (this.equals(null));
	}
	
	/* Get piece of particular square */
	Piece getPiece(Square square){
		Piece piece = null;
		boolean checkOver = false;
		int i = 0;
		for(i=0; i<2; i++){
			for(int j = 0; j<8; j++){
				if(square.equals(ChessBoard.player[i].pawns[j].getSquare())){
					piece = ChessBoard.player[i].pawns[j];
					checkOver = true;
					break;
				}
			}
			if(checkOver) break;
			for(int j = 0; j<2; j++){
				if(square.equals(ChessBoard.player[i].rooks[j].getSquare())){
					piece = ChessBoard.player[i].rooks[j];
					checkOver = true;
					break;
				}
				if(square.equals(ChessBoard.player[i].bishops[j].getSquare())){
					piece = ChessBoard.player[i].bishops[j];
					checkOver = true;
					break;
				}
				if(square.equals(ChessBoard.player[i].knights[j].getSquare())){
					piece = ChessBoard.player[i].knights[j];
					checkOver = true;
					break;
				}
			}
			if(checkOver) break;
			if(square.equals(ChessBoard.player[i].queen.getSquare())){
				piece = ChessBoard.player[i].queen;
				checkOver = true;
				break;
			}
			if(checkOver) break;
			if(square.equals(ChessBoard.player[i].king.getSquare())){
				piece = ChessBoard.player[i].king;
				checkOver = true;
				break;
			}
		}
		return piece;
	}
	
}
