import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {

	protected String farmerType;
	protected BlockingQueue appleq = null;
	protected BlockingQueue orangeq = null;
	protected BlockingQueue waterq = null;
	protected BlockingQueue grapeq = null;
	protected int napple;
	protected int norange;
	protected int nwatermelon;
	protected int ngrape;

	Customer(BlockingQueue aqueue, BlockingQueue oqueue, BlockingQueue wqueue, BlockingQueue gqueue, int napple,
			int norange, int nwatermelon, int ngrape) {
		// this.farmerType = farmerType;
		this.napple = napple;
		this.norange = norange;
		this.nwatermelon = nwatermelon;
		this.ngrape = ngrape;
		// if(this.farmerType.equals("apple")){
		this.appleq = aqueue;

		// }else if(this.farmerType.equals("orange")){
		this.orangeq = oqueue;

		// }else if(this.farmerType.equals("watermelon")){
		this.waterq = wqueue;

		// }else if(this.farmerType.equals("grape")){
		this.grapeq = gqueue;
		// }
	}

	@Override
	public void run() {

		for (int i = 1; i <= this.napple; i++) {
			try {

				int element = (int) appleq.size();

				if (element > 0)
					appleq.take();
				else
					System.out.println("no apples");
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.norange; i++) {
			try {

				int element = (int) orangeq.size();
				if (element > 0)
					orangeq.take();
				else
					System.out.println("no oranges");

				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.nwatermelon; i++) {
			try {

				int element = (int) waterq.size();
				if (element > 0)
					waterq.take();
				else
					System.out.println("no melons");

				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.ngrape; i++) {
			try {

				int element = (int) grapeq.size();
				if (element > 0)
					grapeq.take();
				else
					System.out.println("no grapes");
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("apple " + appleq.size() + "orange " + orangeq.size() + "watermelon " + waterq.size()
				+ "grapes " + grapeq.size());

	}

}
