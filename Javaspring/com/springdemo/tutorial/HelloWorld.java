package com.springdemo.tutorial;

public class HelloWorld {
	
	public HelloWorld(){
		System.out.println("Inside Hello World Constructor");
	}
	
	public HelloWorld(String name){
		System.out.println("Inside Parametrized Hello World Constructor");
		this.name = name;
	}

	private String name;
 
	public void printHello() {
		System.out.println("Spring 4 : Hello ! " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Inside Hello World Setter Method");
		this.name = name;
	}	

}
