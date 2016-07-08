/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.accolite.collectionimplementations;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedHashMap.
 */
public class LinkedHashMap implements LinkedHashMapInterface {

	/** The Constant MAX_SIZE. */
	private static final int MAX_SIZE = 10;
	
	/** The AL index. */
	private int ALIndex;
	
	/** The prev entry pointer. */
	Entry prev_entry_pointer = null;
	
	/** The head. */
	Entry HEAD = null;
	
	/** The first element. */
	boolean firstElement;
	
	/** The linkedhashmap. */
	ArrayList<LinkedList<Entry>> linkedhashmap = new ArrayList<LinkedList<Entry>>( MAX_SIZE );
	
	/**
	 * Instantiates a new linked hash map.
	 */
	public LinkedHashMap() 
	{
		for( short i = 0; i < MAX_SIZE; i++ )
		{
			linkedhashmap.add( new LinkedList<Entry>() );
		}
	}

	/* (non-Javadoc)
	 * @see com.accolite.collectionimplementations.LinkedHashMapInterface#putEntry(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void putEntry(Object key, Object value) 
	{
		
		if( getEntry(key) != null )
		{
			Entry curr = (Entry) getEntry( key );
			
			//UNCOMMENT FOR BEHAVIOUR WHERE KEY VALUE UPDATION FOR THE SAME KEY CHANGES THE ORDER OF NEXT AND PREVIOUS
			
			/*Entry prev = (Entry) curr.getPrevious_entry();
			Entry next = (Entry) curr.getNext_entry();
			prev.setNext_entry(curr.getNext_entry());
			next.setPrevious_entry( curr.getPrevious_entry() );
			curr.setNext_entry( null );
			next.setNext_entry( curr );
			curr.setPrevious_entry( next ); */
			curr.setValue( value );
		}
		else
		{
			ALIndex = key.hashCode() % MAX_SIZE;
			Entry entry = new Entry();
			entry.setKey(key.toString());
			entry.setValue(value.toString());
			entry.setNext_entry( null );
			entry.setPrevious_entry( prev_entry_pointer );
			if( firstElement )
				prev_entry_pointer.setNext_entry( entry );
			prev_entry_pointer = entry;
			if( firstElement == false )
			{
				HEAD = entry;
				firstElement = true;
			}
			linkedhashmap.get( ALIndex ).addFirst( entry );
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.accolite.collectionimplementations.LinkedHashMapInterface#printLinkedHashMap()
	 */
	public void printLinkedHashMap()
	{
		for( short i = 0; i < MAX_SIZE; i++ )
		{
			LinkedList<Entry> temp = linkedhashmap.get( i );
			System.out.println(" INDEX : " + i );
			for( Entry e : temp )
			{
			    System.out.println(e.getKey());
			    System.out.println(e.getValue());
			    System.out.println(e.getPrevious_entry());
			    System.out.println(e.getNext_entry());
			    
			}
		}
		System.out.println( "Printing in order ");
		Entry Start = HEAD, currEntry = null;
		while( Start != null )
		{
			currEntry = (Entry) Start; 
			System.out.println(currEntry.getKey());
		    System.out.println(currEntry.getValue());
		    System.out.println("\n\n\n");
		    Start = (Entry) Start.getNext_entry();
		}
	}
	


	/* (non-Javadoc)
	 * @see com.accolite.collectionimplementations.LinkedHashMapInterface#getEntry(java.lang.Object)
	 */
	@Override
	public Object getEntry(Object key) 
	{
		ALIndex = key.hashCode() % MAX_SIZE;
		LinkedList<Entry> temp = linkedhashmap.get( ALIndex );
		for( Entry e : temp )
		{
			if( e.getKey().equals( key.toString() ) )
				return e;
		    
		}
		return null;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LinkedHashMap lhm = new LinkedHashMap();
		String key, value;
		int choice;
		while( true )
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("Enter a choice 1)Put 2)Get 3)PrintTableInOrder");
		    choice = in.nextInt();
		    switch(choice)
		    {
		    	case 1:
		    		key = in.nextLine();
		    		System.out.println("Enter the key");
		    		key = in.nextLine();
		    		System.out.println("Enter the value");
		    		value = in.nextLine();
		    		lhm.putEntry( key, value);
		    		break;
		    	case 2:
		    		key = in.nextLine();
		    		System.out.println("Enter the key");
		    		key = in.nextLine();
		    		Entry temp = (Entry) lhm.getEntry(  key );
		    		if( temp != null )
		    		{
		    			System.out.println("Corresponding value is");
		    			System.out.println( temp.getValue() );
		    		}
		    		else
		    			System.out.println( "Key does next exist" );
		    		break;
		    	case 3:
		    		lhm.printLinkedHashMap();
		    		break;
		     }
			
		}
		
	}

}
