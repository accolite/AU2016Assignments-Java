package atomic;


import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Restaurant {
	static float sum=0;
	static float count=0;
	static BlockingQueue tables = new ArrayBlockingQueue<Integer>(2);
	static BlockingQueue average = new ArrayBlockingQueue<Integer>(2);
	public static void main(String args[]){	
		boolean flag=true;
		Scanner input = new Scanner(System.in);
		String ans;
		int value;
		while(flag){
			System.out.println("Do you want to enter Restaurant: y/n");
			ans = input.next();
			if(ans.equals("n"))
				break;
			else{
				System.out.println("Enter Bill Amount");
				value = input.nextInt();
				BillPaid bill = new BillPaid(value);
				new Thread(bill).start();
			}
		}
	}
}
