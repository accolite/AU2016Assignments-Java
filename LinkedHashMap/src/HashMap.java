/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

// TODO: Auto-generated Javadoc
/**
 * The Class HashMap.
 */
public class HashMap {
	
	/** The prev node. */
	Node prevNode;
	
	/** The first time flag. */
	boolean firstTimeFlag;
	
	/** The bucket. */
	ArrayList<LinkedList<Node>> bucket; 
	
	/**
	 * Instantiates a new hash map.
	 */
	public HashMap(){
		bucket = new ArrayList<LinkedList<Node>>(1000);
		
		for(int i=0;i<1000;i++)
		{
			LinkedList<Node> tmp = new LinkedList<Node>();
			bucket.add(tmp);
		}
		prevNode = null;
		firstTimeFlag = true;
		
	}
	
	/**
	 * Adds the.
	 *
	 * @param number the number
	 * @param key the key
	 */
	public void add(int number, int key){
		
		int hash = key % 997;
		if(firstTimeFlag){
			
			Node tmpNode = new Node(key, number , prevNode ,null);
			prevNode = tmpNode;
			bucket.get(hash).add(tmpNode);
			
			firstTimeFlag = false;
		
		}
		else{
			
			
			ListIterator<Node> listIterator = bucket.get(hash).listIterator();
			
			while(listIterator.hasNext())
			{
				
				Node tmp = listIterator.next();
				if(tmp.getKey() == key)
				{
					tmp.setValue(number);
					
				}
				
			}
			
			Node tmpNode = new Node(key, number , prevNode ,null);
			prevNode.setNext(tmpNode);
			prevNode = tmpNode;
			bucket.get(hash).add(tmpNode);
			
		}
		
	}
	
	/**
	 * Gets the number.
	 *
	 * @param key the key
	 * @return the number
	 */
	public int getNumber(int key){
		
		int hash = key % 997;
		
		ListIterator<Node> listIterator = bucket.get(hash).listIterator();
		
			
		while(listIterator.hasNext())
		{
			
			Node tmp = listIterator.next();
			if(tmp.getKey() == key)
			{
				return tmp.getValue();
				
			}
			
		}
	
		return -1;
	}
	
}
