package com.accolite.chess;

public class player {

		 char color;
		board b = new board();
		
	
		
		position p1,p2;
		player(char s)
		{
			color=s;
			 b.set_board_b();
			 b.set_board_w();
			 b.display();
			
		}
		
		void play()
		{
			System.out.println("enter old position ");
			p1.get();
			System.out.println("enter new position ");
			p2.get();
			if(move_possible(p1,p2))
				change_board(p1,p2);
			
		}
		void change_board(position p1,position p2)
		{
			//changing board
		}
		
		boolean move_possible(position p1,position p2)
		{
			// checking validate move
		}
		
		
		
	

}
