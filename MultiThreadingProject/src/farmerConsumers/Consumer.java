package farmerConsumers;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	protected BlockingQueue apple = null;
	protected BlockingQueue orange = null;
	protected BlockingQueue grapes = null;
	protected BlockingQueue watermelon = null;
	@Override
	public void run() {
        consume();
    }
	public Consumer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grapes, BlockingQueue watermelon) {
		super();
		this.apple = apple;
		this.orange = orange;
		this.grapes = grapes;
		this.watermelon = watermelon;
	}
	
	void consume()
	{	Scanner in = new Scanner(System.in);
		
			System.out.println("to consume Apple enter 1");
			System.out.println("to consume Orange enter 2");
			System.out.println("to consume Grape enter 3");
			System.out.println("to consume waterMelon enter 4");
			//System.out.println("to exit press 5");
			int choice = in.nextInt();
			System.out.println("Enter the quantity");
			int quantity = in.nextInt();
			switch(choice)
			{	case 1: for(int i=0;i<quantity;i++)
				{
					try {
						apple.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					break;
			case 2: for(int i=0;i<quantity;i++)
			{
				try {
					orange.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
			case 3: for(int i=0;i<quantity;i++)
			{
				try {
					grapes.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
			
		case 4: for(int i=0;i<quantity;i++)
		{
			try {
				watermelon.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			break;
			
		}
			
	}
	
}
