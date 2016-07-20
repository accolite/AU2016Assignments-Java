package com.accolite.threads;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {

private ArrayList<Integer> balance =new ArrayList<Integer>(1);
private ArrayList<Integer> chnaged_indicate = new ArrayList<Integer>(1);

Average avg=new Average(balance);
public  Thread avg_t=new Thread(avg,"Average");


Notify notifyclass=new Notify(chnaged_indicate);
public   Thread not_t=new Thread(notifyclass,"notify");


Restaurant()
{
	balance.add(0,0);
	chnaged_indicate.add(0,-1) ;
}

public static void main(String args[])
{
    Restaurant restaurant =new Restaurant();
    int amt,sum;
	while(true)
	{
	System.out.println("\n 1.Bill amount \n 2. Average \n 3.Interrupt");
     Scanner scanner = new Scanner(System.in);  
     int choice=(scanner.nextInt());
    
     if(choice == 3)
     {
    	 System.out.println("Terminating.....");
    	 break;
     }
      switch(choice)
     {
     case 1:	
     			//
     			System.out.println("Enter the bill amount ");
     			amt=scanner.nextInt();
     			sum=restaurant.balance.get(0);
     			//System.out.println("previous element is");
     			sum=sum+amt;
     			restaurant.balance.add(0,sum);
     			System.out.println(restaurant.balance.get(0));
     			restaurant.avg_t.run();
     			restaurant.chnaged_indicate.add(0,1);
     			restaurant.not_t.run();
     		
     			break;
     			
     }
     
     }
}
}
