package fruitmarket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StoreHouse 
{
	public BlockingQueue<Apple> AppleCrate = new ArrayBlockingQueue<Apple>(10);
	public BlockingQueue<Grape> GrapeCrate = new ArrayBlockingQueue<Grape>(10);
	public BlockingQueue<Orange> OrangeCrate = new ArrayBlockingQueue<Orange>(10);
	public BlockingQueue<Watermelon> WatermelonCrate = new ArrayBlockingQueue<Watermelon>(10);

	
}
