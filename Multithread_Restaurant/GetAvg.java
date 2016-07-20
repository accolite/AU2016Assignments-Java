package atomic;

public class GetAvg implements Runnable{

	private Restaurant re;
	private float avg=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			re.tables.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		avg = re.sum/re.count;
		try {
			re.average.put(avg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Manager()).start();
	}

}
