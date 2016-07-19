/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
import java.util.concurrent.BlockingQueue;

public class OutputThread implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		
			while(true)
			{
				try {
					Float tmp=Global.AveragebillAmount.take();
					if(Float.compare(tmp, Global.previousAverage)!=0)
					{
						System.out.println("New Average Bill is "+tmp);
						Global.previousAverage=tmp;
					}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
	}
			
}
	
	
	
