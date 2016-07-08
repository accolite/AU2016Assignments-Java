import java.util.Scanner;

public class LinkedHashMap {
	public static final int SIZE=16;
	public static entryNode table[]=new entryNode[SIZE];
	public static entryNode headElement=null;
	public LinkedHashMap() {
		// TODO Auto-generated constructor stub
	}
	public static void put(Object key,String value)
	{
		int hashvalue=key.hashCode();entryNode insertPointForNewKey=null;
		int bucket=hashvalue % SIZE;
		entryNode existingKey=table[bucket];
		while(existingKey!=null)
		{
			if(existingKey.keyValue.equals(key))
			{
				System.out.println("Key Value Pair is Duplicate Replacing the previous one with this one");
				if(insertPointForNewKey!=null)
				{
					insertPointForNewKey.linkNext=existingKey.linkNext;
					if(existingKey.linkNext!=null)
					existingKey.linkNext.linkPrevious=insertPointForNewKey;
				}
				else
				{
					if(headElement==existingKey)
					{
						if(existingKey.next!=null)
							headElement=existingKey.next;
						else
							headElement=null;
						
					}
						
					existingKey=existingKey.next;
					table[bucket]=existingKey;
				}
				break;
			}
			 insertPointForNewKey=existingKey;
			existingKey=existingKey.next;
		}
		if(insertPointForNewKey!=null)
		{
			entryNode newNode=new entryNode(key,value);
			insertPointForNewKey.next=newNode;
			insertPointForNewKey.linkNext=newNode;
			newNode.linkPrevious=insertPointForNewKey;
			insertPointForNewKey.linkNext=newNode;
		}
		else
			{
			insertPointForNewKey=new entryNode(key,value);
			if(headElement==null)
				headElement=insertPointForNewKey;
			if(table[bucket]==null)
				table[bucket]=insertPointForNewKey;
			
			insertPointForNewKey.linkNext=null;
			insertPointForNewKey.linkPrevious=null;
			}
		
	}
	public static void get(Object key)
	{
		int hash=key.hashCode();
		int bucket=hash % SIZE;int found=0;
		entryNode existingElement=table[bucket];
		while(existingElement!=null)
		{
			if(existingElement.keyValue==key)
				{
				System.out.println("Value of"+key+"is:"+existingElement.Value);
				found=1;
				break;
				}
			
				existingElement=existingElement.next;
		}
		if(found==0)
			System.out.println("Key Value Not Present");
	}
	public static void printInCorrectOrder()
	{
	if(headElement==null)
		System.out.println("Empty List No values entered");
	else
	{
		while(headElement!=null)
		{
			System.out.println(headElement.keyValue+" "+headElement.Value);
			headElement=headElement.linkNext;
		}
	}
	}
public static void main(String[] args)
	{
		System.out.println("No of key value pairs to be input");
		Scanner scanner = new Scanner(System. in); 
		int n=scanner.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Key Value Pair");
			Object obj=scanner.next();
			String val=scanner.next();
			put(obj,val);	
		}
		System.out.println("Enter Value to  be searched");
		Object val1=scanner.nextInt();
		//3
		//get(val1);
		printInCorrectOrder();
		
	}
}

