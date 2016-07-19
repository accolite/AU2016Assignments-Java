package pkg;

import java.util.concurrent.BlockingQueue;

public class Output implements Runnable{
	BlockingQueue input = null;
	float  x;
	public Output(){}
	public Output (BlockingQueue input)
	{
		this.input=input;
	}
	public void run()
	{
		try{
		x=(float)input.take(); 
		System.out.println(x);
		}catch(InterruptedException e){
			
		}
	}

}
