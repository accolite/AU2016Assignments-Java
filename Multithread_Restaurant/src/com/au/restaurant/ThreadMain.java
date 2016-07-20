package com.au.restaurant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadMain {
	
	public static void main(String args[]){
		BlockingQueue B=new ArrayBlockingQueue(10);
		BlockingQueue N=new ArrayBlockingQueue(10);
		int count=0;
		double av=0.0;
		Average avg=new Average(av,count,B,N);
		Bill bill=new Bill(B);
		Output out=new Output(av,N);
		Thread avg_thread=new Thread(avg,"Average");
		Thread out_thread=new Thread(out,"Output");
		Thread bill_thread=new Thread(bill,"Bill");
		avg_thread.start();
		bill_thread.start();
		out_thread.start();
	}
}
