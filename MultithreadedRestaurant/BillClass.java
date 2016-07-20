package com.accolite.MultithreadedRestaurant;

import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;

public class BillClass {
	ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(5);
	double avg = 0, prevAvg = 0;
	int count = 0;
	
	public boolean updateAvg(){
		int num = 0;
		int size = 0;
		boolean startReporter = false;
		size = abq.size();
		try{
		while(size -- > 0){
			prevAvg = avg;
			num = (int) (abq.take());
			count++;
			avg = ((avg * (count-1))+num)/count;
		}
		startReporter = checkIfAvgUpdated();
		return startReporter;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public boolean checkIfAvgUpdated(){
		while(true){
			if(prevAvg != avg){
				return true;	
		}
			System.out.println("checking avg");
			return false;
			}
	}
	public void addBillItem(int i){
		try {
			abq.put(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
