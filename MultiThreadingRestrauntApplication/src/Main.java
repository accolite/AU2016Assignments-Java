/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Global.billAmount=new ArrayBlockingQueue<>(1);
		Global.AveragebillAmount=new ArrayBlockingQueue<>(1);
		Global.bill=0.0f;
		Global.num_billings=0.0f;
		Global.previousAverage=0.0f;
		TotalBilling obj1=new TotalBilling();
		Thread th1=new Thread(obj1);
		AverageBilling obj2=new AverageBilling();
		Thread th2=new Thread(obj2);
		OutputThread obj3=new OutputThread();
		Thread th3=new Thread(obj3);
		th1.start();
		th2.start();
		th3.start();
	}	
}
