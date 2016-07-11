package assigntestpackage;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class TestClass {
	ATM atm;
	Coin validcoin;
	Coin invalidcoin;
	Coin nullCoin;
	Coin silverd;
	//private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@Before
	public void before(){
		//System.setOut(new PrintStream(outContent));
	    //System.setErr(new PrintStream(errContent));
		atm=new ATM();
		validcoin=new Coin("penny");
		invalidcoin=new Coin("garbage");
		silverd=new Coin("SilverDollar");
	}
	@Ignore
	@Test
	public void ValidCoincase() {
		//fail("Not yet implemented");
		assertEquals("penny tested",(new Coin("penny")).getValue(),1);
		assertEquals("nickel tested",(new Coin("nickel")).getValue(),5);
		assertEquals("dime tested",(new Coin("dime")).getValue(),10);
		assertEquals("quarter tested",(new Coin("quarter")).getValue(),25);
		assertEquals("halfdollar tested",(new Coin("halfdollar")).getValue(),50);
		assertEquals("silverdollar",(new Coin("silverdollar")).getValue(),100);
	}
	@Ignore
	@Test
	public void invalidCoincase(){
		assertEquals("invalid input",(new Coin("invalid case")).getValue(),0);
		/*
		Coin coinm=Mockito.mock(Coin.class);
		Mockito.when(coinm.getValue()).thenReturn(-1);
		*/
	}
	@Ignore
	@Test
	public void testtoString(){
		assertEquals("null to string",validcoin.toString(),"1");
	}
	@Ignore
	@Test
	public void testtoStringinvalid(){
		assertEquals("null to string",invalidcoin.toString(),"0");
		//System.out.println(nullCoin.toString());
	}
	@Ignore
	@Test
	public void testtostringnull(){
		assertEquals("null to string",nullCoin.toString(),"");
	}
	@Ignore
	@Test
	public void testtoinsertinvalid(){
		ATM atm;
		atm=new ATM();
		validcoin=new Coin("penny");
		invalidcoin=new Coin("garbage");
		silverd=new Coin("SilverDollar");
		atm.insert(invalidcoin);
		//System.out.println(outContent.toString());
		//assertEquals("illegal value",errContent.toString().substring(0,errContent.toString().length()-2));
		//assertEquals("Invalid ",outContent.toString(),"Current value = ");
		//assert
	}
	@Test
	public void testtoreturninvalidval(){
		//Mockito.mock();
		//Mock
		try{
			ATM atm = new ATM();
			Coin coin = new Coin("SILVERDOLLAR");
			Object curVal=null;
			Field MyCurrValue = ATM.class.getDeclaredField("currValue");
			Field Myenabled = ATM.class.getDeclaredField("enabled");
			MyCurrValue.setAccessible(true);
			curVal = MyCurrValue.get(atm);
			atm.returnCoins();
			assertEquals( "0", curVal.toString());
					}
		catch(Exception e){
			
		}
		
	}
	@Test
	public void testtoreturnvalidval(){
		//Mockito.mock();
		//Mock
		try{
			ATM atm = new ATM();
			Coin coin = new Coin("SILVERDOLLAR");
			Object curVal=null;
			Field MyCurrValue = ATM.class.getDeclaredField("currValue");
			Field Myenabled = ATM.class.getDeclaredField("enabled");
			MyCurrValue.setAccessible(true);
			curVal = MyCurrValue.get(atm);
			atm.insert(coin);
			atm.returnCoins();
			assertEquals( "0", curVal.toString());
			
			}
			catch(Exception e){
			
			}
		
	}
	@Ignore
	@Test
	public void returncoinsTest(){
		//atm.returnCoins();
		//System.out.println("error");
					//System.out.println("error");
		   // Field f=ATM.class.getDeclaredField("currValue");
		   // f.setAccessible(true);
		   // Object mycurr=f.get(atm);
		//validcoin=new Coin("penny");
		atm.insert(validcoin);
		atm.insert(silverd);
		    
	}
	@Ignore
	@Test
	public void vendtest(){
		try{
		ATM atm = new ATM();
		Coin coin = new Coin("SILVERDOLLAR");
		Object curVal=null;
		Field MyCurrValue = ATM.class.getDeclaredField("currValue");
		//Field Myenabled = ATM.class.getDeclaredField("enabled");
		MyCurrValue.setAccessible(true);
		curVal = MyCurrValue.get(atm);
		atm.insert(coin);
		atm.vend();
		assertEquals( "0", curVal.toString());
		}
		catch(Exception e){
			
		}
	}
	@After
	public void after(){
	}
	
}

