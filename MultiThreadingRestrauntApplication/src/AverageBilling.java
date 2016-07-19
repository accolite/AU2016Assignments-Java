/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Thread2.
 */
public class AverageBilling implements Runnable{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
			float avg = 0;
			while(true){
				
				try {
					
					Global.billAmount.take();
					Global.AveragebillAmount.put(Global.bill/Global.num_billings);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	
	
	
	
}

