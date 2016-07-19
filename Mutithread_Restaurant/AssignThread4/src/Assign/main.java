/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Assign;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class main {
	static ArrayBlockingQueue<Table> table;
	static ArrayBlockingQueue<Table> average;
	static float tot;
	static float num;
	static float avg;
	
	/** The choice. */
	// static ArrayList<Table> history;
	static String choice;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tot = 0f;
		num = 0f;
		table = new ArrayBlockingQueue<>(10);
		average = new ArrayBlockingQueue<>(10);
		// history=new ArrayList();
		Inputtake T1 = new Inputtake();
		AVGAll T2 = new AVGAll();
		PrintAVG T3 = new PrintAVG();
		choice = "Y";
		T1.start();
		T2.start();
		T3.start();
	}

}
