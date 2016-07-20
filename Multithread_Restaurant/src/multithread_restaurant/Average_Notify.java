package multithread_restaurant;

import java.util.concurrent.BlockingQueue;

public class Average_Notify implements Runnable {
	BlockingQueue<Order> BillQueue;
	BlockingQueue<Double> AverageQueue;
	public Average_Notify(){
		
	}
	public Average_Notify(BlockingQueue<Order> BillQueue,BlockingQueue<Double> AverageQueue){
		this.BillQueue=BillQueue;
		this.AverageQueue=AverageQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double Average_Bill;
		while(true)
		{
			try{
				Average_Bill=AverageQueue.take();
				System.out.println("The Average Bill is :"+Average_Bill);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
