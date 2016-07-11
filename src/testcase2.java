import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

public class testcase2 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
/*	@Test
	public void test4() throws Exception {
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(0);
		ATM a1 = new ATM();
        a1.insert(m1);
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
        System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
 //       System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
  //      System.out.println("curValue= " + curr);
       
        }
	
	@Test
	public void test5() throws Exception {
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(25);
//		ATM a=new ATM();
		
		ATM a1 = new ATM();
        a1.insert(m1);
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
        System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
 //       System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
  //      System.out.println("curValue= " + curr);
        
        }

	@Test
	public void test() throws Exception {
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		ATM a1 = new ATM();
        a1.insert(m1);
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
        System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
 //       System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
  //      System.out.println("curValue= " + curr);
        
        }
	
	@Test
	public void test2() throws Exception {
//		Coin m1=mock(Coin.class);
//		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		ATM a1 = new ATM();
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		
        a1.insert(m1);
        a1.returnCoins();
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
 //       System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
//        System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
        System.out.println("curValue= " + curr);
        
        
        
        }
	
	@Test
	public void test6() throws Exception {
//		Coin m1=mock(Coin.class);
//		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		ATM a1 = new ATM();
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(0);
//		ATM a=new ATM();
		
		
        a1.insert(m1);
        a1.returnCoins();
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
 //       System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
//        System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
        System.out.println("curValue= " + curr);
        
        
        
        }
	*/
	@Test
	public void test3() throws Exception {
//		Coin m1=mock(Coin.class);
//		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		ATM a1 = new ATM();
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		
        a1.insert(m1);
        a1.vend();
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
 //       System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
//        System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
        System.out.println("curValue= " + curr);
        
        
        
        }
	
	
/*	@Test
	public void test7() throws Exception {
//		Coin m1=mock(Coin.class);
//		when(m1.getValue()).thenReturn(100);
//		ATM a=new ATM();
		
		ATM a1 = new ATM();
		Coin m1=mock(Coin.class);
		when(m1.getValue()).thenReturn(25);
//		ATM a=new ATM();
		
		
        a1.insert(m1);
        a1.vend();
        Field privateStringField = ATM.class.getDeclaredField("enabled");
        privateStringField.setAccessible(true);
        boolean en = (boolean) privateStringField.get(a1);
 //       System.out.println("fieldValue = " + en);
        
        Field privateStringField2=ATM.class.getDeclaredField("totValue");
        privateStringField2.setAccessible(true);
        int tot=(int) privateStringField2.get(a1);
//        System.out.println("totValue= " + tot);
        
        Field privateStringField3=ATM.class.getDeclaredField("currValue");
        privateStringField3.setAccessible(true);
        int curr=(int) privateStringField3.get(a1);
        System.out.println("curValue= " + curr);
        
        
        
        }   */
	
	

}
