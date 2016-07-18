package farmerConsumers;

//import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;
public class Farmer implements Runnable {
	protected BlockingQueue apple = null;
	protected BlockingQueue orange = null;
	protected BlockingQueue grapes = null;
	protected BlockingQueue watermelon = null;

	
	public Farmer(BlockingQueue apple, BlockingQueue orange, BlockingQueue grapes, BlockingQueue watermelon) {
		//super();
		this.apple = apple;
		this.orange = orange;
		this.grapes = grapes;
		this.watermelon = watermelon;
	}
	public void run() {
		
       produce();
    }
	void produce()
	{	Scanner in = new Scanner(System.in);
		
			System.out.println("to produce Apple enter 1");
			System.out.println("to produce Orange enter 2");
			System.out.println("to produce Grape enter 3");
			System.out.println("to produce waterMelon enter 4");
			//System.out.println("to exit press 5");
			int choice = in.nextInt();
			int quantity;
			switch(choice)
			{	case 1: 
				System.out.println("Enter the quantity");
				 quantity = in.nextInt();
				for(int i=0;i<quantity;i++)
				{	
					apple.add(1);
				}
					break;
			case 2: System.out.println("Enter the quantity");
			 quantity = in.nextInt();
			for(int i=0;i<quantity;i++)
			{
				orange.add(2);
			}
				break;
			case 3: System.out.println("Enter the quantity");
			 quantity = in.nextInt();
				for(int i=0;i<quantity;i++)
			{
				grapes.add(3);
			}
				break;
			
		case 4: System.out.println("Enter the quantity");
		 quantity = in.nextInt();
			for(int i=0;i<quantity;i++)
		{
			watermelon.add(4);
		}
			break;
		
			
		}
			
	}
}
