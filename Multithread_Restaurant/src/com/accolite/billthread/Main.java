package com.accolite.billthread;

import java.util.Scanner;

public class Main {

		public static void main(String[] args) throws InterruptedException
		{
			BillEmit bill_emitter = new BillEmit();
			bill_emitter.setName("Billing");
			
			BillAverage bill_average = new BillAverage();
			bill_average.setName("Average");
			
			BillReport bill_report =  new BillReport();
			bill_report.setName("Report");
			
			Scanner input = new Scanner(System.in);
			bill_emitter.start();
			
			bill_average.start();
			
			bill_report.start();
			int choice;
			while(true)
			{
				System.out.println("1.Generate Bill\n2.Exit");
				choice = input.nextInt();
				switch(choice)
				{
				case 1:
						
						System.out.println("Enter the bill amount");
						bill_emitter.receive(input.nextFloat());
						
						bill_average.compute(bill_emitter.getBill());
						Thread.currentThread().sleep(100);
						boolean status = bill_average.getChange();
						if(status)
						{
							
							bill_report.receiveNotify(bill_average.retAvg());
						}
						
					break;
					
				default:
					break;
					
				}
				if(choice == 2)
					System.exit(0);
				
				
			}
			
		}
}
