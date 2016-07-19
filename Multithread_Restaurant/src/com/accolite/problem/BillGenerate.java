/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.problem;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class BillGenerate.
 */
public class BillGenerate implements Runnable {

	/** The data. */
	int[] data={0,0,0};
	
	/** The j. */
	int j;
	
	/** The input. */
	Scanner input=new Scanner(System.in);
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true){
			System.out.println("Select:\n1.Go\n2.Exit");
			j=input.nextInt();
			if(j==1){
				System.out.println("Bill Amount\n");
				// TODO Auto-generated method stub
				data[0]=input.nextInt();
				
				AverageCalc aCalc=new AverageCalc(data);
				Thread t1=new Thread(aCalc);
				t1.start();
				
				synchronized (t1) {
					try {
						//System.out.println("Waiting for t1 to complete");
						t1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
				}
			}else{
				break;
			}
		}
	}

}
