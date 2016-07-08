package pkg;

import java.util.*;
class node
{
	static node head;
	static node tail;
	int key;
	int value;
	node next;
	void put (int x,int y)
	{
		node obj =new node();
		obj.value=y;
		obj.key=x;
		obj.next=null;
		if(head==null)
		{
			head=obj;
			tail=obj;
		}
		else
		{
			tail.next=obj;
			tail=obj;
		}
	}
	void iterate()
	{
		for(node obj=head;obj!=null;obj=obj.next)
			System.out.println(obj.key+" "+obj.value);
	}
}
class map 
{
	int h[]=new int[100];
	node obj =new node();
	public void get(int x)
	{
		System.out.println(h[x]);
	}
	public void put(int x,int y)
	{
		h[x]=y;
		obj.put(x,y);
	}
	public void iterator()
	{
		obj.iterate();
	}
}

public class nodeclass {
	public static void main(String args[])
	{
		map obj=new map();
		boolean b=true;
		Scanner i = new Scanner(System.in);
		while(b)
		{
			System.out.println("Enter 1.Get 2.put 3.iterate");
			
			int c= i.nextInt();
			switch(c)
			{
			case 1:
				System.out.println("enter the key");
				c=i.nextInt();
				obj.get(c);
				break;
			case 2:
				System.out.println("enter the key and value to put");
				c=i.nextInt();
				int d=i.nextInt();
				obj.put(c, d);
				break;
			case 3:
				System.out.println("entire series");
				obj.iterator();
			}
			System.out.println("Want to continue 1/2");
			c=i.nextInt();
			if(c==2)
				b=false;
		}
	}

}
