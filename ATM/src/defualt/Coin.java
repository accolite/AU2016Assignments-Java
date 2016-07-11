/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 11, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package defualt;

// TODO: Auto-generated Javadoc
/**
 * The Class Coin.
 */
class Coin {
	
	/** The Constant PENNY. */
	public static final int PENNY = 1;
	
	/** The Constant NICKEL. */
	public static final int NICKEL = 5;
	
	/** The Constant DIME. */
	public static final int DIME = 10;
	
	/** The Constant QUARTER. */
	public static final int QUARTER = 25;
	
	/** The Constant HALFDOLLAR. */
	public static final int HALFDOLLAR = 50;
	
	/** The Constant SILVERDOLLAR. */
	public static final int SILVERDOLLAR = 100;

	/** The Constant INVALID. */
	public static final int INVALID = 0;

	/** The value. */
	private int value;

	/**
	 * Instantiates a new coin.
	 *
	 * @param coin the coin
	 */
	public Coin(String coin) {
		String toUpperCoin = coin.toUpperCase();
		if (toUpperCoin.equals("PENNY"))
			value = PENNY;
		else if (toUpperCoin.equals("NICKEL"))
			value = NICKEL;
		else if (toUpperCoin.equals("DIME"))
			value = DIME;
		else if (toUpperCoin.equals("QUARTER"))
			value = QUARTER;
		else if (toUpperCoin.equals("HALFDOLLAR"))
			value = HALFDOLLAR;
		else if (toUpperCoin.equals("SILVERDOLLAR"))
			value = SILVERDOLLAR;
		else
			value = INVALID;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new String(Integer.toString(value));
	}
}