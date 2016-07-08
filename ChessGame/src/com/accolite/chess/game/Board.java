package com.accolite.chess.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accolite.chess.pieces.Bishop;
import com.accolite.chess.pieces.King;
import com.accolite.chess.pieces.Knight;
import com.accolite.chess.pieces.Pawn;
import com.accolite.chess.pieces.Piece;
import com.accolite.chess.pieces.Queen;
import com.accolite.chess.pieces.Rook;
import com.accolite.chess.util.Colors;
import com.accolite.chess.util.Location;

/**
 * Board object of the chess game
 * @author Rajesh R
 *
 */
public class Board {
	
	Map<Location, Square> squares;
	List<Piece> outliars;
	
	public Board(){
		squares = new HashMap<>();
		outliars = new ArrayList<>();
		placePiecesOnBoard();
	}
	
	public void placePiecesOnBoard(){	
		squares.put(new Location(0,0), new Square(Colors.WHITE, new Rook(Colors.BLACK)));
		squares.put(new Location(0,1), new Square(Colors.BLACK , new Knight(Colors.BLACK)));
		squares.put(new Location(0,2), new Square(Colors.WHITE , new Bishop(Colors.BLACK)));
		squares.put(new Location(0,3), new Square(Colors.BLACK , new King(Colors.BLACK)));
		squares.put(new Location(0,4), new Square(Colors.WHITE , new Queen(Colors.BLACK)));
		squares.put(new Location(0,5), new Square(Colors.BLACK , new Bishop(Colors.BLACK)));
		squares.put(new Location(0,6), new Square(Colors.WHITE , new Knight(Colors.BLACK)));
		squares.put(new Location(0,7), new Square(Colors.BLACK , new Rook(Colors.BLACK)));
		for(int i=0; i<8; i+=2){
			squares.put(new Location(1,i), new Square(Colors.BLACK , new Pawn(Colors.BLACK)));
			squares.put(new Location(1,i+1), new Square(Colors.WHITE , new Pawn(Colors.BLACK)));
		}
		int color = Colors.WHITE;
		for(int i=2; i<6; i++){
			for(int j=0; j<8; j++){
				squares.put(new Location(i,j), new Square(color));
				color = color==Colors.WHITE ? Colors.BLACK: Colors.WHITE;
			}
		}
		for(int i=0; i<8; i+=2){
			squares.put(new Location(6,i), new Square(Colors.WHITE , new Pawn(Colors.WHITE)));
			squares.put(new Location(6,i+1), new Square(Colors.BLACK , new Pawn(Colors.WHITE)));
		}
		squares.put(new Location(7,0), new Square(Colors.BLACK, new Rook(Colors.WHITE)));
		squares.put(new Location(7,1), new Square(Colors.WHITE , new Knight(Colors.WHITE)));
		squares.put(new Location(7,2), new Square(Colors.BLACK , new Bishop(Colors.WHITE)));
		squares.put(new Location(7,3), new Square(Colors.WHITE , new Queen(Colors.WHITE)));
		squares.put(new Location(7,4), new Square(Colors.BLACK , new King(Colors.WHITE)));
		squares.put(new Location(7,5), new Square(Colors.WHITE , new Bishop(Colors.WHITE)));
		squares.put(new Location(7,6), new Square(Colors.BLACK , new Knight(Colors.WHITE)));
		squares.put(new Location(7,7), new Square(Colors.WHITE , new Rook(Colors.WHITE)));
	}
	
	public Square getSquare(Location location){
		return squares.get(location);
	}
	
	/**
	 * The target and current position must be a valid position on the board
	 * If the piece is movable, it will move and return true if done
	 * Otherwise will return false
	 * @param player
	 * @param curPos
	 * @param targetPos
	 * @return Moved or not movable
	 */
	public boolean movePiece(Player player, Location curPos, Location targetPos){
		
		Square current = getSquare(curPos);
		
		if(current.isEmpty())
			return false;					// If there is no piece in source, will return false
		
		if(player.getColor()!=current.getPiece().getColor())
			return false;					// Player's color should match the color of the piece, he wants to move
		
		if(!getSquare(curPos).getPiece().canMove(curPos, targetPos))
			return false;					// The current piece cannot be moved to target position
		
		if(!getSquare(targetPos).isEmpty() && getSquare(curPos).getColor()==getSquare(targetPos).getColor())
			return false;					// The target position has the piece of same color
		
		if(!getSquare(targetPos).isEmpty())
			outliars.add(getSquare(targetPos).getPiece());	
		getSquare(targetPos).setPiece(current.getPiece());
		getSquare(curPos).makeEmpty();
		
		return true;
	}
	
	public List<Piece> getOutliars(){
		return outliars;
	}
	
	/*public static void main(String args[]){
		Board b = new Board();
		System.out.println(b.getSquare(new Location(1,1)).isEmpty());
		System.out.println(b.getSquare(new Location(1,1)).getColor());
		System.out.println(b.getSquare(new Location(1,1)).getPiece().getColor());
		System.out.println(b.getSquare(new Location(1,1)).getPiece().getClass());
		//System.out.println(b.getSquare("a1").getPiece().move("a1", "b1"));
			
	}*/
	
	/*public static void main(String[] args) {
		Location l = new Location();
		Location l2 = new Location();
		l.setX(1);
		l.setY(2);
		l2.setX(1);
		l2.setY(2);
		List<Location> list = new ArrayList<>();
		list.add(l);
		if(list.contains(l2))
			System.out.println(true);
		else
			System.out.println(false);
	}*/
	
}
