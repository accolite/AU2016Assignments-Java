import java.util.concurrent.BlockingQueue;

public class Farmer implements Runnable {

	protected String farmerType;
	protected int napple;
	protected int norange;
	protected int nwatermelon;
	protected int ngrape;
	protected BlockingQueue appleq = null;
	protected BlockingQueue orangeq = null;
	protected BlockingQueue waterq = null;
	protected BlockingQueue grapeq = null;

	Farmer(BlockingQueue aqueue, BlockingQueue oqueue, BlockingQueue wqueue, BlockingQueue gqueue, int napple,
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

				if (element < 10) {
					appleq.put(i);
					Thread.sleep(100);
				} else {
					System.out.println("apple limit reached");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.norange; i++) {
			try {

				int element = (int) orangeq.size();

				if (element < 10) {
					orangeq.put(i);
					Thread.sleep(100);
				} else
					System.out.println("orange limit reached");

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

		for (int i = 1; i <= this.nwatermelon; i++) {
			try {

				int element = (int) waterq.size();

				if (element < 10) {
					waterq.put(i);
					Thread.sleep(100);
				} else
					System.out.println("watermelon limit reached");

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

		for (int i = 1; i <= this.ngrape; i++) {
			try {

				int element = (int) grapeq.size();

				if (element < 10) {
					grapeq.put(i);
					Thread.sleep(100);
				} else
					System.out.println("grape limit reached");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("apple " + appleq.size() + "orange " + orangeq.size() + "watermelon " + waterq.size()
				+ "grapes " + grapeq.size());

	}
}