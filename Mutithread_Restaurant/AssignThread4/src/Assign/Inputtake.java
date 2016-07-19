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

public class Inputtake extends Thread {
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		main.choice = "y";
		Scanner sc = new Scanner(System.in);
		// System.out.println("Table No. Amount");
		System.out.println("Want to enter Y/N ");
		main.choice = sc.nextLine();
		int tablenum;
		float amount;
		while (main.choice.equals("y") || main.choice.equals("Y")) {
			System.out.println("TableNo. Amount");
			tablenum = sc.nextInt();
			amount = sc.nextFloat();
			sc.nextLine();
			Table tab = new Table();
			tab.setNumber(tablenum);
			tab.setAmount(amount);
			try {
				main.table.put(tab);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Want to enter more Y/N");
			main.choice = sc.nextLine();
		}
		if (!(main.choice.equals("y") || main.choice.equals("Y"))) {
			System.out.println("Thread 1 exit");
			Table tab = new Table();
			try {
				main.table.put(tab);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
