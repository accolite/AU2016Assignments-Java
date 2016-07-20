package Multithread_Restaurant;

public class BillCalculater extends Thread {

	private double bill;
	private static double total;
	private int currCount, prevCount;
	
	BillCalculater () {
		total = 0.0;
		currCount = 0;
	    prevCount = 0;
	}
	
	public synchronized void setBill(double bill) {
		this.bill = bill;
	}
	
	public static synchronized double getTotalSell() {
		return total;
	}
	
	public synchronized double calculateTotal() {
		currCount = BillGenerator.getCount();
		if(currCount == prevCount + 1) {
			double r = Math.round((total + bill) * 100);
			double o = r / 100;
			total = o;
			prevCount = currCount;
		}
		return total;
	}
	
	@Override
	public void run() {
		
	}

}