/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class BillReceiver implements Runnable {

	protected BlockingQueue newBillq = null;

	public BillReceiver(BlockingQueue newBill) {
		super();
		this.newBillq = newBill;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (true) {

			System.out.println("enter new the bill amount ");
			Scanner sc = new Scanner(System.in);

			float newBillValue = sc.nextFloat();

			try {
				newBillq.put(newBillValue);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
