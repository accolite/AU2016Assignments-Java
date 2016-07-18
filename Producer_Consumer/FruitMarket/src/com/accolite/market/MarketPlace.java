/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.market;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class MarketPlace.
 * Represents the market where farmers add fruits and
 * consumers buy fruits
 */
public class MarketPlace {
	
	/** The apple queue*/
	BlockingQueue<String> apple;
	
	/** The orange  queue*/
	BlockingQueue<String> orange;
	
	/** The grape  queue*/
	BlockingQueue<String> grape;
	
	/** The watermelon queue*/
	BlockingQueue<String> watermelon;
	
	/**
	 * Instantiates a new market place.
	 *
	 * @param apple the apple queue size
	 * @param orange the orange queue size
	 * @param grape the grape queue size
	 * @param watermelon the watermelon queue size
	 */
	MarketPlace(int apple,int orange,int grape,int watermelon){
		this.apple = new ArrayBlockingQueue<String>(apple);
		this.orange = new ArrayBlockingQueue<String>(orange);
		this.grape = new ArrayBlockingQueue<String>(grape);
		this.watermelon = new ArrayBlockingQueue<String>(watermelon);
	}
}
