package pkg;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	int napple;
	int norange;
	int nwatermelon;
	int ngrape;
	BlockingQueue apple = null;
	BlockingQueue orange = null;
	BlockingQueue watermelon = null;
	BlockingQueue grape = null;

	Producer(BlockingQueue apple, BlockingQueue orange, BlockingQueue watermelon, BlockingQueue grape, int napple,
			int norange, int nwatermelon, int ngrape) {
		// this.farmerType = farmerType;
		this.napple = napple;
		this.norange = norange;
		this.nwatermelon = nwatermelon;
		this.ngrape = ngrape;
		this.apple = apple;
		this.orange = orange;
		this.watermelon = watermelon;
		this.grape = grape;
	}

	@Override
	public void run() {

		for (int i = 1; i <= this.napple; i++) {
			try {

				int element = (int) apple.size();

				if (element < 10) {
					apple.put(i);
					Thread.sleep(100);
				} else {
					System.out.println("apple limit reached");
					break;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.norange; i++) {
			try {

				int element = (int) orange.size();

				if (element < 10) {
					orange.put(i);
					Thread.sleep(100);
				} else{
					System.out.println("orange limit reached");
					break;}

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

		for (int i = 1; i <= this.nwatermelon; i++) {
			try {

				int element = (int) watermelon.size();

				if (element < 10) {
					watermelon.put(i);
					Thread.sleep(100);
				} else{
					System.out.println("watermelon limit reached");
					break;}

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

		for (int i = 1; i <= this.ngrape; i++) {
			try {

				int element = (int) grape.size();

				if (element < 10) {
					grape.put(i);
					Thread.sleep(100);
				} else{
					System.out.println("grape limit reached");
					break;}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("apple " + apple.size() + "\n"+"orange " + orange.size() +"\n"+ "watermelon " + watermelon.size()+"\n"
				+ "grapes " + grape.size());

	}
}