package atomic;

import java.util.concurrent.BlockingQueue;

public class BillPaid implements Runnable{

	private int value ;
	private Restaurant re;
	public BillPaid(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			re.sum+=value;
			re.count+=1;
			re.tables.put(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new GetAvg()).start();
	}

}
