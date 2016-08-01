package com.au.proma.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BU {
	
	private int buid;
	private String buname;
	public BU(int buid, String buname) {
		super();
		this.buid = buid;
		this.buname = buname;
	}
	public BU() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBuid() {
		return buid;
	}
	public void setBuid(int buid) {
		this.buid = buid;
	}
	public String getBuname() {
		return buname;
	}
	public void setBuname(String buname) {
		this.buname = buname;
	}
	
	

	
	

}
