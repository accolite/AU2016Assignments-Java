package com.accolite.billthread;

public class BillAverage extends Thread{
		float cur_average;
		float new_average;
		int count;
		//boolean comp_average;
		boolean avg_change;
		public void run()
		{
			while (true)
			{
				synchronized(this){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				if(new_average == cur_average)
					System.out.println("Average is the same " + new_average);
				if(new_average != cur_average)
				{
					System.out.println("Average got changed to " + new_average);
					this.avg_change = true;
				}
				else
				{
					this.avg_change = false;
				}
				cur_average = new_average;
				//comp_average = false;
				}
			}
		}
		public void compute(float value)
		{
			synchronized (this) {
				
			if(cur_average == 0)
			{
				new_average = value / (++count);
			}
			else
			{
				new_average = ((cur_average * count) + value) / (count + 1);
				count++;
			}
			//this.comp_average = true;
			notify();
			}
		}
		public boolean getChange()
		{
			return this.avg_change;
		}
		public float retAvg()
		{
			
			return this.cur_average;
		}
}
