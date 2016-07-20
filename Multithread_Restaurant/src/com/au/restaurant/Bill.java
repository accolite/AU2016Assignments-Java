package com.au.restaurant;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Bill implements Runnable {
	BlockingQueue B = null;

	public Bill(BlockingQueue B) {
		this.B = B;
	}

	@Override
	public void run() {
	
		boolean flag=true;
		
		while(flag){
			Scanner S=new Scanner(System.in);
			try {
				System.out.println("Enter the bill");
				double a=S.nextDouble();
				B.put(a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.currentThread().sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Add More-Yes/No");
			String d=S.next();
			if(d.equalsIgnoreCase("no")){
				flag=false;
			}
		}
		
	}

}
