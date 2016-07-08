package com.accolite.chessgame;

public class Player 
{
	public int king=1;
	public int queen=1;
	public int rook=2;
	public int bishop=2;
	public int knight=2;
	public int pawn=8;
	public String color;
	
	PlayGame game = new PlayGame();
	
	public void PlayTurn()
	{
		game.play();  // By default , white player is given first chance and then alternate and then play is called.
	}
	
	

}
