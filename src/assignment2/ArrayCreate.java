package assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayCreate 
{
	
	item save;
	item order;
	LinkedList<item> a[]=new LinkedList[100];
	
	void push(int k,int value,int x)
	{
		
		item i1=new item();
		i1.key=k;
		i1.value=value;
		
		if(a[k%100]==null)
		{
			LinkedList<item> l=new LinkedList<item>();
			i1.iprev=null;
			i1.inext=null;
		    a[k%100]=l;
		    l.add(i1);
		    save=i1;
		   
		}
		else
		{
			LinkedList<item> l=new LinkedList<item>();
			save.inext=i1;
			save=i1;
			i1.iprev=null;
			i1.inext=null;
            a[k%100].add(i1);
            
		}
		if(x==0)
		{
			order=i1;
		}
		

		
	}
	int get(int k)
	{
		LinkedList<item> i3=a[k%100];
		Iterator<item> itr=i3.iterator();
		int val=0;
		while(itr.hasNext())
		{
			item temp=itr.next();
			if(temp.key==k)
			{
				val=temp.value;
				break;
			}
		}
		return val;
		
		
	}
	
	void ordering()
	{
		item itr=order;
		while(itr!=null)
		{
			System.out.println(itr.key+"   "+itr.value+"\n");
			itr=itr.inext;
		}
	}
	
	
	

}
