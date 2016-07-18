package Assign;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Producer extends Thread {
	ConcurrentHashMap<String,Integer> f;
	String fruit;
	Producer(ConcurrentHashMap<String,Integer> chm){
		f=chm;
	}
	public void run(){
		while(true){
			while(mainclass.choice!=1){
				try {
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			mainclass.choice=0;
			fruit=mainclass.fruitlist[mainclass.f];
			if(f.get(fruit)==mainclass.MAX){
				System.out.println(" producer waiting for "+fruit);
				//return;
			}
			else if ((f.get(fruit)+mainclass.count)<=mainclass.MAX){
				f.put(fruit, f.get(fruit)+mainclass.count);
				System.out.println(fruit+" produced to count "+f.get(fruit));
			}
			else{
				f.put(fruit,mainclass.MAX);
				System.out.println(fruit+" produced to count "+f.get(fruit)+" and waiting for rest");
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
