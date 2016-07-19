/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 7, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.chessassignment;

// TODO: Auto-generated Javadoc
/**
 * The Class ChessMan.
 *
 * @author Momin Yadav
 */
public class ChessMan extends Player{

	/** The availability. */
	boolean availability;
	
	/** The y 1. */
	int x1,y1;//This represents the current position of piece according to matrix
	
	/**
	 * Checks if is available.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @return true, if is available
	 */
	boolean isAvailable(int x1,int y1)
	{
		return this.availability ;
	}
	
	/**
	 * Sets the available.
	 */
	void setAvailable()
	{
		this.availability=true;
	}
	
	/**
	 * Removes the.
	 */
	void remove()
	{
		this.availability=false;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	int getX()
	{
		return this.x1;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	int getY()
	{
		return this.y1;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x1 the new x
	 */
	void setX(int x1)
	{
		this.x1=x1;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y1 the new y
	 */
	void setY(int y1)
	{
		this.y1=y1;
	}
	
	/**
	 * Valid move.
	 *
	 * @param x2 the x 2
	 * @param y2 the y 2
	 * @return true, if successful
	 */
	boolean validMove(int x2,int y2)//Position where it is to be moved should not be out of bounds
	{
		if(x2>=0&&y2>=0&&x2<=7&&y2<=7&&(!(x2==this.x1&&y2==this.y1)))
			return true;
		return false;
	}
	
}
