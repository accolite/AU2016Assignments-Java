
//ATM
class ATM {
 private int totValue;
 private int currValue;
 private boolean enabled;
 private static final int COST = 75;
 
 public ATM() {
  totValue = 0;
  currValue = 0;
  enabled = false;
 }
 
 public void insert( Coin coin ) {
  int value = coin.getValue();
  if ( value == 0 ) {
   System.err.println( "illegal value");
  }
  else {
   currValue += value;
   System.out.print( "Current value = " + currValue );
   if (currValue >= COST) {
    enabled = true;
    System.out.println( " (sufficient credit)" );
   }
   else System.out.println( "" );
  }
 }
 
 public void returnCoins() {
  if ( currValue == 0 ) {
   System.err.println( "no coins to return" );
  }
  else {
   System.out.println( "Take your coins" );
   currValue = 0;
   enabled = false;  
  }
 }
 
 public void vend() throws Exception {
  if (enabled) {
   System.out.println( "Get your drink");
   totValue += COST;
   currValue -= COST;
   if (currValue == 0) enabled = false;  
   System.out.println( "Current value = " + currValue );
  }
  else {
   System.out.println( "Not enough credit: add " + (COST - currValue));
  }
  if (currValue < 0) throw new Exception("Error: negative credit!");
 }
}
