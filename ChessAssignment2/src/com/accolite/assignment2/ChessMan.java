/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 7, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.assignment2;

public class ChessMan extends Player{

	boolean availability;
	int x1,y1;//This represents the current position of piece according to matrix
	
	boolean isAvailable(int x1,int y1)
	{
		return this.availability ;
	}
	void setAvailable()
	{
		this.availability=true;
	}
	void remove()
	{
		this.availability=false;
	}
	int getX()
	{
		return this.x1;
	}
	int getY()
	{
		return this.y1;
	}
	void setX(int x1)
	{
		this.x1=x1;
	}
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
