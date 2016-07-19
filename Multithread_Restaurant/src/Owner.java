/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.util.concurrent.BlockingQueue;

public class Owner implements Runnable {

	protected BlockingQueue newAverageq = null;

	public Owner(BlockingQueue newAverage) {
		super();
		this.newAverageq = newAverage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (true) {
			try {
				float newAverage = (float) newAverageq.take();
				
				System.out.println("New average is ");
				System.out.println(newAverage);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
