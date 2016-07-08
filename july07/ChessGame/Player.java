/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 7, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.chessgame;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {
	
	/** The color. */
	String color;
	
	/** The points. */
	Integer points;
	
	/** The king. */
	KingPiece king;
	
	/** The queen. */
	QueenPiece queen;
	
	/** The bishops. */
	BishopPiece bishops[] = new BishopPiece[2];
	
	/** The knights. */
	KnightPiece knights[] = new KnightPiece[2];
	
	/** The rooks. */
	RookPiece rooks[] = new RookPiece[2];
	
	/** The pawns. */
	PawnPiece pawns[] = new PawnPiece[8];
	
	/**
	 * Instantiates a new player.
	 */
	public Player(short belongsTo){
		king = new KingPiece(belongsTo);
		queen = new QueenPiece(belongsTo);
		for(int i=0;i<2;i++){
			bishops[i] = new BishopPiece(belongsTo);
			knights[i] = new KnightPiece(belongsTo);
			rooks[i] = new RookPiece(belongsTo);
		}
		for(int i=0;i<8;i++){
			pawns[i] = new PawnPiece(belongsTo);
		}
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}
	
	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
