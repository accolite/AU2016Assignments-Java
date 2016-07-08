package hashmapAssignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HashMapArray {
	
	
	public static void main(String args[]) {
		
		
		int i , n, key, value, index, flag;
		HashMapArray hashMapArray = new HashMapArray();
		NewLinkedList newLinkedList = new NewLinkedList();
		Entry next = new Entry();
		Entry order = new Entry();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many key-value pairs you want to enter?");
		n = sc.nextInt();
		System.out.println("Enter key value pairs :");
		for(i = 0; i < n; i++) {
			key = sc.nextInt();
			value = sc.nextInt();
			next = newLinkedList.add(key, value);
			if(i == 0) {
				order =  next;
			}
		}
		System.out.println("Enter key to find the value");
		key = sc.nextInt();
		flag = 0;
		value = newLinkedList.get(key);
		if(value == -1)	
			System.out.println("No key found");
		else
			System.out.println("value " + value);
		System.out.println("The order in which values are entered :");
		newLinkedList.print(order);
	}
}
