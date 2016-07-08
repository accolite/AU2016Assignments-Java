import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ImplementingHashMap {

	public 
	int n;
	NodeofList headofList,previous;
	HashMap<String,Integer> hm;  
	LinkedList<NodeofList>[] l;
 	int hashFunc(String key)
	{
 		int hash = 7;
 		for (int i = 0; i < key.length(); i++) {
 		    hash = hash*31 + key.charAt(i);
 		}
		return hash%100001;
	}
 	int check(String key)
	{
 		int hash = 7;
 		for (int i = 0; i < key.length(); i++) {
 		    hash = hash*31 + key.charAt(i);
 		}
		return hash;
	}
	void put(ImplementingHashMap obj)
	{
		
		String Key,Val;
		System.out.println("Enter the key ");
		int index;
		NodeofList n;
		Scanner sc=new Scanner(System.in);
		
		Key=sc.next();
		if(hm.containsKey(Key))
		{
			System.out.println("Enter the value ");
			Val=sc.next();
			index=obj.hashFunc(Key);
			//n=new NodeofList(Key,Val,null);
			
			for(NodeofList iter:this.l[index])
			{
				if(iter.key.equals(Key))
				{	
					iter.value=Val;
					return ;
				}
			}

		}
		obj.n=(obj.n)+1;
		
		hm.put(Key,1);
		System.out.println("Enter the value ");
		Val=sc.next();
		index=obj.hashFunc(Key);
		n=new NodeofList(Key,Val,null);
		if(obj.n==1)
		{
			obj.headofList= n;
			previous=n;
			previous.nextElement=null;
			System.out.println(obj.n);
		}
			
		
		
		if(obj.previous!=null)
		{
			previous.nextElement=n;
			previous=n;
			
		}
		obj.l[index].add(n);
		
		/*for(int i=1;i<obj.n;i++)
		{
			//obj.l[index]=new LinkedList<NodeofList>();
			Key=sc.nextInt();
			Val=sc.nextInt();
			index=obj.hashFunc(Key,obj.n);
			
			
		    n=new NodeofList(Key,Val,null);
		    obj.l[index].add(n);
			
		}*/
	}
			
	void get()
	{
		String key;
		int index;
		System.out.println("Enter Key ");
		Scanner sc=new Scanner(System.in);
		key=sc.next();
		index=hashFunc(key);
		
		int fl=0;
		for(NodeofList iter:this.l[index])
		{
			if(iter.key.equals(key))
			{	
				System.out.println("Value for the key is "+iter.value);
				fl=1;
				break;
			}
		}
		if(fl==0)
			System.out.println("No Value Found ");
	}
	
	
	
	void iter()
	{	
		NodeofList h=headofList;
		int i=1;
		if(h==null)
			System.out.println("List is empty");
		if(this.n==1)
		{
			System.out.println("Element"+i+" is "+h.value);
			return ;
		}
		while(h!=null)
		{
			System.out.println("Element"+i+" is "+h.value);
			h=h.nextElement;
			i++;
		}
		
		return ;
	}
	
	public static void main(String[] args) {
		
		NodeofList n;
		int choice=1;
		ImplementingHashMap obj=new ImplementingHashMap();
		Scanner sc=new Scanner(System.in);
		obj.n=0;
		
		obj.hm=new HashMap<String ,Integer>();
		obj.l=new LinkedList[100001];
		for(int i=0;i<100001;i++)
		{
			obj.l[i]=new LinkedList<NodeofList>();
			
		}
		obj.previous=null;
		obj.headofList=null;
		while(choice!=4)
		{
			System.out.println("Enter choice\n\n1.Put 2.Get 3.Iter 4.Exit");
			choice=sc.nextInt();
			if(choice==1)
				obj.put(obj);
			else if(choice==2)
				obj.get();
			else if(choice==3)
				obj.iter();
			else 
				break;
		}
		
		
		
		
		
	}
	
}
