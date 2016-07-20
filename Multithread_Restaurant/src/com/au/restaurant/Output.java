package com.au.restaurant;

import java.util.concurrent.BlockingQueue;

public class Output implements Runnable{
	double av;
	BlockingQueue N;
	public Output(double av,BlockingQueue N){
		this.av=av;
		this.N=N;
	}
	@Override
	public void run() {
		while(true){
			try {
				double newAver=(double) N.take();
				if(newAver!=av){
					System.out.println("New Average is:-"+newAver);
				}
				av=newAver;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
