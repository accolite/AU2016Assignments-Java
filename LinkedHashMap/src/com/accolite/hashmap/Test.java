package com.accolite.hashmap;

public class Test {
	
	public static void main(String[] args) {
		 Hashmap<Integer, String> obj = new Hashmap<>();
		 obj.put(3, "FIVE");
		 
		 System.out.println(obj.get(3));
	} 
}
