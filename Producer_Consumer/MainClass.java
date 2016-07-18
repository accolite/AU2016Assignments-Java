import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class MainClass {

	   public static void main(String args[]){
		   ConcurrentHashMap<String,Integer> chm= new ConcurrentHashMap();
		   chm.put("Apple", 0);
		   chm.put("Orange",0);
		   chm.put("Grape", 0);
		   chm.put("Watermelon", 0);
		   Scanner sc=new Scanner(System.in);
		   char c='y',ch;
		   Producer p = new Producer(chm,0,null);
		   Consumer con = new Consumer(chm,0,null);
		   while(c=='y'){
		   	 
		   System.out.println("enter the You want to purchase or sale p/s");
		   ch=sc.next().charAt(0);
		   if(ch=='s'){
		   System.out.println("enter the name of fruit and count farmer sale: ");
		   p.fruit=sc.next();
		   p.count=sc.nextInt();		  
		   Thread t1 = new Thread(p,"threadp1");
		   t1.start();
		   try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   }
		   else if(ch=='p'){
		   System.out.println("enter the name of fruit and count consumer purchase ");
		   con.fruit=sc.next();
		   con.count=sc.nextInt();
		   Thread t3 = new Thread(con,"threadc1");
		   t3.start();
		   try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   System.out.println("you want to add more y/n");
		   c=sc.next().charAt(0);
		   }
	   }
}
