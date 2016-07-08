package com.accolite.aasignment3;

import java.util.ArrayList;

public class Node 
{
		Object key;
		Object value;
		Node next;
		Node previous;
		Node insertionOrder;
		ArrayList<Node> NodeArray = new ArrayList();
		
		public Node(Object a,Object b)
		{
			key=a;
			value=b;
			next=null;
			previous=null;
			int size = NodeArray.size();
			//insertionOrder=NodeArray.get(size-2);
			
		}
		
		public Node addNode(Node currentNode,Node newNode,Object a,Object b)
		{
			newNode.key=a;
			newNode.value=b;
			newNode.next=null;
			newNode.previous=currentNode;
			int size = NodeArray.size();
			//newNode.insertionOrder=NodeArray.get(size-2);
			return newNode;
			
		}

}
