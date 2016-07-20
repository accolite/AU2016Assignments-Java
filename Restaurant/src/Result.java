import java.util.concurrent.ArrayBlockingQueue;

public class Result implements Runnable{
double ans;
	public Result(double avg) {
		// TODO Auto-generated constructor stub
		this.ans=avg;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double pre=0;
		while(ans!=0&&ans!=pre){
			pre=ans;
			System.out.println(ans);
		}
	}
     
}
