import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Generated;

public class mainclass {
	static int MAX=3;
	static int tot=5;
	static int step=1;
	int h;
	int ch;
	static ConcurrentHashMap<String,Integer> chMap;
	public static Object sema;
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public static void main(String[] args){
		sema=new Object();
		chMap=new ConcurrentHashMap<>();
		String[] fruitlist=new String[5];
		fruitlist[0]="Apple";
		fruitlist[1]="Orange";
		fruitlist[2]="Grape";
		fruitlist[3]="Watermelon";
		Producer[] p=new Producer[5];
		Consumer[] c=new Consumer[5];
		
		for (int i = 0; i < 4; i++) {
			p[i]=new Producer(fruitlist[i],chMap);
			c[i]=new Consumer(fruitlist[i],chMap);
			chMap.put(fruitlist[i],0);
		}
		for (int i = 0; i < 4; i++) {
			p[i].start();
			c[i].start();
		}
	}
}
