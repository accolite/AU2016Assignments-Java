package com.accolite.linkedHashMap;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedHashMap {
   Node Head;
   ArrayList<Node>list;
   int[] hashCodesPositions = new int[100000];
   LinkedHashMap(){
	   list = new ArrayList<>();
	   Head = new Node(null,null,null,null);
	   list.add(Head);
   }
   
   public void put(Object key,Object value){
	   int curr_pos = 0;
	   Node p = Head;
	   while(p.next_addr != null){
		   p = p.next_addr;
		   curr_pos++;
	   }
	   curr_pos++;
	   Node newNode = new Node(key,value,p,null);
	   //Map map = new Map(newNode,newNode.hashCode());
	   p.next_addr = newNode;
	   //System.out.println(key.hashCode()+" "+key.hashCode()%99991);
	   hashCodesPositions[key.hashCode()%99991] = curr_pos;
	   list.add(newNode);
   }
   
   public Object get(Object key){
	   int pos = hashCodesPositions[key.hashCode()%99991];
	   return list.get(pos).value;
   }
   
   public void iterate(){
	   Node p = Head;
	   while(p.next_addr != null){
		   p = p.next_addr;
		   System.out.println(p.key+" "+p.value);
	   }
   }
   
   public static void main(String... args){
	   LinkedHashMap newMap = new LinkedHashMap();
	   boolean answer = true;
	   while(answer == true){
		   System.out.println("Choose 1 for put 2 for get 3 for iteration and n for stopping");
		   Scanner in = new Scanner(System.in);
		   char choice = in.next().charAt(0);
		   switch(choice){
		     case '1':
		    	 System.out.println("Enter key and value");
		    	 int key = in.nextInt();
		    	 int value = in.nextInt();
		    	 newMap.put(key,value);
		    	 break;
		     case '2':
		    	 System.out.println("Enter key");
		    	 key = in.nextInt();
		    	 System.out.println("value is "+newMap.get(key));
		    	 break;
		     case '3':
		    	 newMap.iterate();
		    	 break;
		     default:
		    	 answer = false;
		   }
	   }
	   
   }
}
