package pkg;
import java.util.concurrent.BlockingQueue;

public class Average implements Runnable{
	BlockingQueue input = null;
	int nbill;
	int counter;
	float  avg;
	public Average(){}
	public Average (BlockingQueue input)
	{
		this.input=input;
		nbill=0;
		counter=0;
		avg=0;
	}
	void meth(int nbill)
	{
		this.nbill=nbill;
	}
	public void run()
	{
		try{
		float x=avg;
		avg= (x*counter+nbill)/(++counter);
		input.put(avg);
		}
		catch(InterruptedException e){
			
		}
	}
}

