import java.util.Scanner;

public class Farmer implements Runnable {

	Market market =  null;
	
	public Farmer(Market market) {
		this.market = market;
	}
	
	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		System.out.print("How many Apples? ");
		int noOfApples = in.nextInt(); 
		for (int i = 0; i < noOfApples; i++) {
			try {
				market.addApple();
				if(!Thread.currentThread().isInterrupted()){
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("How many Grapes? ");
		int noOfGrapes= in.nextInt(); 
		for (int i = 0; i < noOfGrapes; i++) {
			try {
				market.addGrape();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("How many Oranges? ");
		int noOfOrange = in.nextInt(); 
		for (int i = 0; i < noOfOrange; i++) {
			try {
				market.addOrange();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("How many Watermelons? ");
		int noOfWatermelons = in.nextInt(); 
		for (int i = 0; i < noOfWatermelons; i++) {
			try {
				market.addWatermelon();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
