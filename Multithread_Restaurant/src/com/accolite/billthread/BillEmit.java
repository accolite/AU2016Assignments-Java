package com.accolite.billthread;

public class BillEmit extends Thread{

		float bill;
		//boolean emit_bill;
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
					
					System.out.println("Bill of " + bill + ""+"unit was generated");
					//emit_bill = false;
					}
				}
				
			
		}
		public void receive(float value)
		{
			synchronized (this) {
				this.bill = value;
				//this.emit_bill = true;
				notify();
			}
		
		}
		public float getBill()
		{
			return this.bill;
		}
}
