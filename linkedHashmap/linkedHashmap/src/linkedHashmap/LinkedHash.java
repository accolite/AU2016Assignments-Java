package linkedHashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class LinkedHash {
	public boolean get(ArrayList<LinkedList<Node>> a, int data) {
		ListIterator itr = a.get(data%10000).listIterator();

		ListIterator<Node> listIterator = a.get(data%10000).listIterator();
        while (listIterator.hasNext()) {
        	Node answer = listIterator.next();
        	if(answer.getValue() == data)
  	    	  return true;
        }
        return false;
        
        
	    
	}
	
	public Node createNode(int key, int value) {
		Node tempNode = new Node();
		tempNode.setKey(key);
		tempNode.setValue(value);
		tempNode.setNextNode(null);
		tempNode.setPrevNode(null);
		return tempNode;
	}
	public Node addNode(Node startingNode, int data, ArrayList<LinkedList<Node>> a, int val ) {
		if(get( a, data))
				return startingNode;
			
		Node previousNode ;
		previousNode = startingNode;
		while(previousNode.getNextNode() != null){
			previousNode = previousNode.getNextNode();
		}
		Node currentNode = new Node();
		currentNode = createNode( val, data );
		currentNode.setPrevNode(previousNode);
		previousNode.setNextNode(currentNode);
		a.get(data%10000).add(currentNode);
		
		return startingNode;
	}
	public void print(Node startingNode) {
		Node iterate;
		iterate = startingNode;
		System.out.println("linkedHashmap is");
		while(iterate != null){
			
			System.out.print(iterate.getValue()+","+ iterate.getKey() + "->");
			iterate = iterate.getNextNode();
		}
	}
	public static void main(String agrs[]) {
		
		ArrayList<LinkedList<Node>> a = new ArrayList<LinkedList<Node>>(10000);
		for (int i = 0; i < 10000; i++) {
			LinkedList<Node> linkedList = new LinkedList<Node>();
			a.add(linkedList);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of linked hashmap: ");
		System.out.println();
		int n = sc.nextInt();
		int data;
		Node previousNode = new Node();
		LinkedHash linkedHash = new LinkedHash();
		System.out.print("enter key and values "+ n + " times than you can get and put ");
		data = sc.nextInt();
		int val = sc.nextInt();
		Node startingNode = new Node();
		startingNode = linkedHash.createNode( val, data );		
		a.get(data%10000).add(startingNode);
		previousNode = startingNode;
		
		for (int i = 1; i < n; i++) {
			data = sc.nextInt();
			Node currentNode = new Node();
			 val = sc.nextInt();
			currentNode = linkedHash.createNode( val, data );
			currentNode.setPrevNode(previousNode);
			previousNode.setNextNode(currentNode);
			a.get(data%10000).add(currentNode);
			previousNode = currentNode;
		}
		
		Node iterate ;
		iterate = startingNode;
		

		System.out.println("press 1 -> add element\npress 2-> get element\npress 3 -> print\npress 4 -> exit");
		
		boolean flag = true;
		while(flag) {
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("enter key and value: ");
				data = sc.nextInt();
				val = sc.nextInt();
				System.out.println();
				startingNode = linkedHash.addNode(startingNode, data, a , val) ;
				break;
			case 2: 
				System.out.print("enter value: ");
				data = sc.nextInt();
				System.out.println();
				if(linkedHash.get( a, data))
					System.out.println("present");
				else
					System.out.println("not present");
				break;
			case 3:
				linkedHash.print(startingNode);
				break;
			case 4:
				flag = false;
			}
		}

		
	}
	

}
