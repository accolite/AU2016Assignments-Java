/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		BlockingQueue newAverageq = new ArrayBlockingQueue(1);
		BlockingQueue newBillq = new ArrayBlockingQueue(1);

		BillReceiver billReceiver = new BillReceiver(newBillq);
		AverageCalulator averageCalulator = new AverageCalulator(newAverageq, newBillq);
		Owner owner = new Owner(newAverageq);

		Thread billReceiverThread = new Thread(billReceiver);
		Thread averageCalculatorThread = new Thread(averageCalulator);
		Thread ownerThread = new Thread(owner);

		billReceiverThread.start();
		averageCalculatorThread.start();
		ownerThread.start();

	}
}
