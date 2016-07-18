package pkg;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue apple = null;
	BlockingQueue orange = null;
	BlockingQueue watermelon = null;
	BlockingQueue grape = null;
	int napple;
	int norange;
	int nwatermelon;
	int ngrape;

	Consumer(BlockingQueue apple, BlockingQueue orange, BlockingQueue watermelon, BlockingQueue grape, int napple,
			int norange, int nwatermelon, int ngrape) {
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

				if (element > 0)
					apple.take();
				else
					System.out.println("no apples");
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.norange; i++) {
			try {

				int element = (int) orange.size();
				if (element > 0)
					orange.take();
				else
					System.out.println("no oranges");

				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.nwatermelon; i++) {
			try {

				int element = (int) watermelon.size();
				if (element > 0)
					watermelon.take();
				else
					System.out.println("no melons");

				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= this.ngrape; i++) {
			try {

				int element = (int) grape.size();
				if (element > 0)
					grape.take();
				else
					System.out.println("no grapes");
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("apple " + apple.size() + "\n"+"orange " + orange.size() +"\n"+ "watermelon " + watermelon.size()+"\n"
				+ "grapes " + grape.size());

	}

}
