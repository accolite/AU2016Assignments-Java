import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
	     ConcurrentHashMap<String,Integer> chm;
         int count;
         String fruit;
         Producer(ConcurrentHashMap<String,Integer> chm,int cnt,String frt){
        	 this.chm=chm;
        	 this.count=cnt;
        	 this.fruit=frt;
         }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int value=chm.get(fruit)+count;
			chm.put(fruit,value);
			System.out.println(fruit+"=  "+value);
		}
         
}
