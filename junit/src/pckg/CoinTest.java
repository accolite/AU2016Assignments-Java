package pckg;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCoin() {
	}

	@Test
	public void testGetValue() {
		Coin c = new Coin("NICKEL");
		assertEquals(5,c.getValue());
		c = new Coin("PENNY");
		assertEquals(1,c.getValue());
		c = new Coin("DIME");
		assertEquals(1,c.getValue());
		c = new Coin("QUARTER");
		assertEquals(1,c.getValue());
		c = new Coin("HALFDOLLAR");
		assertEquals(1,c.getValue());
		c = new Coin("SILVERDOLLAR");
		assertEquals(1,c.getValue());	
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
