package linkedhashmap;
import java.util.*;
class map 
{
	ArrayList<Integer> a =new ArrayList<Integer>();
	HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
	public void get(int x)
	{
		System.out.println(h.get(x));
	}
	public void put(int x,int y)
	{
		h.put(x, y);
		a.add(x);
	}
	public void iterator()
	{
		for(int x:a)
			System.out.println(h.get(x));
	}
}

public class lhashmap
{
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