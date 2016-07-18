package com.accolite.thread;

import java.util.ArrayList;
import java.util.Scanner;

public class market {

	
	private ArrayList<String> apple = new ArrayList<>();
	private ArrayList<String> orange = new ArrayList<>();
	private ArrayList<String> grape = new ArrayList<>();
	private ArrayList<String> watermelon = new ArrayList<>();
	
	market()
	{
		for(int i=0;i<5;i++)
		{
			apple.add(i, null);
			orange.add(i,null);
	
		}
	}		
	
	consumer c=new consumer(apple,orange,grape,watermelon);
	public  Thread ct=new Thread(c,"consumer");
	
	producer p=new producer(apple,orange,grape,watermelon);
	public   Thread pt=new Thread(p,"producer");
	
	
	
	public static void main(String args[])
	{
		 market m=new market();

		while(true)
		{
		System.out.println("\n 1.producer \n 2. consumer \n 3.exist");
         Scanner scanner = new Scanner(System.in);  
         int choice=(scanner.nextInt());
        
         if(choice == 3)
        	 break;
         switch(choice)
         {
         case 1: 
        	     m.pt.run();
                break;
         case 2:m.ct.run();
                 break;
         }
         
         }
	}
}
