package com.accolite.linkhash;

import java.util.*;



public class linkhash {
	
	link_struct head;
	link_struct tail;
	 
	   
	
            linkhash()
            {
            	head=null;
            	tail=null;
            	
            }
            
         
      public void search(int k)
      {
    	  
      }
	public void create_list(int i ,int v)
	 {
		
		 link_struct l=new link_struct(i,v);
		if(head==null)
		 {
			System.out.println(" if part");
		 head=l;
		 tail=head;
		 }
		 else
		 {
			 link_struct p=head;
			 while( p!=tail)
			 {
				 p=p.next;
			 }
			 p.next=l;
			 System.out.println(p.key + p.value);
			 tail=l;
			 }	
		//add_array(l);
		 }
	
	
	public void display()
	{
		System.out.println("display according to insertation");
		link_struct l=head;
		while(l!=tail)
		{ 
			System.out.println(l.key + " @" + l.value);
			l=l.next;
		}
		System.out.println(tail.key + " @" + tail.value);
		System.out.println("display arraylist ");
		for(int i=0;i<arr.size();i++)
		    System.out.println(arr.get(i).key);
		
		     
	}
	{
		
		 //link_struct l1=new link_struct(1,12);
		 
	

				 
	 }
	
public static void main(String arg[])
{
	linkhash l=new linkhash();
			l.create_list(1,123);
			l.create_list(2,123);
			l.create_list(3,123);
			l.search(2);
			l.display();
	
}
	
	

}
