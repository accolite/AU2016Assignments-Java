package com_accolite_au16_multiThread_restaurent;

import java.util.Scanner;

public class Restaurent {
	public static void main(String[] args) {
		Bill bill=new Bill();
		EmitBill emitBill=new EmitBill(bill);
		
		//CalculateAvarageBill calculateAvgBill= new CalculateAvarageBill(bill);
		//NotifyOwner notifyOwner=new NotifyOwner(calculateAvgBill);
		Thread t1= new Thread(emitBill);
		//Thread t2= new Thread(calculateAvgBill);
		//Thread t3= new Thread(notifyOwner);
		t1.start();
		//t2.start();
		//t3.start();
		boolean flag= true;
		Scanner in = new Scanner(System.in);
		while(flag)
		{
		System.out.println("wants to enter new bill amount enter 1");
		int choice=in.nextInt();
		if(choice==1)
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			flag=false;
		
	}
		//in.close();
	}
}


