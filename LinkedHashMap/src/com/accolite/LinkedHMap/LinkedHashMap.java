package com.accolite.LinkedHMap;

import java.util.Scanner;

public class LinkedHashMap {
	
	public static void main(String args[]){
	
		HashArray hashArray=new HashArray();
		//HashArray hashArray1=new HashArray();
		//hashArray.put(1, "jegan");
		//hashArray.put(11, "sharuk");
		Object key,value;
		int size;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size:");
		size=sc.nextInt();
		System.out.println("Enter the key and value:");
		for(int i=0;i<size;i++)
		{
			key=sc.nextInt();
			value=sc.next();
			hashArray.put(key,value);
		}
		hashArray.PrintInOrder();
		while(true)
		{
			System.out.println("Enter the key:");
			key=sc.nextInt();
			System.out.println("Value:"+hashArray.get(key));
		}
		/*	LinkedHashMap customMap=new LinkedHashMap();
		int hashkey;
		//Object key,value;
		for(int i=0;i<10;i++){
			hasharray[i]=new HashArray();
		}
		hashkey=customMap.getHashValue(0);
		Node prev=null,next=null;
		hasharray[hashkey].put(0,"jegan",prev,next);
		System.out.println(hashkey);
		hashkey=customMap.getHashValue(1);
		hasharray[hashkey].put(1,"lokesh",prev,next);
		
//		hashkey=customMap.getHashValue(key);
		
		hashkey=customMap.getHashValue(2);
		hasharray[hashkey].put(2,"sharuk",prev,next);
		System.out.println(hasharray[hashkey].get(1));
		
	*/
	}
	
}
