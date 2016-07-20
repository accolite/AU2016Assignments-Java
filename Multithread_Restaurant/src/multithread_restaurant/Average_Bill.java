package multithread_restaurant;

import java.util.concurrent.BlockingQueue;

public class Average_Bill implements Runnable{
	BlockingQueue<Order> BillQueue;
	BlockingQueue<Double> AverageQueue;
	public Average_Bill(){
		
	}
	public Average_Bill(BlockingQueue<Order> BillQueue,BlockingQueue<Double> AverageQueue){
		this.BillQueue=BillQueue;
		this.AverageQueue=AverageQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Order order=new Order();
		int count=0;
		double average=0;
		while(true)
		{
			try{
				order=BillQueue.take();
				count++;
				average=((average*(count-1))+order.getAmount())/count;
				AverageQueue.put(average);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
