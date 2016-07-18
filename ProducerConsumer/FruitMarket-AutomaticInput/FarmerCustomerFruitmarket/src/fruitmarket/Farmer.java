package fruitmarket;

import java.util.Random;

public class Farmer extends StoreHouse implements Runnable
{
	public Random rand = new Random();
	@Override
	public void run() 
	{
		System.out.println("Farmer has started producing Apples, Oranges, Grapes and Watermelons");
		while( true )
		{
			try 
			{
				java.lang.Thread.sleep( rand.nextInt(1000) );
				int i = rand.nextInt(4);
				switch( i )
				{
					case 0:
						AppleCrate.add( new Apple() );
						System.out.println("Farmer added new apple");
						break;
					case 1:
						OrangeCrate.add(new Orange());
						System.out.println("Farmer added new orange");
						break;
					case 2:
						GrapeCrate.add( new Grape() );
						System.out.println("Farmer added new Grape");
						break;
					case 3:
						WatermelonCrate.add( new Watermelon() );
						System.out.println("Farmer added new watermelon");
						break;
					default:
						System.out.println("Farmer has produced some new fruit");
						return;
				}
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Farmer has produced but crates are full");
			}
			
		}
	}
}
