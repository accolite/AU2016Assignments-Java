/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 7, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.assignment2;

public class Player extends ChessBoard{

	int player;
	Pawn pawn[]=new Pawn[8];
	Knight knight[]=new Knight[2];
	King king;
	Queen queen;
	Bishop bishop[]=new Bishop[2];
	Rook rook[]=new Rook[2];
	
	/**
	 * Instantiates a new player.
	 *
	 * @param player the player
	 */
	Player(int player)
	{
		this.player=player;
		if(this.player==0)
		{
			for(int i=0;i<8;i++)
			{
				this.pawn[i].setX(1);
				this.pawn[i].setY(i);
				
			}
			this.knight[0].setX(0);
			this.knight[0].setY(1);
			this.bishop[0].setX(0);
			this.bishop[0].setY(2);
			this.queen.setX(0);
			this.queen.setY(3);
			this.king.setX(0);
			this.king.setY(4);
			this.bishop[1].setX(0);
			this.bishop[1].setY(5);
			this.knight[1].setX(0);
			this.knight[1].setY(6);
			this.rook[0].setX(0);
			this.rook[0].setY(0);
			this.rook[1].setX(0);
			this.rook[1].setY(7);
						
		}
		else 
		{
			for(int i=0;i<8;i++)
			{
				this.pawn[i].setX(6);
				this.pawn[i].setY(i);
				
			}
			this.knight[0].setX(7);
			this.knight[0].setY(1);
			this.bishop[0].setX(7);
			this.bishop[0].setY(2);
			this.queen.setX(7);
			this.queen.setY(3);
			this.king.setX(7);
			this.king.setY(4);
			this.bishop[1].setX(7);
			this.bishop[1].setY(5);
			this.knight[1].setX(7);
			this.knight[1].setY(6);
			this.rook[0].setX(7);
			this.rook[0].setY(0);
			this.rook[1].setX(7);
			this.rook[1].setY(7);
			
		}
	}
	
}
