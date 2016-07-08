package com.accolite.chessgame;

import java.util.Scanner;

public class PlayGame {
	
	private ChessBoard board = new ChessBoard();
	private Player black;
	private Player white;
	
	public ChessBoard getBoard() {
		return board;
	}


	public void setBoard(ChessBoard board) {
		this.board = board;
	}


	public Player getBlack() {
		return black;
	}


	public void setBlack(Player black) {
		this.black = black;
	}


	public Player getWhite() {
		return white;
	}


	public void setWhite(Player white) {
		this.white = white;
	}
	
	public void updateBoard()
	{
		//Update new positions of Pieces here
	}
	
	Move move = new Move();

	public void play()
	{
		//Player chooses a piece to move
		//Piece will make legal move
		
		System.out.println("Choose the piece you want to move:");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		
		Block block = new Block(x,y);
		Piece piece=block.getPiece();
		
		int toX = in.nextInt();
		int toY = in.nextInt();
		
		boolean value=piece.valid(board,x,toX,y,toY); // This will take the code to the desired piece class and will check validity of move
	
		
		if(value==true) // If it is a valid move it will update the board
		{
			ChessBoard board1 = new ChessBoard();
			board1.updateBoard();
		}
		
		
		
	}

	public void checkmate()
	{
		
	}
	
	public void draw()
	{
		
	}
	
	public void lose()
	{
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		// Initialize the Chess Board
		ChessBoard board = new ChessBoard();
		board.setBoard();
		Player player = new Player();
		player.PlayTurn();

	}

}
