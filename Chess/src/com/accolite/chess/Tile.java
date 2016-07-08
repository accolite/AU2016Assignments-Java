package com.accolite.chess;

public class Tile {

	private Position position;
	private Color color;
	private Piece piece = null;
	
	public Tile(Position position, Color color) {
		super();
		this.position = position;
		this.color = color;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
