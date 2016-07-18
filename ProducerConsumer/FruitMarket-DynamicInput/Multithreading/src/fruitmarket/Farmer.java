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
 * The Class Farmer.
 */
public class Farmer extends StoreHouse implements Runnable
{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() 
	{
			Scanner in = new Scanner( System.in );
			System.out.println("Enter quantities of the fruits to be produced : 1) Apple 2) Orange 3) Grape 4) Watermelon");
			int apple = in.nextInt();
			int orange = in.nextInt();
			int grape = in.nextInt();
			int watermelon = in.nextInt();
			
			for( int b = 0; b < apple; b++ )
			{
				if( AppleCrate.size() < 5 )
				{
					AppleCrate.add( new Apple() );
					System.out.println("Farmer added 1 apple");
				}
				else
				{
					System.out.println("AppleCrate is full");
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
			
			for( int b = 0; b < orange; b++ )
			{
				if( OrangeCrate.size() < 5 )
				{
					OrangeCrate.add( new Orange() );
					System.out.println("Farmer added 1 orange");
				}
				else
				{
					System.out.println("OrangeCrate is full");
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
				
			for( int b = 0; b < grape; b++ )
			{
				if( GrapeCrate.size() < 5 )
				{
					GrapeCrate.add( new Grape() );
					System.out.println("Farmer added 1 Grape");
				}
				else
				{
					System.out.println("GrapeCrate is full");
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
			
			for( int b = 0; b < watermelon; b++ )
			{
				if( WatermelonCrate.size() < 5 )
				{
					WatermelonCrate.add( new Watermelon() );
					System.out.println("Farmer added 1 watermelon");
				}
				else
				{
					System.out.println("WatermelonCrate is full");
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
