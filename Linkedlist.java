package com.accolite.mycollections;

import java.util.Scanner;

public class Linkedlist {

	public static void main(String args[]) {
		LinkedHashMap myLinkedHashMap = new LinkedHashMap();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			String key = scan.next();
			if (key.equals("null")) {
				System.out.println("NUll POINTER EXCEPTION");
				continue;
			}
			int value = scan.nextInt();
			myLinkedHashMap.put(key, value);
		}
		System.out.println("enter get key value");
		String key = scan.next();
		System.out.println(myLinkedHashMap.get(key));
	}

}
