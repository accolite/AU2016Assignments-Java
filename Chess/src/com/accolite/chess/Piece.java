package com.accolite.chess;

import java.util.List;

public abstract class Piece {
	
	private String name;
	private Position position;
	private Color color;
	private PieceStatus pieceStatus;
	
	public abstract List<Position>moves();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public PieceStatus getPieceStatus() {
		return pieceStatus;
	}
	public void setPieceStatus(PieceStatus pieceStatus) {
		this.pieceStatus = pieceStatus;
	}

	public Piece(String name, Position position, Color color, PieceStatus pieceStatus) {
		super();
		this.name = name;
		this.position = position;
		this.color = color;
		this.pieceStatus = pieceStatus;
	}
	

}
