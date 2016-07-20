package restaurant;

public class Output_Avg implements Runnable {

	@Override
	public void run() {
	
		while(true){
			try {
				System.out.println("Output Thread 3 running ");
			if(Restaurant.avgvalue.size()!=0)	System.out.println("reporting average"+Restaurant.avgvalue.peek()/Avg.count);

				Restaurant.avgvalue_display.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
