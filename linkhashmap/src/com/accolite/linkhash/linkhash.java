/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.linkhash;

import java.util.LinkedList;
import java.util.Scanner;



// TODO: Auto-generated Javadoc
/**
 * The Class linkhash.
 */
public class linkhash {

	/** The n. */
	public 
	int n;
	
	/** The head. */
	Node head;
	
	/** The list. */
	LinkedList<Node>[] list;
 	
	 /**
	  * Hash function.
	  *
	  * @param key the key
	  * @param n the n
	  * @return the int
	  */
	 int hashFunction(int key,int n)
	{
		return key%n;
	}
 	
 	
 	
	/**
	 * Put.
	 *
	 * @param obj the obj
	 */
	void put(linkhash obj)
	{
		
		System.out.println("Enter number of elements");
		Scanner sc=new Scanner(System.in);
		obj.n=sc.nextInt();
		
		
		obj.list=new LinkedList[obj.n];
		for(int i=0;i<obj.n;i++)
		obj.list[i]=new LinkedList<Node>();
		//obj.list=new LinkedList<Node>();
		
		int Key,Val;
		System.out.println("Enter the key and value ");
		int index;
		Node previous,n;
		previous=null;
		Scanner scan=new Scanner(System.in);
		
		Key=scan.nextInt();
		Val=scan.nextInt();
		index=obj.hashFunction(Key,obj.n);
		//index=Key%obj.n;
		n=new Node(Key,Val,null);
		obj.head= n;
		previous=n;
		
		
		obj.list[index].add(n);
		int a[]=new int[1000];
		for(int i=0;i<1000;i++)
			a[i]=0;
		for(int i=1;i<obj.n;i++)
		{
			
			Key=sc.nextInt();
			Val=sc.nextInt();
			index=obj.hashFunction(Key,obj.n);
			
			//index=Key%obj.n;
			if(a[Key]!=0){
			for(Node iter:this.list[index])
			{
				if((iter.key)==(Key))
				{	
					iter.value=Val;
					return ;
					
				}
			}
			}
			
			else{
				a[Key]=Val;
		    n=new Node(Key,Val,null);
		    previous.next=n;
			previous=n;
			obj.list[index].add(n);
			}
			
		}
	}
 	
 	
 
	
	/**
	 * Gets the.
	 */
	void get()
	{
		int key,index;
		System.out.println("Enter Key ");
		Scanner sc=new Scanner(System.in);
		key=sc.nextInt();
		index=hashFunction(key,this.n);
		//index=key%n;
		
		for(Node i:this.list[index])
		{
			if(i.key==key)
				System.out.println(i.value);
		}
	
	}
	
	
	
	/**
	 * Traverse.
	 */
	void traverse()
	{	
		Node h=head;
		if(h==null)
			System.out.println("empty list");
		else{
		while(h!=null)
		{
			System.out.println("value is" +h.value);
			h=h.next;
		}
		}
		
	}
	
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Node n;
		linkhash obj=new linkhash();
		
		System.out.println("enter your choice");
		
		boolean flag=false;
		 while(true){
	   System.out.println("1.put an element");
	   System.out.println("2.get an element");
			 System.out.println("3.traverse the linkhash");
			 System.out.println("4.exit");
	   int choice;
	  
	   Scanner scanner=new Scanner(System.in);
	   choice=scanner.nextInt();
	   switch(choice){
	   
	   case 1:
		   obj.put(obj);
		   break;
	   case 2:
		   obj.get();
		   break;
	   case 3:
		   obj.traverse();
		   break;
	   case 4:
		   flag=true;
		   break;
	   }
	   if(flag==true)
		   break;
		 }
		
	
		
		
	}
	
}