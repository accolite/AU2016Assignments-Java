package atm;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;

//import org.junit.BeforeClass;
public class CoinTest {
/*
@BeforeClass 
public void beforeTest(){
    System.out.println("Before testing coin should be initialized");
   Coin coin= new Coin();
 }
*/
	@Ignore 
	@Before
	   public void initialize() {
	     //Coin coin = new Coin("PENNY");
	   }
@Test
public void testCoinConstructor_forPENNY() {
   int value = 1;
   Coin coin= new Coin("PENNY");
   assertEquals(coin.getValue(),value);
}

@Test
public void testCoinConstructor_forNICKEL() {
   int value = 5;
   Coin coin= new Coin("NICKEL");
   assertEquals(coin.getValue(),value);
}
@Test
public void testCoinConstructor_forDIME() {
   int value = 10;
   Coin coin= new Coin("DIME");
   assertEquals(coin.getValue(),value);
}


@Test
public void testCoinConstructor_forHALFDOLLAR() {
   int value = 50;
   Coin coin= new Coin("HALFDOLLAR");
   assertEquals(coin.getValue(),value);
}
@Test
public void testCoinConstructor_forSILVERDOLLAR() {
   int value = 100;
   Coin coin= new Coin("SILVERDOLLAR");
   assertEquals(coin.getValue(),value);
}
@Test
public void testForInvalidCoin() {
   int value = 0;
   Coin coin= new Coin("QUART");
   assertEquals(coin.getValue(),value);
}
/*
@Test
public void testFor_toString_forPenny()
{	Coin coin= new Coin("PENNY");
	assertEquals(coin.toString(),"PENNY");
	
}
@Test
public void testFor_toString_forNickel()
{	Coin coin= new Coin("NICKEL");
	String str= new 
	assertEquals(coin.toString(),"NICKEL");
	
}

/*
public static void main (String args[])
{	Coin coin = new Coin("PENNY");
	System.out.println("return val of PENNY  "+ coin.getValue());
}
*/
}

