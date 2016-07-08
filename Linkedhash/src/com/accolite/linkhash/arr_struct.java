package com.accolite.linkhash;

import java.util.ArrayList;

class arr_str
{
	   ArrayList<link_struct> arr =new ArrayList<>();
	   arr_str()
	   {
		   for(int i=0;i<arr.size();i++)
    		arr.add(i,head);
	   }
	   
	   public void add_array(link_struct l)
	{
		ArrayList<link_struct> arr=new ArrayList<>();
		int hash=l.key%10;
		System.out.println(hash);
		
	}  
}
