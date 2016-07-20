package Multithread_Restaurant;

public class AvgCalculater extends Thread {

	private static double total;
	private int currCount, prevCount;
	
	AvgCalculater () {
		total = 0.0;
		currCount = 0;
	    prevCount = 0;
	}
	
	public synchronized double getAvgSell() {
		double r = Math.round(BillCalculater.getTotalSell() * 100 / BillGenerator.getCount());
		double o = r / 100;
		return (o);
	}
	
	@Override
	public void run() {
		try {
			this.join();
			currCount = BillCalculater.getCount();
			if(currCount == prevCount + 1) {
				double r = Math.round(BillCalculater.getTotalSell() * 100 / BillGenerator.getCount());
				double o = r / 100;
				total = o;
				prevCount = currCount;
				
				System.out.println("avg : "+ total);
				//this.join();
				//this.notify();
				//this.wait();
			}
		}
		catch(Exception e) {}
	}

}
