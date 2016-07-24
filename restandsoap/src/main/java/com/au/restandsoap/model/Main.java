package com.au.restandsoap.model;

import com.au.restandsoap.webapp.Application;

public class Main {
	public static void main(String[] args) {
        Application a = new Application();
        System.out.println("reply : " + a.addmessage(new Message(10,4,"asdasd")));
    }
}
