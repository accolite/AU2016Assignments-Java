/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package fruitmarket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHouse.
 */
public class StoreHouse 
{
	
	/** The Apple crate. */
	public static BlockingQueue<Apple> AppleCrate = new ArrayBlockingQueue<Apple>(5);
	
	/** The Grape crate. */
	public static BlockingQueue<Grape> GrapeCrate = new ArrayBlockingQueue<Grape>(5);
	
	/** The Orange crate. */
	public static BlockingQueue<Orange> OrangeCrate = new ArrayBlockingQueue<Orange>(5);
	
	/** The Watermelon crate. */
	public static BlockingQueue<Watermelon> WatermelonCrate = new ArrayBlockingQueue<Watermelon>(5);

	
}
