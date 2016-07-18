package Assign;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public class Consumer extends Thread {
	ConcurrentHashMap<String,Integer> f;
	String fruit;
	Consumer(ConcurrentHashMap<String,Integer> chm){
		f=chm;
	}
	public void run(){
		while(true){
			while(mainclass.choice!=2){
				try {
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			mainclass.choice=0;
			fruit=mainclass.fruitlist[mainclass.f];
			if(f.get(fruit)==0){
				System.out.println(" consumer waiting for "+fruit);
				//return;
			}
			else if(f.get(fruit)-mainclass.count>=0){
				f.put(fruit, f.get(fruit)-mainclass.count);
				System.out.println(fruit+" consumed to count "+f.get(fruit));
			}
			else{
				f.put(fruit, 0);
				System.out.println(fruit+" consumed to count "+f.get(fruit)+" and waiting for rest");
			}
		}
		
	}
	/*
	public synchronized void add(String fruit){
		//System.out.print("Step : "+main)
		if(f.get(fruit)==mainclass.MAX){
			System.out.println(" producer waiting for "+fruit);
			return;
		}
		f.put(fruit, f.get(fruit)+1);
		System.out.println(fruit+" produced to count "+f.get(fruit));
	}
	*/
}
