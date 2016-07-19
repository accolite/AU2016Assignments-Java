/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 20, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.problem;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 */
	public static void main(String arg[]){
		
		BillGenerate billGenerate=new BillGenerate();
		Thread t1=new Thread(billGenerate);
		t1.start();
	}

}
