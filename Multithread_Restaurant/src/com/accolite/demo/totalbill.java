/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.demo;

import java.util.Scanner;

public class totalbill extends Thread{
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run()
{
		
	while(true){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the table no and amout ");
		Main.table_no=sc.nextInt();
		
		
		Main.amount=sc.nextFloat();
		Main.total_amount+=Main.amount;
		Main.count++;
		try {
			Main.total.put(Main.amount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
	
	
}
}
