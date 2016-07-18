import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;

public class Producer extends Thread {
	ConcurrentHashMap<String,Integer> f;
	String fruit;
	Producer(String s,ConcurrentHashMap<String,Integer> chm){
		f=chm;
		fruit=s;
	}
	public void run(){
		for (int i = 1; i <= mainclass.tot; i++) {
			add(fruit);
		}
	}
	public void add(String fruit){
		//System.out.print("Step : "+main)
		synchronized (mainclass.sema) {
			if(f.get(fruit)==mainclass.MAX){
				System.out.println(" producer waiting for "+fruit);
				return;
			}
			f.put(fruit, f.get(fruit)+1);
			System.out.println(fruit+" produced to count "+f.get(fruit));
		}
		}
		
}
