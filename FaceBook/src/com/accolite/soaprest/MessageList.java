package com.accolite.soaprest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class MessageList {
	ArrayList<String> sorted_msgs;

	public MessageList() {
		super();
	}

	public MessageList(ArrayList<String> sorted_msgs) {
		super();
		this.sorted_msgs = sorted_msgs;
	}

	public ArrayList<String> getSorted_msgs() {
		return sorted_msgs;
	}

	public void setSorted_msgs(ArrayList<String> sorted_msgs) {
		this.sorted_msgs = sorted_msgs;
	}
	

}
