/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Assign;

public class AVGAll extends Thread {
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while (main.choice.equals("y") || main.choice.equals("Y")) {
			Table t;
			try {
				t = main.table.take();
				if (main.choice.equals("y") || main.choice.equals("Y")) {
					main.tot += t.getAmount();
					main.num++;
					main.avg = main.tot / main.num;
					t.setAvg(main.avg);
					main.average.put(t);
				} else {
					System.out.println("Thread 2 exit");
					main.average.put(t);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
