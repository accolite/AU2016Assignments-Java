package com.accolite.linkhash;

import java.util.*;



public class linkhash {
	
	link_struct head;
	link_struct tail;
	arr_str a=new arr_str();
	   
	
            linkhash()
            {
            	head=null;
            	tail=null;
            	
            }
            
         
      public void search(int k)
      {
    	  a.find(k);
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
		a.add_array(l);
		System.out.println(" after adding");
		a.disply_arr();
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
		
       System.out.println(" harsh table");
		   a.disply_arr();   
	}
	{
		

		 
	

				 
	 }
	
public static void main(String arg[])
{
	linkhash l=new linkhash();
			l.create_list(1,123);
			l.create_list(2,123);
			l.create_list(3,123);
			l.search(3);
			l.create_list(3,125);
			l.search(3);
			l.search(2);

	
}
	
	

}
