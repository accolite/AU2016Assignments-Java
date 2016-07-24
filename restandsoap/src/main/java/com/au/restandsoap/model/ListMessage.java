package com.au.restandsoap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ListMessage {
	List <Message> listmessage;

	public List<Message> getListmessage() {
		return listmessage;
	}

	public void setListmessage(List<Message> listmessage) {
		this.listmessage = listmessage;
	}
	
}
