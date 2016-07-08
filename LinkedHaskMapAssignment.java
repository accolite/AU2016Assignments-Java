package com.accolite.customlinkedhashmap;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class LinkedHaskMapAssignment 
{
	
	Scanner input = new Scanner(System.in);
	ArrayList<LinkedList<NodeClass>> bucket = new ArrayList<LinkedList<NodeClass>>(10);
	public void put()
	{
		// in put function
		System.out.println("Enter the number of input pairs:");
		int no_of_inputs = input.nextInt();
		int key = input.nextInt();
		int value = input.nextInt();
		int calculatedKey = key % 1000;
		for(int i = 0; i < 1000; i++) {
			LinkedList<NodeClass> n = new LinkedList<NodeClass>();
			bucket.add(n);
		}
		NodeClass newNode = new NodeClass(value,key, null, null);
		bucket.get(calculatedKey).add(newNode);
		NodeClass temp = newNode;
		for(int i = 1; i < no_of_inputs; i++) {
			key = input.nextInt();
			value = input.nextInt();
			calculatedKey = key % 1000;
			newNode = new NodeClass(value,key, null, null);
			bucket.get(calculatedKey).add(newNode);
			newNode.setPrev(temp);
            temp.setNext(newNode);
			temp = newNode;
		}
		
	}
	
	public void get()
	{
		// in get function
		while(true) 
		{
			System.out.println("Enter key to find value: (Enter -1 to exit)");
			int inputKey = input.nextInt();
			if(inputKey==-1)
				break;
			int calculatedKey = inputKey % 1000;
			if(bucket.get(calculatedKey).size() == 0) 
			{
				System.out.println("No Key ");
			} 
			else if(bucket.get(calculatedKey).size() == 1) 
			{
				System.out.println(bucket.get(calculatedKey).get(0).value);
			} 
			else 
			{
				for(int i = 0; i < bucket.get(calculatedKey).size(); i++)
				{
					if(bucket.get(calculatedKey).get(i).key == inputKey) {
						System.out.println(bucket.get(calculatedKey).get(i).value);
						break;
				}
			}
		}
	}
	}

		public static void main(String[] args) 
		{
			// TODO Auto-generated method stub
			LinkedHaskMapAssignment linkedHashMap=new LinkedHaskMapAssignment();
			linkedHashMap.put();
			linkedHashMap.get();
		}
			
}

