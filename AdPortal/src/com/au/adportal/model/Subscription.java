package com.au.adportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription {
	@Id
	@GeneratedValue
	private int  subscriptionId;
	@Column
	private String userid;
	@Column
	private Integer categoryid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Subscription() {}

	public Subscription(String userid, Integer categoryid) {
		this.userid = userid;
		this.categoryid = categoryid;
	}
	
}
