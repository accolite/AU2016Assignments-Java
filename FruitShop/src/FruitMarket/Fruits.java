package FruitMarket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Fruits {
	static BlockingQueue<String> apple=new ArrayBlockingQueue<String>(20) ;
	static BlockingQueue<String> orange=new ArrayBlockingQueue<String>(20) ;
	static BlockingQueue<String> banana=new ArrayBlockingQueue<String>(20) ;
	static BlockingQueue<String> watermelon=new ArrayBlockingQueue<String>(20) ;
}
