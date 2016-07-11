import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Mitul Kapoor on 7/11/2016.
 */
public class CoinTest {

    @Test
    public void testCoin(){
        Coin coin1 = new Coin("ASD");
        Coin coin2 = new Coin("PENNY");
        Coin coin3 = new Coin("Nickel");
        Coin coin4 = new Coin("dime");
        Coin coin5 = new Coin("QUARTER");
        Coin coin6 = new Coin("HALFDOLLAR");
        Coin coin7 = new Coin("SILVERDOLLAR");


        assertEquals("Value should be 0",coin1.getValue(),0);
        assertEquals("Value should be 5",coin2.getValue(),1);
        assertEquals("Value should be 5",coin3.getValue(),5);
        assertEquals("Value should be 10",coin4.getValue(),10);
        assertEquals("Value should be 25",coin5.getValue(),25);
        assertEquals("Value should be 50",coin6.getValue(),50);
        assertEquals("Value should be 100",coin7.getValue(),100);

        assertEquals("Value should be INVALID",coin1.toString(),"0");
        assertEquals("Value should be Penny",coin2.toString(),"1");
        assertEquals("Value should be nickel",coin3.toString(),"5");
        assertEquals("Value should be dime",coin4.toString(),"10");
        assertEquals("Value should be quater",coin5.toString(),"25");
        assertEquals("Value should be halfdollar",coin6.toString(),"50");
        assertEquals("Value should be silverdollar",coin7.toString(),"100");

    }
}
