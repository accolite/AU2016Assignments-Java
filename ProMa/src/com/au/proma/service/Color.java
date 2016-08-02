package com.au.proma.service;

import com.au.proma.model.BU;

public class Color {
	private BU bu;
	private int red;
	private int yellow;
	private int green;
	private int total;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Color(int red, int yellow, int green) {
		super();
		this.red = red;
		this.yellow = yellow;
		this.green = green;
	}
	public Color() {
		super();
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getYellow() {
		return yellow;
	}
	public void setYellow(int yellow) {
		this.yellow = yellow;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public void incrementRed()
	{
		this.red++;
	}
	public void incrementYellow()
	{
		this.yellow++;
	}public void incrementGreen()
	{
		this.green++;
	}
	public void incrementTotal()
	{
		this.total++;
	}
	public BU getBu() {
		return bu;
	}
	public void setBu(BU bu) {
		this.bu = bu;
	}
	
	
}
