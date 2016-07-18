package multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue Apple = null;
	BlockingQueue Orange = null;
	BlockingQueue Watermelon = null;
	BlockingQueue Grape = null;
	protected int numberApple,numberOrange,numberWatermelon,numberGrape;
	Consumer(BlockingQueue Apple,BlockingQueue Orange,BlockingQueue Watermelon,BlockingQueue Grape,int numberApple,int numberOrange,int numberWatermelon,int numberGrape ) {
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
		int i,item,element;
		for(i=1;i<=this.numberApple;i++)
		{
			try{
				item=(int)Apple.size();
				if(item>0)
				{
					element=(int)Apple.take();
					System.out.println("Consumed Apple: " + element);

				}
				else
					System.out.println("No Apples");
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(i=1;i<=this.numberOrange;i++)
		{
			try{
				item=Orange.size();
				if(item>0)
				{
					element=(int)Orange.take();
					System.out.println("Consumed Orange: " + element);

				}
				else
					System.out.println("No Orange");
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(i=1;i<=this.numberWatermelon;i++)
		{
			try{
				item=Watermelon.size();
				if(item>0)
				{
					element=(int)Watermelon.take();
					System.out.println("Consumed Watermelon: " + element);

				}
				else
					System.out.println("No Watermelon");
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(i=1;i<=this.numberGrape;i++)
		{
			try{
				item=Grape.size();
				if(item>0)
				{
					element=(int)Grape.take();
					System.out.println("Consumed Grape: " + element);

				}
				else
					System.out.println("No Grape");
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
		

}
