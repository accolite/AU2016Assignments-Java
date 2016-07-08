package com.accolite.test;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.accolite.util.CustomLinkedHashMapG;

public class Test {
	public static void main(String args[]) {
		/*CustomLinkedHashMap map = new CustomLinkedHashMap(20);
		System.out.println(map.put(1, "hello"));
		System.out.println(map.put(21, "world"));
		System.out.println(map.put(31, "A"));
		System.out.println(map.put(42, "B"));
		System.out.println(map.put(53, "C"));
		System.out.println(map.put(62, "D"));
		System.out.println(map.put(73, "E"));
		System.out.println(map.put(11, "buddy"));
		List<Entry<Integer, String>> orderedList = map.getInOrder();
		for(Entry<Integer, String> entry : orderedList){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}*/
		CustomLinkedHashMapG<Integer, String> lhmap = new CustomLinkedHashMapG<>();
		/*System.out.println(lhmap.put("A", "hello"));
		System.out.println(lhmap.put("B", "world"));
		System.out.println(lhmap.put("A", "A"));
		System.out.println(lhmap.put("C", "B"));
		System.out.println(lhmap.put(null, "C"));
		System.out.println(lhmap.put("B", "C"));
		System.out.println(lhmap.put("D", "D"));
		System.out.println(lhmap.put("A", "E"));
		System.out.println(lhmap.put("B", "buddy"));
		*/
		
		Scanner in = new Scanner(System.in);
		int op = 0;
		Integer key;
		String value;
		while(op!=6)
		{
			System.out.println("\n\n\nEnter option \n "
					+ "1. Put \n "
					+ "2. Get \n "
					+ "3. List \n "
					+ "4. Insert null key \n "
					+ "5. Get value of key 'null' \n "
					+ "6. Exit \n Enter your option : ");
			op = in.nextInt();
			switch(op){
			case 1:
				System.out.println(" Enter key and value: ");
				key = in.nextInt();
				value = in.next();
				if (lhmap.put(key, value))
					System.out.println("Inserted");
				continue;
			case 2:
				System.out.println(" Enter key : ");
				key = in.nextInt();
				value = lhmap.get(key);
				System.out.println("Value for the key "+key+" is "+value);
				continue;
			case 3:
				List<Entry<Integer, String>> orderedList = lhmap.getInOrder();
				System.out.println("=================");
				if(orderedList != null)
					for(Entry<Integer, String> entry : orderedList){
						System.out.println(entry.getKey()+"::"+entry.getValue());
					}
				else
					System.out.println("Map is empty");
				System.out.println("=================");
				continue;
			case 4:
				System.out.println(" Enter value: ");
				value = in.next();
				if (lhmap.put(null, value))
					System.out.println("Inserted");
				continue;
			case 5:
				value = lhmap.get(null);
				System.out.println("Value for the key "+null+" is "+value);
				continue;
			default:
				System.out.println("Enter correct option");
			}
		}
		}
		
		/*List<Entry<String, String>> orderedList = lhmap.getInOrder();
		for(Entry<String, String> entry : orderedList){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}*/
	}

