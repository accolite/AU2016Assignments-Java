/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.demo;

public class average extends Thread{
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while(true)
		{
			
			try {
				Main.total.take();
				Main.average.put(Main.total_amount/Main.count);
				//System.out.println("average "+ Main.average.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
