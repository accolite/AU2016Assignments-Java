import java.util.concurrent.ArrayBlockingQueue;

public class Average implements Runnable {
    int count;
    double avg;
    ArrayBlockingQueue qu; 
	public Average(int count, double avg, ArrayBlockingQueue qu) {
		this.count = count;
		this.avg = avg;
		this.qu = qu;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int a = 0;
		while(true){
			try {
				a=(int) qu.take();
				count++;
				avg=(avg*(count-1)+a)/count;
				System.out.println("average of "+count+" bills is "+avg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}			
			
		}
	}

}

