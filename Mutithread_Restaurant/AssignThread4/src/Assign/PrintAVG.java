/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Assign;

import java.util.Scanner;

public class PrintAVG extends Thread {
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while (main.choice.equals("y") || main.choice.equals("Y")) {
			Table t;
			try {
				t = main.average.take();
				if (main.choice.equals("y") || main.choice.equals("Y")) {
					System.out.println(" Average till now is " + t.getAvg());
				} else {
					System.out.println("Thread 3 exit");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
