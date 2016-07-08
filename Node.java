package com.accolite.LHashmapCustom;

public class Node {
	int key;
	int value;
	Node next;
	Node previous;
	Node(int key,int val,Node prev)
	{
		this.next=null;
		this.previous=prev;
		this.key=key;
		this.value=val;
		
	}

}
