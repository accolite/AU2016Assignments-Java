/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.demo;

public class notifyowner extends Thread{
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		while(true)
		{
			try {
				float till_now=Main.average.take();
				System.out.println("average "+ till_now);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
