package junit;

import static org.junit.Assert.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.*;
import org.junit.runner.RunWith;
@RunWith(MockitoJUnitRunner.class)
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
		Coin c = new Coin("SilverDollar");
		
	}

	
	@Test
	public void testGetValuePenny() {
		Coin c1 = new Coin( "PENNY");
		assertEquals( "Test get value", 1, c1.getValue());
		
	}
	@Test
	public void testGetValueQuarter(){
		Coin c4 = new Coin("Quarter");
		assertEquals( "Test get value", 25, c4.getValue());
		
		
	}
	
	@Test
	public void testGetValueNickel(){
		Coin c2 = new Coin("Nickel");
		assertEquals( "Test get value", 5, c2.getValue());
		
	}
	@Test
	public void testGetValueDime(){
		Coin c3 = new Coin("Dime");
		assertEquals( "Test get value", 10, c3.getValue());
		
		
	}
	@Test
	public void testGetValueHalfDollar(){
		Coin c5 = new Coin("HalfDollar");
		assertEquals( "Test get value", 50, c5.getValue());
		
	}
	@Test
	public void testGetValueSilverDollar(){
		Coin c6 = new Coin("SilverDollar");
		assertEquals( "Test get value", 100, c6.getValue());
		
	}
	@Test
	public void testToString() {
		
	}

}
