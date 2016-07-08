package com.accolite.LHashmapCustom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class LinkedHashMapCustom {
	ArrayList<LinkedList<Node>> al;
	Node prev;
	Node first;
	LinkedHashMapCustom()
	{
		prev=null;
		al=new ArrayList<LinkedList<Node>>(1000);
		int i;
		for(i=0;i<1000;i++)
		{
			LinkedList<Node> temp=new LinkedList<Node>();
			al.add(temp);
		}
	}
	void put(int key,int val)
	{
		if(al.get(key).isEmpty()!=true)
		{
			al.get(key).getFirst().value=val;
		}
		else
		{
		Node temp=new Node(key,val,this.prev);
		if(this.prev==null)
		{
			this.first=temp;
		}
		al.get(key).add(temp);
		if(this.prev!=null)
		this.prev.next=temp;
		
		this.prev=temp;
		}
		
	}
	int get(int key)
	{
		LinkedList<Node> temp=al.get(key);
		Node tem=temp.get(0);
		while(tem!=null)
		{
			if(tem.key==key)
			{
				return tem.value;
			}
				
			tem=tem.next;
			
		}
		return -1;
	}
	void printInsertionOrder()
	{
		Node temp=first;
		while(temp!=null)
		{
			System.out.println("Key:"+temp.key+"  Value:"+temp.value);
			temp=temp.next;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMapCustom lhmp= new LinkedHashMapCustom();
		while(true)
		{
		System.out.println("Enter Choice:1.Put Value(enter key<1000)  2.Get value 3.Print Insertion Order");
		Scanner inp=new Scanner(System.in);
		int ch=inp.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter key and val");
			int k=inp.nextInt();
			int v=inp.nextInt();
			lhmp.put(k, v);
			break;
		case 2:
			System.out.println("Enter key value");
			int k1=inp.nextInt();
			System.out.println(lhmp.get(k1));
			break;
		case 3:
			lhmp.printInsertionOrder();
			break;
		default:
			break;
			
			
					
		}
		
		}
	}

}
