package com.accolite.UnitTesting;

// TODO: Auto-generated Javadoc
class Coin {
	 public static final int PENNY = 1;
	 public static final int NICKEL = 5;
	 public static final int DIME = 10;
	 public static final int QUARTER = 25;
	 public static final int HALFDOLLAR = 50;
	 public static final int SILVERDOLLAR = 100;
	 
	 public static final int INVALID = 0;
	 
	 private int value;
	 
	 public Coin( String coin )
	 {
	  String toUpperCoin = coin.toUpperCase();
	  if ( toUpperCoin.equals( "PENNY" ) ) value = PENNY;
	  else if ( toUpperCoin.equals( "NICKEL" ) ) value = NICKEL;
	  else if ( toUpperCoin.equals( "DIME" ) ) value = DIME;
	  else if ( toUpperCoin.equals( "QUARTER" ) ) value = QUARTER;
	  else if ( toUpperCoin.equals( "HALFDOLLAR" ) ) value = HALFDOLLAR;
	  else if ( toUpperCoin.equals( "SILVERDOLLAR" ) ) value = SILVERDOLLAR;
	  else value = INVALID;
	 }
	 
	 public int getValue() {return value;}
	 
	 public String toString() { return new String(Integer.toString(value)); }
	}

	/**
	 * The Class ATM.
	 */
	//ATM
	class ATM {
	 
 	/** The tot value. */
 	private int totValue;
	 
 	/** The curr value. */
 	private int currValue;
	 
 	/** The enabled. */
 	private boolean enabled;
	 
 	/** The Constant COST. */
 	private static final int COST = 75;
	 
	 /**
 	 * Instantiates a new atm.
 	 */
 	public ATM() {
	  totValue = 0;
	  currValue = 0;
	  enabled = false;
	 }
	 
	 /**
 	 * Insert.
 	 *
 	 * @param coin the coin
 	 */
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
	    System.out.println( "(sufficient credit)" );
	   }
	   else System.out.println( "" );
	  }
	 }
	 
	 /**
 	 * Return coins.
 	 */
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
	 
	 /**
 	 * Vend.
 	 *
 	 * @throws Exception the exception
 	 */
 	public void vend() throws Exception {
	  if (enabled) {
	   System.out.println( "Get your drink");
	   totValue += COST;
	   currValue -= COST;
	   if (currValue == 0) 
		   enabled = false;  
	   System.out.println( "Current value = " + currValue );
	  }
	  else {
	   System.out.println( "Not enough credit: add " + (COST - currValue));
	  }
	  if (currValue < 0) throw new Exception("Error: negative credit!");
	 }
	}
