package com.accolite.chess.game;

import com.accolite.chess.util.Colors;
import com.accolite.chess.util.Location;

public class Game {

	Board board;
	Player p1, p2;
	
	public Game(){
		board = new Board();
		p1 = new Player(Colors.BLACK, "Black");
		p2 = new Player(Colors.WHITE, "White");
//		playGame();
		test();
	}
	
	public void test(){
		for(int i=0; i<8 ;i++){
			System.out.println(board.getSquare(new Location(0,i)).getPiece().getClass());
		}
		if(board.movePiece(p1, new Location(0,0), new Location(2,2)))
			System.out.println(board.getSquare(new Location(2,2)).getPiece().getClass());
	}
	
	/*public void playGame(){
		board.movePiece(p1, new Location(1,1), new Location(1,2));
		board.movePiece(p2, new Location(3,1), new Location(3,4));
		board.getOutliars();
	}*/
	
	public static void main(String args[]){
		new Game();
	}
	
}
