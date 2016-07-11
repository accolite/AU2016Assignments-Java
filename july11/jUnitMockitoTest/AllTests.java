/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 11, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.junitatm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Test Suite AllTests.
 */
@RunWith(Suite.class)
@SuiteClasses({ ATMTest.class, CoinTest.class })
public class AllTests {

}
