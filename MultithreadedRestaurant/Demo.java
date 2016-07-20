package com.accolite.MultithreadedRestaurant;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable demo = new Demo();
		Thread demoThread = new Thread(demo,"demoThread");
		demoThread.start();
		//System.out.println("Hello");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from run");
		boolean exit = false;
		int bill = 0;
		int option = 0;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BillClass billClass = new BillClass();
		
		
		
		
		try{
		while(!exit){
			System.out.println("Please select an option \n 1. enter bill \n2.exit");
			option = Integer.parseInt(bufferedReader.readLine());
			//System.out.println(option);
			switch (option) {
			case 1:
				System.out.println("Enter bill value");
				bill = Integer.parseInt(bufferedReader.readLine());
				
				Runnable updaterClass = new UpdaterClass(billClass,bill);
				Thread updateBillThread = new Thread(updaterClass,"billUpdater");
				updateBillThread.start();
				//updateBillThread.join();
				break;
			//case 2:
				
				//reportThread.join();
				//break;
			case 2:exit = true;
				break;
			default:
				break;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
