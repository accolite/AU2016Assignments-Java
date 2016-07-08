/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 8, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.collection;

import java.util.Iterator;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Tester.
 */
public class Tester {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LinkedHashmap map = new LinkedHashmap(); // creating the collection
		// adding values
		Scanner in = new Scanner(System.in);
		boolean runLoop=true;
		while(runLoop){
			System.out.println("Choose\n"
						+"1 add key value\n"
						+"2 get value\n"
						+"3 iterat the list\n"
						+"4 exit");
			switch(in.nextInt()){
				case 1: System.out.println("key\tvalue");
						String key=in.next();
						String value=in.next();
						map.put(key,value);
						break;
				case 2: System.out.println("Enter key");
						System.out.println(map.get(in.next()));
						break;
				case 3: System.out.println("Your List");
						for (Iterator iterator = map.iterator(); iterator.hasNext();) {
							System.out.println((String) iterator.next()); // getting values through iteration
						}
						break;
				default: runLoop=false;
				
			}
		}
	}
}
