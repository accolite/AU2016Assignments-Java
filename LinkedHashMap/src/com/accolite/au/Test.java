package com.accolite.au;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
	NewElement previous;
	NewElement head;
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
		int flag=0;
		int h=key%100;
		LinkedList<NewElement> list = linkedHashMap.get(h);
	
		for (NewElement newElement1 : list) {
				if(newElement1.getKey()==key){
					newElement1.setValue(value);
					flag=1;
				}
		}
		
		if(flag==1){
			//do nothing
		}
		else{
			NewElement newElement=new NewElement();
			if(previous==null){
				head=newElement;
			}
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
		
	}
	
	public Object get(int key){
		int h=key%100;
		Object object = new Object();
		object=null;
		LinkedList<NewElement> list = linkedHashMap.get(h);
		
		if(list.size()==0){
			System.out.println("No such value found corresponding to key");
		}
		else{
			for (NewElement newElement : list) {
				if(newElement.getKey()==key){
					object=newElement.getValue();
				}
				else{
					System.out.println("No such value found corresponding to key");
				}		
			}
		}	
		return object;	
	}
	
	
	public void iterateAll(){
		NewElement temp=head;
		if(head==null){
			System.out.println("No element found");
		}
		else{
			while(temp!=null){
				System.out.println("Key: "+temp.getKey()+"  Value: "+temp.getValue());
				temp=temp.getNext();
			}
			
		}
	}
	public static void main(String arg[]){
		
		Test test=new Test();
		int choice;
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("Select:\n 1)put(K,V)\n 2)get(K) \n 3)Iterate all element \n 4)Exit");
			choice=input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("How many entries do you want to add");
				int no=input.nextInt();
				for(int i=0;i<no;i++){
					System.out.println("Enter Key"+(i+1));
					int k=input.nextInt();
					System.out.println("Enter Value"+(i+1));
					Object v=input.next();
					test.put(k, v);
				}
				
				break;
			case 2:
				Object object;
				System.out.println("Enter Key");
				int k1=input.nextInt();
				object = test.get(k1);
				if(object!=null)
					System.out.println("Key: "+k1+"  Value: "+object);
				break;
			case 3:
				test.iterateAll();
				break;

			default:
				break;
			}
			if(choice==4){
				break;
			}
		}
		input.close();
	}
	
	

}
