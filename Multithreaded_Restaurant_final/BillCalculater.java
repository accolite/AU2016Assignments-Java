package Multithread_Restaurant;

public class BillCalculater extends Thread {

	private static double bill;
	private static double total;
	private int currCount; 
	private static int prevCount;
	
	BillCalculater () {
		total = 0.0;
		currCount = 0;
	    prevCount = 0;
	}
	
	public static synchronized int getCount() {
		return prevCount;
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
			currCount = BillGenerator.getCount();
			//if(currCount == prevCount + 1) {
				try {
					
					double r = Math.round((total + BillGenerator.getBill()) * 100);
					double o = r / 100;
					total = o;
					prevCount = currCount;
					
					System.out.println("total : "+ total + "\navg : " + total/currCount);
					//this.join();
					//this.notify();
					//this.wait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//}
		//}
	}

}