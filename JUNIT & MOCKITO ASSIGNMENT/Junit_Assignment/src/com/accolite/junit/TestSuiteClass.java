package com.accolite.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Coin_test.class,
    Atm_test.class})
public class TestSuiteClass {
	
}
