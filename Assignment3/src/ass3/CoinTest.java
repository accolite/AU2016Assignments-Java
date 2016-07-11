
package ass3;

import static org.junit.Assert.*;


import org.junit.Test;

public class CoinTest {

	@Test
	public void toStringTest(){
		Coin penny= new Coin("PENNY");
		assertEquals("1 is Penny","1",penny.toString());
		Coin nickel= new Coin("NICKEL");
		assertEquals("5 is Nickel","5",nickel.toString());
		Coin dime= new Coin("DIME");
		assertEquals("10 is Dime","10",dime.toString());
		Coin quarter= new Coin("QUARTER");
		assertEquals("25 is Quarter","25",quarter.toString());
		Coin halfdollar= new Coin("HALFDOLLAR");
		assertEquals("50 is HALFDOLLAR","50",halfdollar.toString());
		Coin silverdollar= new Coin("SilverDollar");
		assertEquals("100 is SILVERDOLLAR","100",silverdollar.toString());
		Coin invalid= new Coin("jgsdbjdk");
		assertEquals("Invalid Input","0",invalid.toString());
	}
	
	@Test
	public void ValueTest()
	{
		Coin value= new Coin("PENNY");
		assertEquals("PENNY Value is 1",1,value.getValue());
		Coin value1= new Coin("NICKEL");
		assertEquals("NICKEL Value is 5",5,value1.getValue());
		Coin value2= new Coin("DIME");
		assertEquals("DIME Value is 10",10,value2.getValue());
		Coin value3= new Coin("QUARTER");
		assertEquals("QUARTER Value is 25",25,value3.getValue());
		Coin value4= new Coin("HALFDOLLAR");
		assertEquals("HALFDOLLAR Value is 50",50,value4.getValue());
		Coin value5= new Coin("SILVERDOLLAR");
		assertEquals("SILVERDOLLAR Value is 100",100,value5.getValue());
	}
	
	

}
