import java.util.concurrent.ConcurrentHashMap;

public class Consumer extends Thread {
	ConcurrentHashMap<String,Integer> f;
	String fruit;
	Consumer(String s,ConcurrentHashMap<String,Integer> chm){
		fruit=s;
		f=chm;
	}
	public void run(){
		for (int i = 0; i <mainclass.tot; i++) {
			take(fruit);
		}
	}
	public synchronized void take(String fruit){
		//System.out.print("Step "+mainclass.step+++" :");
		synchronized (mainclass.sema) {
			if(f.get(fruit)==0){
				System.out.println("consumer waiting for "+fruit);
				return;
			}
			f.put(fruit, f.get(fruit)-1);
			System.out.println(fruit+" consumed to count "+f.get(fruit));
		}
		
	}
}
