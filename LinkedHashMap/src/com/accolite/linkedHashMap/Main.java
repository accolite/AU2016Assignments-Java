package com.accolite.linkedHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[])
	{
		LinkedHashMap myLinkedHashMap=new LinkedHashMap();
		
		Scanner input=new Scanner(System.in);
		
		ArrayList<String> listOfKey=new ArrayList<>();
		
		int i=1,value,cont,choice;
		String key1,space; 
		while(i==1)
		{
			System.out.println("Enter your choice:\n 1. Put \n2. get \n3. Get All \n4. Exit");
			choice=input.nextInt();
			switch(choice){
			
			case 1:
				space=input.nextLine();
				System.out.println("Enter key: ");
				key1=input.nextLine();
				System.out.println("Enter value: ");
				value=input.nextInt();
				if(!listOfKey.contains(key1))
				{
					myLinkedHashMap.put(key1,value);
					listOfKey.add(key1);
				}
				else
					System.out.println("Enter unique key");
				break;
			case 2:
				space=input.nextLine();
				System.out.println("Enter key: ");
				key1=input.nextLine();
				System.out.println(myLinkedHashMap.get(key1));
				
				break;
				
			case 3:
				HashMap<String, Integer> hashMap= myLinkedHashMap.getMyHashMap();
				ArrayList<NodeArrayList> nodeInsertionOrder=myLinkedHashMap.getArrayListToStoreNodes();
				for(int j=0;j<nodeInsertionOrder.size();j++)
					System.out.println("key is: "+nodeInsertionOrder.get(j).getKey()+" Value is: "+hashMap.get(nodeInsertionOrder.get(j).getKey()));
				break;
			case 4:
				i=0;
				break;
			}
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
