package com.accolite.au;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
	NewElement previous;
	ArrayList<LinkedList<NewElement>> linkedHashMap=new ArrayList<LinkedList<NewElement>>(100);
	
	Test() {
		previous=null;
		for(int i=0;i<100;i++){
			LinkedList<NewElement> linkedList=new LinkedList<NewElement>();
			linkedHashMap.add(linkedList);
		}
		// TODO Auto-generated constructor stub
	}
	

	
	public void put(int key, Object value){

		
		NewElement newElement=new NewElement();
		//NewElement lastElement=null;
		int k=newElement.hashval(key);
		linkedHashMap.get(k).add(newElement);
		newElement.setKey(key);
		newElement.setValue(value);
		newElement.setNext(null);
		newElement.setPrevious(previous);
		if(previous!=null){
			previous.setNext(newElement);
		}
		previous=newElement;
	}
	
	public Object get(int key){
		int h=key%100;
		linkedHashMap.get(h)
		while()
		
	}
	
	

}
