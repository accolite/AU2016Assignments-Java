/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Shrema Singh

* ***************************************************************************

*/
package com.accolite.assignment2.chess;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class chessPlayer.
 */
public class chessPlayer {

/** The color. */
String color;
	
	/**
	 * Instantiates a new chess player.
	 *
	 * @param string the string
	 */
	public chessPlayer(String string) {
		// TODO Auto-generated constructor stub
		this.color=string;
		
	}
	
	/**
	 * Playgame.
	 */
	public void playgame()
	{
		System.out.println("Choose your piece");
		System.out.println("1 for Bishop \n2 for King \n3 for Knight\n 4 for Pawn 5 \nfor Queen\n 6 for rook\n ");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1://Player has decided to move bishop
			pieceBishop piecebishop=new pieceBishop() ;
			boolean isItPossible=piecebishop.moveBishop();
			if(!isItPossible)
			{
				System.out.println("Invalid Movement\n Choose another move\n);
			}
			
		}
		
	}
	
	/**
	 * Checkmate.
	 *
	 * @return true, if successful
	 */
	public boolean checkmate()
	{
		boolean b=false;
		return b;
	}

}
