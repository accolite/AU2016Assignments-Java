package fruitmarket;

public class FruitMarket {

	public static void main(String[] args) 
	{			
		Thread Farmer = new Thread( new Farmer() );
		Thread Customer = new Thread( new Customer() );
		Farmer.start();
		Customer.start();
	}

}
