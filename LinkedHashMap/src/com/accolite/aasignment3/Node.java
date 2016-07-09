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
			this.key=a;
			this.value=b;
			next=null;
			previous=null;
			int size = NodeArray.size();
			//insertionOrder=NodeArray.get(size-2);
			
		}

}
