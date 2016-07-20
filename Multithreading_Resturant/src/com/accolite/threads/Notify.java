package com.accolite.threads;

import java.util.ArrayList;

public class Notify implements Runnable{

	private ArrayList<Integer> chng;
	
	Notify(ArrayList<Integer> b)
	{
	   chng=b;
	}
	@Override
	public void run() {
		
         
		change();  
		System.out.println("Manager got Information about average" );
		
	}
	private synchronized void change() {
		
 		try
 		{
		while(chng.get(0) == -1)
 				 wait(1000);
 		    }catch (InterruptedException e) {
 	            e.printStackTrace();
 		    } 
 		
	}

}
