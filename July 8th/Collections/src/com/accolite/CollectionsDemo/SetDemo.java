package com.accolite.CollectionsDemo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String args[]){
		Set<Object> hset=new HashSet<Object>();
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++)
			hset.add(sc.next());
		System.out.println(hset);
		Set<Object> tset=new TreeSet<Object>(hset);
		System.out.println(tset);
			
	}
}
