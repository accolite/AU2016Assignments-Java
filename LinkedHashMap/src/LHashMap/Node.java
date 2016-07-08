package LHashMap;

public class Node {
	int key;
	int value;
	Node prev;
	Node next;
	Node hnext; 
Node(int key,int value)
{
	this.key=key;
	this.value=value;
	this.prev=null;
	this.hnext=null;
	this.next=null;

}

}

