/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.util.concurrent.BlockingQueue;

public class AverageCalulator implements Runnable {

	protected BlockingQueue newAverageq = null;
	protected BlockingQueue newBillq = null;
	protected int counter;
	protected float oldAverage;

	/**
	 * Instantiates a new average calulator.
	 *
	 * @param newAverage the new average
	 * @param newBill the new bill
	 */
	public AverageCalulator(BlockingQueue newAverage, BlockingQueue newBill) {
		super();
		this.newAverageq = newAverage;
		this.newBillq = newBill;
		counter = 0;
		oldAverage = 0;
	}

	@Override
	public void run() {

		while (true) {
			try {
				float newNumber = (float) newBillq.take();
				counter++;
				
				System.out.println("Calculating new average");
				float newAverage = (oldAverage * (counter - 1) + newNumber) / counter;
				oldAverage = newAverage;

				newAverageq.put(newAverage);
				Thread.sleep(500);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
