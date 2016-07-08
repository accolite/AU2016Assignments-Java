package com.accolite.mycollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MyLinkedHashMap {
	private ArrayList<LinkedList<MyData>> linkedHashMap;
	MyData lastElement,Head;
	boolean firstElement;
	private int index;
	private int size;
	private int initialSize = 10;
	public MyLinkedHashMap() {
		firstElement = true;
		index = 0;
		size = initialSize;
		lastElement = null;
		linkedHashMap = new ArrayList<LinkedList<MyData>>(initialSize);
		for(int i = 0; i < initialSize; i++){
			linkedHashMap.add(new LinkedList<MyData>());
		}
		// TODO Auto-generated constructor stub
	}
	
	public MyLinkedHashMap(int size){
		this.size = size;
		index = 0;
		lastElement = null;
		initialSize = this.size;
		linkedHashMap = new ArrayList<LinkedList<MyData>>(initialSize);
	}
	
	private MyData duplicateElement(Object key){
		index = (key.hashCode() % size);
		LinkedList<MyData> myLinkedList;
		myLinkedList = linkedHashMap.get(index);
		Iterator<MyData> iterator = myLinkedList.iterator();
		MyData myDataObj;
		while(iterator.hasNext()){
			myDataObj = iterator.next();
			if(myDataObj.getKey().toString().equals(key.toString()) ){
				System.out.println(myDataObj.getValue());
				System.out.println(myDataObj.getKey());
				return myDataObj;
			}
		}
		return null;
	}
	
	public boolean add(Object key, Object value){
		System.out.println(firstElement);
		if(!firstElement){
			System.out.println("I am not first Element");
			if(get(key) == null){
				MyData mydata = new MyData(lastElement,key,value,null);
				//lastElement.setNext(mydata);
				if(!firstElement){
					lastElement.setNext(mydata);
				}
				lastElement = mydata;
				index = key.hashCode() % size; 
				linkedHashMap.get(index).addFirst(mydata);
				if(firstElement){
					Head = mydata;
					firstElement = false;
				}
				return false;
			}
			else{
				MyData myData = duplicateElement(key);
				/*MyData prev = myData.getPrev();
				MyData next = myData.getNext();
				prev.setNext(next);
				next.setPrev(prev);
				lastElement.setNext(myData);
				myData.setPrev(lastElement);
				myData.setValue(value);
				myData.setNext(null);*/
				myData.setValue(value);
			}
		}
		else{
			System.out.println("I am first Element");
			MyData mydata = new MyData(lastElement,key,value,null);
			//lastElement.setNext(mydata);
			if(!firstElement){
				lastElement.setNext(mydata);
			}
			lastElement = mydata;
			index = key.hashCode() % size; 
			linkedHashMap.get(index).addFirst(mydata);
			if(firstElement){
				Head = mydata;
				firstElement = false;
			}
			return false;
		}
		return false;
	}
	
	public boolean print(){
		MyData temp = Head;
		while(temp != null){
			System.out.println("key : "+temp.getKey()+" value : "+temp.getValue());
			temp = temp.getNext();
		}
		return true;
	}
	public Object get(Object key){
		System.out.println("I am in get");
		index = (key.hashCode() % size);
		LinkedList<MyData> myLinkedList;
		System.out.println(index);
		myLinkedList = linkedHashMap.get(index);
		Iterator<MyData> iterator = myLinkedList.iterator();
		MyData myDataObj;
		while(iterator.hasNext()){
			System.out.println("I am in get Iterator");
			myDataObj = iterator.next();
			if(myDataObj.getKey().toString().equals(key.toString()) ){
				System.out.println(myDataObj.getValue());
				return myDataObj.getValue();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		MyLinkedHashMap myObj = new MyLinkedHashMap();
		boolean exit=false;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		int choice;
		String key,value;
		try{
		while(!exit){	
			System.out.println("Enter the option 1) insert \n2) see entries \n3)get value \n4)Exit");
			choice = scanner.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter key and value");
					key = bReader.readLine();
					value = bReader.readLine();
					myObj.add(key,value); 
					break;
				case 2: myObj.print();
					break;
				case 3: key = bReader.readLine(); 
					myObj.get(key);
				case 4: exit = true;
				break;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
