/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package fruitmarket;

import java.util.Random;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 */
public class Customer extends StoreHouse implements Runnable
{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() 
	{
			Scanner in = new Scanner( System.in );
			System.out.println("Enter quantities of the fruits to be consumed : 1) Apple 2) Orange 3) Grape 4) Watermelon");
			int apple = in.nextInt();
			int orange = in.nextInt();
			int grape = in.nextInt();
			int watermelon = in.nextInt();
			
			for( int b = 0; b < apple; b++ )
			{
				if( !AppleCrate.isEmpty() )
				{
					AppleCrate.remove( );
					System.out.println("Consumer consumed 1 apple");
				}
				else
				{
					System.out.println("AppleCrate is empty");
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			
			for( int b = 0; b < orange; b++ )
			{
				if( !OrangeCrate.isEmpty() )
				{
					OrangeCrate.remove( );
					System.out.println("Consumer consumed 1 orange");
				}
				else
				{
					System.out.println("OrangeCrate is empty");
					try 
					{
						Thread.sleep(1000);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					break;
				}
			}
				
			for( int b = 0; b < grape; b++ )
			{
				if( !GrapeCrate.isEmpty() )
				{
					GrapeCrate.remove( );
					System.out.println("Consumer consumed 1 Grape");
				}
				else
				{
					System.out.println("GrapeCrate is empty");
					try 
					{
						Thread.sleep(1000);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					break;
				}
			}
			
			for( int b = 0; b < watermelon; b++ )
			{
				if( !WatermelonCrate.isEmpty())
				{
					WatermelonCrate.remove( );
					System.out.println("Consumer consumed 1 watermelon");
				}
				else
				{
					System.out.println("WatermelonCrate is empty");
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					break;
				}
			}
	}
}
