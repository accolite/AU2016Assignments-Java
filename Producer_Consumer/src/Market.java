import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Market {

	public BlockingQueue<Apple> apples = new ArrayBlockingQueue<Apple>(5);
	public BlockingQueue<Grape> grapes = new ArrayBlockingQueue<Grape>(5);
	public BlockingQueue<Orange> oranges = new ArrayBlockingQueue<Orange>(5);
	public BlockingQueue<Watermelon> watermelons = new ArrayBlockingQueue<Watermelon>(5);
	
	public void addApple() throws InterruptedException{
		apples.put(new Apple());
		System.out.println("Adding Apple");
	}
	
	public void addGrape() throws InterruptedException{
		grapes.put(new Grape());
		System.out.println("Adding Grape");
	}
	
	public void addOrange() throws InterruptedException{
		oranges.add(new Orange());
		System.out.println("Adding Orange");
	}
	
	public void addWatermelon() throws InterruptedException{
		watermelons.add(new Watermelon());
		System.out.println("Adding Watermelon");
	}
	
	public void removeApple() throws InterruptedException{
		apples.take();
		System.out.println("Removing Apple");
	}
	
	public void removeGrape() throws InterruptedException{
		grapes.take();
		System.out.println("Removing Grape");
	}
	
	public void removeOrange() throws InterruptedException{
		oranges.take();
		System.out.println("Removing Orange");
	}
	
	public void removeWatermelon() throws InterruptedException{
		watermelons.take();
		System.out.println("Removing Watermelon");
	}
}
