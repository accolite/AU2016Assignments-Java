package Multithread_Restaurant;

public class AvgCalculater extends Thread {

	public synchronized double getAvgSell() {
		double r = Math.round(BillCalculater.getTotalSell() * 100 / BillGenerator.getCount());
		double o = r / 100;
		return (o);
	}
	
	@Override
	public void run() {
		
	}

}
