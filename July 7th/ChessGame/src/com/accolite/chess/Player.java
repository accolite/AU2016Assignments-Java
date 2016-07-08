/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 7, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.chess;

public class Player {
	String player_color;
	//Integer player_points;
	King king;
	Queen queen;
	Bishop[] bishop=new Bishop[2];
	Knight[] knight=new Knight[2];
	Rook[] rook=new Rook[2];
	
	/** The pawn. */
	Pawn[] pawn=new Pawn[8];
	char start='a';

	public Player(String player_color){
		this.player_color=player_color;
		if(this.player_color == "white"){
			king=new King(new Square("e1",true));
			queen=new Queen(new Square("d1",true));
			bishop[0]=new Bishop(new Square("c1",true));
			bishop[1]=new Bishop(new Square("f1",true));
            knight[0]=new Knight(new Square("b1",true));
            knight[1]=new Knight(new Square("g1",true));
            rook[0]=new Rook(new Square("a1",true));
            rook[1]=new Rook(new Square("h1",true));
            for(int i=0;i<8;i++){
            	pawn[i]=new Pawn(new Square((char)(i+65)+"2",true));
            }
		}
        else{
        	king=new King(new Square("e8",true));
			queen=new Queen(new Square("d8",true));
			bishop[0]=new Bishop(new Square("c8",true));
			bishop[1]=new Bishop(new Square("f8",true));
            knight[0]=new Knight(new Square("b8",true));
            knight[1]=new Knight(new Square("g8",true));
            rook[0]=new Rook(new Square("a8",true));
            rook[1]=new Rook(new Square("h8",true));
            for(int i=0;i<8;i++){
            	pawn[i]=new Pawn(new Square((char)(i+65)+"7",true));
            }
    }
	}
	
/*	public void Move(Square from,Square to){
		//Moves the piece
	}
	
	public boolean contains(Piece piece){
		//checks whether the player contains the piece
	}
	*/
}
