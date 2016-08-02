package com.au.adportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.orm.jpa.EntityScan;

@Entity
@EntityScan(basePackages = "com.au.adportal.model")
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue
	private int categoryid;
	
	@Column
	private String categoryname;

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Category(short categoryid, String categoryname) {
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}

	public Category() {
	}	
	
}
