package atomic;

public class Manager implements Runnable{

	private Restaurant re;
	float avg;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			avg=(float) re.average.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Current average is "+ avg);
	}

}
