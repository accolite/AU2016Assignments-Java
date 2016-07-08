/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Sumeet

* ***************************************************************************

*/
package com.accolite.linkedHashMap;

import java.util.ArrayList;
import java.util.LinkedList;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<LinkedList<Node>> hash = new ArrayList<LinkedList<Node>>(10);
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Input no. of input <key, value> pair");
		int noOfElement = input.nextInt();
		int key = input.nextInt();
		int value = input.nextInt();
		int actualKey = key % 1000000; // Hash function
		for(int i = 0; i < 1000000; i++) {
			LinkedList<Node> n = new LinkedList<Node>();
			hash.add(n);
		}
		Node nptr = new Node(value,key, null, null);
		Node start = nptr;
		
		
		hash.get(actualKey).add(nptr);
		Node ptr = nptr;
		for(int i = 1; i < noOfElement; i++) {
			key = input.nextInt();
			value = input.nextInt();
			actualKey = key % 1000000;
			nptr = new Node(value,key, null, null);
			hash.get(actualKey).add(nptr);
			nptr.setLinkPrev(ptr);
            ptr.setLinkNext(nptr);
			ptr = nptr;
		}
		while(start != null) {
			System.out.println(start.data);
			start = start.getLinkNext();
		}
		
		for(int i = 0; i < hash.size(); i++) {
			for(int j = 0; j < hash.get(i).size(); j++) {
				//int k = 
				System.out.print(hash.get(i).get(j).data + " "  + hash.get(i).get(j).key);
			}
			System.out.println();
		}
		while(true) {
			System.out.println("Input key to find value");
			int findKey = input.nextInt();
			if(findKey < 0) {
				System.out.println("Not possible");
				continue;
			}
			int generatedKey = findKey % 1000000;
			if(hash.get(generatedKey).size() == 0) {
				System.out.println("no value exist");
			} 
			else if(hash.get(generatedKey).size() == 1) {
				System.out.println(hash.get(generatedKey).get(0).data);
			} else {
				for(int i = 0; i < hash.get(generatedKey).size(); i++) {
					if(hash.get(generatedKey).get(i).key == findKey) {
						System.out.println(hash.get(generatedKey).get(i).data);
						break;
					}
					
				}
			}
		}
		
		
		
		

	}

}
