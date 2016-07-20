package com.accolite.billthread;

public class BillReport extends Thread {

		//boolean report;
		float my_avg;
		public void run()
		{
			
			while(true)
			{
				synchronized(this){
			
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				System.out.println("Hey Manager - The average seems to be changed to:" + my_avg );
				//report = false;
				}
			}
			
		}
		public void receiveNotify(float value)
		{
			synchronized (this) {
			//this.report = true;
			this.my_avg = value;
			notify();
			}
		}	
		
}
