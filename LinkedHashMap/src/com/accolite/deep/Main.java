package com.accolite.deep;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LHashMap map = new LHashMap();		
		Scanner in = new Scanner(System.in);
		System.out.println("1. Put\n2. Get\n3. List All\n4. Exit");
		while(in.hasNext()){
			
			int choice = in.nextInt();
			switch(choice) {
				case 1: 
					System.out.print("Enter key and value : ");
					map.put(in.next(), in.next());
					break;
				case 2:
					System.out.print("Enter key : ");
					Object key = in.next();
					Object value = map.get(key);
					System.out.println(value==null?"Does not Exist":value);
					break;
				case 3:
					map.showAll();
					break;
				case 4:
					return;
					//break;
			}
			System.out.println("1. Put\n2. Get\n3. List All\n4. Exit");
		}
		

	}
}
