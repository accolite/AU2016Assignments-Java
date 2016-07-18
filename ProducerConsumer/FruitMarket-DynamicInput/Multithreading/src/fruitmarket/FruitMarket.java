/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package fruitmarket;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class FruitMarket.
 */
public class FruitMarket  {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException 
	{			
		Thread Farmer = new Thread( new Farmer() );
		Thread Customer = new Thread( new Customer() );
		Scanner in = new Scanner( System.in );
		int choice;
		while( true )
		{
			System.out.println("1) Farmer or 2)Customer");
			choice = in.nextInt();
			if( choice == 1 )
			{
				Farmer.start();
				Farmer.join();
			}
			else if( choice == 2 )
			{
				Customer.start();
				Customer.join();
			}
			else
				return;
		}
	}

}
