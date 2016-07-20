package restaurant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Avg implements Runnable {
	ArrayBlockingQueue<Order> order;
static int count;
	public Avg(BlockingQueue<Order> order2) {
		this.order = (ArrayBlockingQueue<Order>) order2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			if (this.order.size() != 0) {
				System.out.println(" Thread Avg started ; calulating average");

				float cur_sum = Restaurant.avgvalue.peek();
				Restaurant.avgvalue.take();
				 count = 0;
				float new_sum = 0;
				for (int i = 0; i < order.size(); i++) {
					new_sum += order.peek().amount;
					count =order.peek().table;
					System.out.println("number of order is "+count);

					order.take();
					
				}
				Restaurant.avgvalue.put(cur_sum + new_sum);
				Restaurant.avgvalue_display.put(Restaurant.avgvalue.peek()/count);
				
			}

		} catch (Exception e) {

		}

	}

}
