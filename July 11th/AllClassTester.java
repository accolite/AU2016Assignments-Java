/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 11, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.UnitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The Suite Class to test ATM and Coin Classes
 */
@RunWith(Suite.class)
@SuiteClasses({CoinTest.class,ATMTest.class})
public class AllClassTester {
	

}
