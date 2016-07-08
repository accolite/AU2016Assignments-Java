package assignment2;

import java.util.Scanner;

public class LinkedHashMap {
     int flag=0;
     
	public static void main(String args[])
	{
		ArrayCreate ac=new ArrayCreate();
		int i=0;
		while(true)
		{
		
	    System.out.println("enter your choice1)Push 2)get 3)ordering 4)exit");
	    int choice;
	    Scanner sc=new Scanner(System.in);
	    choice=sc.nextInt();
	    if(choice==1)
	    {
	    	
	    	System.out.println("Enter key and value");
	    	Scanner sc1=new Scanner(System.in);
	    	int key=sc.nextInt();
	    	int value=sc.nextInt();
	    	ac.push(key, value,i);
	    	i++;
	    }
	    else
	    {
	    	if(choice==2)
	    	{
	    	System.out.println("Enter key");
	    	Scanner sc1=new Scanner(System.in);
	    	int key=sc1.nextInt();
	    	int val=ac.get(key);
	    	System.out.println(val);
	    	}
	    	else if(choice==4)
		    {
		    	System.exit(0);
		    }
	    	else
	    	{
	    		System.out.println("order is");
	    		ac.ordering();
	    	}
	    }
	    
		} 
	    
	}
}
