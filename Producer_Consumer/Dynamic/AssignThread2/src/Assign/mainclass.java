package Assign;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Generated;

public class mainclass {
	static int MAX=3;
	static int tot=5;
	static int step=1;
	int h;
	int ch;
	//static int choice;
	static String[] fruitlist;
	static int f,count,choice;
	static ConcurrentHashMap<String,Integer> chMap;
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public static void main(String[] args){
		chMap=new ConcurrentHashMap<>();
		fruitlist=new String[4];
		fruitlist[0]="Apple";
		fruitlist[1]="Orange";
		fruitlist[2]="Grape";
		fruitlist[3]="Watermelon";
		Producer p=new Producer(chMap);
		Consumer c=new Consumer(chMap);
		System.out.println("1:Produce 2:Consume");
		System.out.println("0:Apple 1:Orange 2:Grape 3:Watermelon");
		System.out.println("Produce/Consume   Fruit   Count");
		for (int i = 0; i < 4; i++) {
			chMap.put(fruitlist[i],0);
		}
		p.start();
		c.start();
		choice=0;
		Scanner sc=new Scanner(System.in);
		while(choice!=-1){
			choice=sc.nextInt();
			f=sc.nextInt();
			count=sc.nextInt();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
