import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
	
	public static void main(String args[]){
		ArrayBlockingQueue<Integer> qu=new ArrayBlockingQueue(500); 
		Average avg =new Average(0,0,qu);
		Bill bl=new Bill(qu);
		Result r= new Result(avg.avg);
		Thread t1 = new Thread(avg,"avgthread");
		Thread t2 = new Thread(bl, "threadb1");
		Thread t3 = new Thread(r, "threadr");
		t1.start();
		t2.start();
		t3.start();
	}
}
