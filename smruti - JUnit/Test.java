import static org.junit.Assert.*;


import static org.mockito.Mockito.*;


import java.lang.reflect.*;

public class Test {

	@org.junit.Test
	public void invalidCurrencyTest() {
        Coin tester = new Coin("Rupee"); // Currency is tested
             // assert statements
         assertEquals("Not entered correct currency", tester.getValue(), 0);
	}
	
	@org.junit.Test
	public void invalidEntryTest() {
        Coin tester = new Coin("Rupee"); // Currency is tested
             // assert statements
        String value = tester.toString();
        
        System.out.println(" is invalid");
    
	}
	
	//on positive input to insert
	@org.junit.Test
	public void testToCheckInsertOnValidInput() throws Exception {
		System.out.println("Test case 2:");
		Coin coins = mock(Coin.class);
		
		when(coins.getValue()).thenReturn(100);
		
		
		int n = coins.getValue();
		System.out.println("value = "+ n);
        ATM atm = new ATM();

        Field enabled, currValue, totValue;
		enabled = ATM.class.getDeclaredField("enabled");
		currValue = ATM.class.getDeclaredField("currValue");
		totValue = ATM.class.getDeclaredField("totValue");
		enabled.setAccessible(true);
		currValue.setAccessible(true);
		totValue.setAccessible(true);

	    boolean enable = (boolean) enabled.get(atm);
	    int curr = (int) currValue.get(atm);
	    int tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot);
	    
	    atm.insert(coins);
	    enable = (boolean) enabled.get(atm);
	    curr = (int) currValue.get(atm);
	    tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot + "\n\n");

	}
	
	
	//on negative input to insert 
	@org.junit.Test
	public void testToCheckNegativeInput() throws Exception {
		System.out.println("Test case 3:");
		Coin coins = mock(Coin.class);
		
		when(coins.getValue()).thenReturn(-100);
		
		int n = coins.getValue();
		System.out.println("value = "+ n);
        ATM atm = new ATM();

        Field enabled, currValue, totValue;
		enabled = ATM.class.getDeclaredField("enabled");
		currValue = ATM.class.getDeclaredField("currValue");
		totValue = ATM.class.getDeclaredField("totValue");
		enabled.setAccessible(true);
		currValue.setAccessible(true);
		totValue.setAccessible(true);

	    boolean enable = (boolean) enabled.get(atm);
	    int curr = (int) currValue.get(atm);
	    int tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot);
	    
	    atm.insert(coins);
	    enable = (boolean) enabled.get(atm);
	    curr = (int) currValue.get(atm);
	    tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot);
	   
	}
	
	@org.junit.Test
	public void testToCheckReturnCoins() throws Exception {
		System.out.println("\n\nTest case 4:");
		Coin coins = mock(Coin.class);
		
		when(coins.getValue()).thenReturn(75);
		
		int n = coins.getValue();
		System.out.println("value = "+ n);
        ATM atm = new ATM();

        Field enabled, currValue, totValue;
		enabled = ATM.class.getDeclaredField("enabled");
		currValue = ATM.class.getDeclaredField("currValue");
		totValue = ATM.class.getDeclaredField("totValue");
		enabled.setAccessible(true);
		currValue.setAccessible(true);
		totValue.setAccessible(true);

	    boolean enable = (boolean) enabled.get(atm);
	    int curr = (int) currValue.get(atm);
	    int tot = (int) totValue.get(atm);
	    
	    atm.insert(coins);
	    atm.returnCoins();
	    enable = (boolean) enabled.get(atm);
	    curr = (int) currValue.get(atm);
	    tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot);
	   
	}
	
	@org.junit.Test
	public void testToCheckVend() throws Exception {
		System.out.println("\n\nTest case 5:");
		Coin coins = mock(Coin.class);
		
		when(coins.getValue()).thenReturn(75);
		
		int n = coins.getValue();
		System.out.println("value = "+ n);
        ATM atm = new ATM();

        Field enabled, currValue, totValue;
		enabled = ATM.class.getDeclaredField("enabled");
		currValue = ATM.class.getDeclaredField("currValue");
		totValue = ATM.class.getDeclaredField("totValue");
		enabled.setAccessible(true);
		currValue.setAccessible(true);
		totValue.setAccessible(true);

	    boolean enable = (boolean) enabled.get(atm);
	    int curr = (int) currValue.get(atm);
	    int tot = (int) totValue.get(atm);
	    
	    atm.insert(coins);
	    atm.vend();
	    enable = (boolean) enabled.get(atm);
	    curr = (int) currValue.get(atm);
	    tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot);
	   
	}
	
	@org.junit.Test
	public void testToCheckInvalidConditions() throws Exception {
		System.out.println("\n\nTest case 6:");
		Coin coins = mock(Coin.class);
		
		when(coins.getValue()).thenReturn(0);
		
		int n = coins.getValue();
		System.out.println("value = "+ n);
        ATM atm = new ATM();

        Field enabled, currValue, totValue;
		enabled = ATM.class.getDeclaredField("enabled");
		currValue = ATM.class.getDeclaredField("currValue");
		totValue = ATM.class.getDeclaredField("totValue");
		enabled.setAccessible(true);
		currValue.setAccessible(true);
		totValue.setAccessible(true);

	    boolean enable = (boolean) enabled.get(atm);
	    int curr = (int) currValue.get(atm);
	    int tot = (int) totValue.get(atm);
	    
	    atm.insert(coins);
	    atm.returnCoins();
	    atm.vend();
	    
	    enable = (boolean) enabled.get(atm);
	    curr = (int) currValue.get(atm);
	    tot = (int) totValue.get(atm);
	    System.out.println("enable = " + enable + "\t current = " + curr + "\t total = " + tot);
	   
	}
}
