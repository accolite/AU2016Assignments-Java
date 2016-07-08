/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 8, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.LinkedHMap;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedHashMap.
 */
public class LinkedHashMap {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
	
		HashArray hashArray=new HashArray();
		Object key,value;
		int size,flag=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("No of Inputs:");   //To get no of key,value pair
		size=sc.nextInt();
		System.out.println("Enter the key and value:");
		for(int i=0;i<size;i++)
		{
			key=sc.nextInt();
			value=sc.next();
			hashArray.put(key,value);  //putting the key,value pair in hash
		}
		System.out.println("Prinited InOrder");
		hashArray.PrintInOrder();      // printing the input in order
		System.out.println("Getting the Value:");
		while(flag==1)
		{
			System.out.println("Enter the key:");
			key=sc.nextInt();
			System.out.println("Value:"+hashArray.get(key));
			System.out.println("Continue? yes->1 / no->0");
			flag=sc.nextInt();
		}
		}
	
}
