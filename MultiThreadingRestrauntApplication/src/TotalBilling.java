/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Thread1.
 */
public class TotalBilling implements Runnable{

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		int num_table;
		float amount;
		Scanner sc=new Scanner(System.in);
		
			
		while(true){		
			System.out.println("Enter the table nunmber ");
			num_table=sc.nextInt();
			System.out.println("Enter the billing amount ");
			amount=sc.nextFloat();
			Global.bill+=amount;
			Global.num_billings+=1;
			Global.billAmount.add(amount);
				
		}
	}
	
	
	
}
