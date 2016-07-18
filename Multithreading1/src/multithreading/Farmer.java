package multithreading;
import java.util.concurrent.BlockingQueue;

public class Farmer implements Runnable {
	BlockingQueue Apple = null;
	BlockingQueue Orange = null;
	BlockingQueue Watermelon = null;
	BlockingQueue Grape = null;
	protected int numberApple,numberOrange,numberWatermelon,numberGrape;
	Farmer(BlockingQueue Apple,BlockingQueue Orange,BlockingQueue Watermelon,BlockingQueue Grape,int numberApple,int numberOrange,int numberWatermelon,int numberGrape ) {
		this.Apple = Apple;
		this.Orange = Orange;
		this.Watermelon = Watermelon;
		this.Grape = Grape;
		this.numberApple = numberApple;
		this.numberOrange = numberOrange;
		this.numberWatermelon = numberWatermelon;
		this.numberGrape = numberGrape;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i,item;
		for(i=1;i<=this.numberApple;i++)
		{
			try{
				 item=(int)Apple.size();
				if(item <10)
				{
					Apple.put(i);
					System.out.println("Produced Apple: " + Apple.peek());
					Thread.sleep(100);

				}
				else
					System.out.println("Excessive Apple");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(i=1;i<=this.numberOrange;i++)
		{
			try{
				item=(int)Orange.size();
				if(item<5)
				{
					Orange.put(i);
					System.out.println("Produced Orange: " + Orange.peek());
					Thread.sleep(100);

				}
				else
					System.out.println("Excessive Orange");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(i=1;i<=this.numberWatermelon;i++)
		{
			try{
				item=(int)Watermelon.size();
				if(item<5)
				{
					Watermelon.put(i);
					System.out.println("Produced Watermelon: " + Watermelon.peek());
					Thread.sleep(100);

				}
				else
					System.out.println("Excessive Watermelon");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(i=1;i<=this.numberGrape;i++)
		{
			try{
				item=(int)Grape.size();
				if(item<5)
				{
					Grape.put(i);
					System.out.println("Produced Grape: " + Grape.peek());
					Thread.sleep(100);

				}
				else
					System.out.println("Excessive Grape");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
