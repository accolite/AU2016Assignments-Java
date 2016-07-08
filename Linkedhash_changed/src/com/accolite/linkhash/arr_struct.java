package com.accolite.linkhash;

import java.util.ArrayList;

class arr_str
{
	   ArrayList<link_struct> arr =new ArrayList<>();
	   arr_str()
	   {
		   link_struct l=new link_struct(0,0);
		   for(int i=0;i<10;i++)
    		arr.add(i,l);
	   }
	   
	   public void add_array(link_struct l)
	{
		int hash=l.key%10;
		System.out.println("hash is "+hash);
	    arr.set(hash, l);
		
		
	}  
	   public void disply_arr()
	   {
		   System.out.println("size is " + arr.size());
		   for(int i=0;i<arr.size();i++)
			   System.out.println(arr.get(i).key);
	   }
	   public void find(int k)
	   {
		   
		   int hash=k%10;
		   System.out.println("value of key "+arr.get(hash).key +" is " + arr.get(hash).value);
		   
	   }
}
