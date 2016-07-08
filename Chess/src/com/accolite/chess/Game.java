package com.accolite.chess;

import java.util.ArrayList;
import java.util.List;

import com.accolite.chess.pieces.Bishop;
import com.accolite.chess.pieces.King;
import com.accolite.chess.pieces.Knight;
import com.accolite.chess.pieces.Pawn;
import com.accolite.chess.pieces.Queen;
import com.accolite.chess.pieces.Rook;

public class Game {
	
	private Tile[][] board = new Tile[8][8];
	public static final int NUM_ROWS = 8;
	public static final int NUM_COLS = 8;
	private Player player1;
	private Player player2;
	
	private Tile getTileAtPosition(Position position){
		return board[position.getX()][position.getY()];
	}
	
	private void initGame() {
		player1 = new Player(Color.WHITE);
		player2 = new Player(Color.BLACK);
		initBoard();
	}
	private void initBoard(){
		
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				Position position = new Position(i,j);
				board[i][j] = new Tile(position,((i+j)%2==0)?Color.WHITE:Color.BLACK);
			}
		}
		fillBoardWithPieces();
	}
	
	private void fillBoardWithPieces(){
		board[0][0].setPiece(new Rook(  "Rook"   ,new Position(0,0),Color.BLACK,PieceStatus.ALIVE));
		board[0][1].setPiece(new Knight("Knight" ,new Position(0,1),Color.BLACK,PieceStatus.ALIVE));
		board[0][2].setPiece(new Bishop("Bishop" ,new Position(0,2),Color.BLACK,PieceStatus.ALIVE));
		board[0][3].setPiece(new King(  "King"   ,new Position(0,3),Color.BLACK,PieceStatus.ALIVE));
		board[0][4].setPiece(new Queen( "Queen"  ,new Position(0,4),Color.BLACK,PieceStatus.ALIVE));
		board[0][5].setPiece(new Bishop("Bishop" ,new Position(0,5),Color.BLACK,PieceStatus.ALIVE));
		board[0][6].setPiece(new Knight("Knight" ,new Position(0,6),Color.BLACK,PieceStatus.ALIVE));
		board[0][7].setPiece(new Rook(  "Rook"   ,new Position(0,7),Color.BLACK,PieceStatus.ALIVE));
		
		for (int i = 0; i < NUM_ROWS ; i++) {
			board[1][i].setPiece(new Pawn("Pawn" ,new Position(1,i),Color.BLACK,PieceStatus.ALIVE));
		}
		
		board[7][0].setPiece(new Rook(  "Rook"   ,new Position(7,0),Color.WHITE,PieceStatus.ALIVE));
		board[7][1].setPiece(new Knight("Knight" ,new Position(7,1),Color.WHITE,PieceStatus.ALIVE));
		board[7][2].setPiece(new Bishop("Bishop" ,new Position(7,2),Color.WHITE,PieceStatus.ALIVE));
		board[7][3].setPiece(new Queen( "Queen"  ,new Position(7,3),Color.WHITE,PieceStatus.ALIVE));
		board[7][4].setPiece(new King(  "King"   ,new Position(7,4),Color.WHITE,PieceStatus.ALIVE));
		board[7][5].setPiece(new Bishop("Bishop" ,new Position(7,5),Color.WHITE,PieceStatus.ALIVE));
		board[7][6].setPiece(new Knight("Knight" ,new Position(7,6),Color.WHITE,PieceStatus.ALIVE));
		board[7][7].setPiece(new Rook(  "Rook"   ,new Position(7,7),Color.WHITE,PieceStatus.ALIVE));
		
		for (int i = 0; i < NUM_COLS ; i++) {
			board[6][i].setPiece(new Pawn("Pawn" ,new Position(6,i),Color.WHITE,PieceStatus.ALIVE));
		}	
		
	}
	
	public void makeAMove(Player player, Position initialPos, Position finalPos){
		Piece piece = board[initialPos.getX()][initialPos.getY()].getPiece();
		List<Position> moves = piece.moves();
		List<Position> validMoves = new ArrayList<Position>();
		for (Position position : moves) {
			// TODO Check Validity of moves
			if(getTileAtPosition(position).getPiece() == null)
				validMoves.add(position);
		}
		
		if(validMoves.contains(finalPos)){
			System.out.println("Game is on");
			if (piece instanceof Pawn) {

			} else if (piece instanceof Rook) {
				
			} else if (piece instanceof Bishop) {
				
			} else if (piece instanceof Knight) {
				
			} else if (piece instanceof Queen) {
				
			} else if (piece instanceof King) {
				
			}
			
		} else {
			// TODO Unsuccessful Move Prompt the user for one more input
			System.out.println("Damn");
		}
		
	}
	
	public void displayBoard() {
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				Piece piece = board[i][j].getPiece(); 
				if( piece != null){
					System.out.print((piece.getColor() == Color.BLACK)? piece.getName().toLowerCase().charAt(0):piece.getName().charAt(0));
				}
				else
				{
//					System.out.print(board[i][j].getColor() == Color.BLACK?"o":"O");
					System.out.print("o");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		 Game g = new Game();
		 g.initGame();
		 g.displayBoard();
		
		 System.out.println(g.board[6][2].getPiece().getName() + " " + g.board[6][2].getPiece().getColor());
		 System.out.println(g.board[6][2].getPiece().moves());
		 g.makeAMove(g.player1, new Position(1,0), new Position(3,0));
	}
	

}
