package com.accolite.multithreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
	
	Bill bill;
	
	ExecutorService exec = Executors.newCachedThreadPool();
	
	GenerateBill genbill=new GenerateBill(this);
	CalcAverageBill calcavgbill=new CalcAverageBill(this);
	ReportToOwner reportToOwner=new ReportToOwner(this);
	

	public Restaurant()
	{
		exec.execute(genbill);
		exec.execute(calcavgbill);
		exec.execute(reportToOwner);
	}
	public static void main(String[]args)
	{
		
		
		new Restaurant();
	}
}
