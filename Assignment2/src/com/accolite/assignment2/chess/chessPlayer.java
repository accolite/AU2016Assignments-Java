package com.accolite.assignment2.chess;

import java.util.Scanner;

public class chessPlayer {
String color;
	public chessPlayer(String string) {
		// TODO Auto-generated constructor stub
		this.color=string;
		
	}
	
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
	public boolean checkmate()
	{
		boolean b=false;
		return b;
	}

}
