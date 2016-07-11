import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testcase1 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Cointest()
	    {
		Coin c1=new Coin("penny");
		assertEquals("Will it work", c1.getValue(), 1);
		}
	
	@Test
	public void Cointest2()
	    {
		Coin c1=new Coin("nickel");
		assertEquals("Will it work2", c1.getValue(), 5);
		}
	
	@Test
	public void Cointest3()
    {
	Coin c1=new Coin("dime");
	assertEquals("Will it work3", c1.getValue(), 10);
	}
	
	@Test
	public void Cointest4()
    {
	Coin c1=new Coin("quarter");
	assertEquals("Will it work4", c1.getValue(), 25);
	}
	
	@Test
	public void Cointest5()
    {
	Coin c1=new Coin("halfdollar");
	assertEquals("Will it work5", c1.getValue(), 50);
	}
	
	@Test
	public void Cointest6()
    {
	Coin c1=new Coin("silverdollar");
	assertEquals("Will it work6", c1.getValue(), 100);
	}
}
