package com.accolite.model;

import java.util.Random;

public class Hashcode{
	public static void main(String[] args) {
	    for(int i=0;i<5;i++){
	    	Random rand = new Random();
	    	int n = 1 + rand.nextInt(9);
	    	System.out.println(n);
	    }

	}

}