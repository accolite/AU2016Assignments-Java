import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Created by Mitul Kapoor on 7/11/2016.
 */
public class ATMTest {
    /*
    * */


    private PrintStream outputStream;
    private PrintStream errorStream;
    Coin coin1;
    ATM atm;

    @Before
    public void setUpStreams() {
        outputStream = mock(PrintStream.class);
        errorStream = mock(PrintStream.class);
        System.setOut(outputStream);
        System.setErr(errorStream);

        coin1 = mock(Coin.class);
        atm = new ATM();

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Test
    public void testReturnCoinWhenEmpty() {
        ATM atm = new ATM();
        atm.returnCoins();
        verify(errorStream).println("no coins to return");
    }

    @Test
    public void testReturnCoinWhenNotEmpty() {
        ATM atm = new ATM();
        atm.insert(new Coin("NICKEL"));
        atm.returnCoins();
        verify(outputStream).println("Take your coins");
        assertEquals(atm.isEnabled(), false);
    }


    @Test
    public void testInsertIllegalValue() {
        ATM atm = new ATM();
        atm.insert(new Coin("ILLEGAL"));
        verify(errorStream).println("illegal value");
    }

    @Test
    public void testInsertWithSufficentCredit() {
        ATM atm = new ATM();
        when(coin1.getValue()).thenReturn(100);
        atm.insert(coin1);
        assertEquals(atm.isEnabled(), true);
    }


    @Test
    public void testInsertWithInSufficentCredit() {
        ATM atm = new ATM();
        when(coin1.getValue()).thenReturn(2);
        atm.insert(coin1);
        assertEquals(atm.isEnabled(), false);
    }

    @Test(expected = Exception.class)
    public void testVEndWhenNoValuePresent() throws Exception {
        ATM atm = new ATM();
        atm.vend();

    }

}

