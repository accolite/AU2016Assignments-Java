package fruitmarket;

import java.util.Random;

public class Customer extends StoreHouse implements Runnable
{
	public Random rand = new Random();
	@Override
	public void run() 
	{
		System.out.println("Consumer has randomly started consuming apples, oranges, grapes and watermelons");
		while( true )
		{
			try 
			{
				java.lang.Thread.sleep( rand.nextInt(1000) );
				int i = rand.nextInt(4);
				switch( i )
				{
					case 0:
						if( !AppleCrate.isEmpty())
							AppleCrate.remove();
						System.out.println("Consumer ate an apple");
						break;
					case 1:
						if( !OrangeCrate.isEmpty())
							OrangeCrate.remove();
						System.out.println("Consumer ate an orange");
						break;
					case 2:
						if( !GrapeCrate.isEmpty())
							GrapeCrate.remove();
						System.out.println("Consumer ate a Grape");
						break;
					case 3:
						if( !WatermelonCrate.isEmpty())
							WatermelonCrate.remove();
						System.out.println("Consumer ate a watermelon");
						break;
					default:
						System.out.println("Consumer ate an unknown fruit");
						return;
				}
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Customer has nothing to consume");
			}
		}
	 }
}
