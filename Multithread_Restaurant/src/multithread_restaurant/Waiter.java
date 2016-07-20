package multithread_restaurant;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {
	BlockingQueue<Order> BillQueue=new ArrayBlockingQueue<>(1);;
	int bill;
	public Waiter(){
		
	}
	public Waiter(BlockingQueue<Order> BillQueue)
	{
		this.BillQueue=BillQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Order order=new Order();
		Scanner input=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Table Number and Order Amount");
			order.setTableno(input.nextInt());
			order.setAmount(input.nextDouble());
			try{
				BillQueue.put(order);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
