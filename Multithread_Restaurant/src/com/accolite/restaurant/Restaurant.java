package com.accolite.restaurant;

import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int tableNumber;
		int tableAmount;
		
		while(true)
		{
			//Enter 1 to give Bill Amount (-1 when no bill amount)
			int userOption=scanner.nextInt();
			
			if(userOption==1)
			{
				System.out.println("Enter table number:");
				tableNumber=scanner.nextInt();
				System.out.println("Enter table's Bill Amount:");
				tableAmount=scanner.nextInt();
				BillAmount billAmount=new BillAmount(tableNumber, tableAmount);
				billAmount.setPriority(7);
				billAmount.start();
				
				AverageBillAmount avgBillAmt=new AverageBillAmount(billAmount);
				avgBillAmt.setPriority(5);
				avgBillAmt.start();
				
				try {
					billAmount.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Owner owner=new Owner(avgBillAmt);
				owner.setPriority(2);
				owner.start();
				
				
			}
			else if(userOption==-1)
				break;
			
		}
		scanner.close();
			
		
	}

}
