package com.accolite.LinkedHMap;

public class HashArray {
	//public int hashvalue;
	Node[] hashHeader=new Node[100];
	static Node firstNode,currentNode;
	
/*	public HashArray() {
		super();
		hashvalue=0;
		firstNode=null;
	}
*/
	public HashArray() {
		super();
		//this.hashvalue = hashvalue;
		this.firstNode = null;
		this.currentNode = null;
	}
	
	public void put(Object key,Object value){
		int hashval=key.hashCode()%100;
		if(hashHeader[hashval]==null){
			Node newNode=new Node(null,currentNode,key,value);
			if(currentNode!=null)
					currentNode.nextInOrder=newNode;
			else{
				firstNode=newNode;
			}
			currentNode=newNode;
			hashHeader[hashval]=newNode;
				
		}
		else{
			Node rider=hashHeader[hashval];
			//Node rider=firstNode;
			while(rider.next!=null)
				rider=rider.next;
			Node newNode=new Node(currentNode,null,key,value);
			rider.next=newNode;
			newNode.prev=rider;
			currentNode.nextInOrder=newNode;
		}
	}
	
	public Object get(Object key){
		int hashval=key.hashCode()%100;
		Node rider=hashHeader[hashval];
		if(rider==null)
			return 0;
		while(rider!=null && rider.key!=key)
			rider=rider.next;
		return rider.value;
	}
		
	public void PrintInOrder(){
		Node rider=firstNode;
		while(rider!=null){
			System.out.println(rider.key+"   "+rider.value);
			rider=rider.nextInOrder;
		}
	}
}
