/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package org.au.handson;

import java.util.Scanner;

public class firstclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Sqlfirst sf=new Sqlfirst();
		System.out.println("Enter Choice");
		Scanner sc=new Scanner(System.in);
		choice=sc.nextInt();
		while(choice>0&&choice<12){
			switch(choice){
			case 1:sf.listAllStates();
			break;
			case 2:sf.listAllDistricts();
			break;
			case 3:sf.displayCitizenCount();
			break;
			case 4:sf.removeDistrict(sc.nextInt());
			break;

			case 5:sf.removeState(sc.nextInt());
			break;
			case 6:sf.listAllUnderState(sc.nextInt());
			break;
			case 7:sf.listAllUnderDistrict(sc.nextInt());
			break;
			case 8:sf.showHead(sc.nextInt());
			break;
			case 9:sf.changeHead(sc.nextInt(),sc.nextInt());
			break;
			case 10:sf.techdet();
			break;
			case 11:sf.init();
			break;
			default:System.out.println("Wrong option");
			
			}
			choice=sc.nextInt();
			
		}
		sf.flush();
	}

}
