package com.accolite.mycollection;

import java.awt.print.Printable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test {
	public LinkedList<MyData> ll;
	public Test(){
		ll = new LinkedList<MyData>();
	}
	public void print(){
		System.out.println(ll);
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.print();
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(3,"Hello");
		map.put(3,"Hai");
		System.out.println(map.get(3));
/*		for(int i=0;i<2;i++)
		{
			map.
			map.get(key)
		}*/
	}
}
