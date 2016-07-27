package com.springdemo.tutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class B {
	
	@Value("7")
	private Integer p;
	@Value("6")
	private Integer q;
	@Value("5")
	private Integer r;
	
	public Integer getP() {
		return p;
	}
	public void setP(Integer p) {
		this.p = p;
	}
	public Integer getQ() {
		return q;
	}
	public void setQ(Integer q) {
		this.q = q;
	}
	public Integer getR() {
		return r;
	}
	public void setR(Integer r) {
		this.r = r;
	}
}
