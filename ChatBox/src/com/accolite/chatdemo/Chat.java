/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 26, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.chatdemo;

public class Chat {
	String name;
	String chat;
	
	
	/**
	 * Instantiates a new chat.
	 */
	public Chat() {
		super();
	}
	public Chat(String name, String chat) {
		super();
		this.name = name;
		this.chat = chat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	

}
