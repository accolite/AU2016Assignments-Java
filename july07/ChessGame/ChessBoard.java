/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 7, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.chessgame;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ChessBoard.
 */
public class ChessBoard {
	
	/** The game over condition. */
	public static boolean gameOver = false;
	
	/** The players. */
	static Player player[] = new Player[2];
	
	/** The squares. */
	static Square squares[][] = new Square[8][8];
	
	/**
	 * Instantiates a new chess board.
	 */
	public ChessBoard(){

		/*Initialize players*/
		player[0] = new Player((short)0);
		player[1] = new Player((short)1);
		
		player[0].setColor("White");
		player[1].setColor("Black");
		
		/*Initialize square positions*/
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				squares[i][j] = new Square();
				squares[i][j].setPosition((char)(j+65)+""+(i+1));
			}
		}
		
		/*Initialize piece position for players*/
		
		/*White player*/
		player[0].king.setSquare(squares[0][4]);
		player[0].queen.setSquare(squares[0][3]);
		player[0].bishops[0].setSquare(squares[0][2]);
		player[0].knights[0].setSquare(squares[0][1]);
		player[0].rooks[0].setSquare(squares[0][0]);
		player[0].bishops[1].setSquare(squares[0][5]);
		player[0].knights[1].setSquare(squares[0][6]);
		player[0].rooks[1].setSquare(squares[0][7]);
		for(int i=0;i<8;i++){
			player[0].pawns[i].setSquare(squares[1][i]);
		}
		
		/*Black player*/
		player[1].king.setSquare(squares[7][4]);
		player[1].queen.setSquare(squares[7][3]);
		player[1].bishops[0].setSquare(squares[7][2]);
		player[1].knights[0].setSquare(squares[7][1]);
		player[1].rooks[0].setSquare(squares[7][0]);
		player[1].bishops[1].setSquare(squares[7][5]);
		player[1].knights[1].setSquare(squares[7][6]);
		player[1].rooks[1].setSquare(squares[7][7]); 
		for(int i=0;i<8;i++){
			player[1].pawns[i].setSquare(squares[6][i]);
		}
		
	}
	
	/* Try the move in board, call move after getting piece */
	
	void tryMove(short player, String startPosition, String endPosition){
		
	}
	
	/* Check game */
	public static void main(String[] args){
		ChessBoard board = new ChessBoard();
		short player = 0;
		Scanner input = new Scanner(System.in);
		String startPosition,endPosition;
		while(!ChessBoard.gameOver){
			System.out.println("Player "+board.player[player].getColor());
			System.out.println("Start Position");
			startPosition = input.next();
			System.out.println("End Position");
			endPosition = input.next();
			
		}
	}
}
