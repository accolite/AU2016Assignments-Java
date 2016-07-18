import java.util.concurrent.ConcurrentHashMap;

public class Consumer implements Runnable {

	private ConcurrentHashMap<String, Integer> chm;
	int count;
	String fruit;

	public Consumer(ConcurrentHashMap<String, Integer> chm, int count, String fruit) {
		// TODO Auto-generated constructor stub
		this.chm=chm;
		this.count=count;
		this.fruit=fruit;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int value = chm.get(fruit)-count;
		if(value<0){
			//Thread.currentThread().wait(3000);
			System.out.println("Not enough Fruit");
			value = chm.get(fruit)-count;
		}
		else{	chm.put(fruit, value);
			System.out.println(fruit+"Left=  "+chm.get(fruit));}
	}

}
