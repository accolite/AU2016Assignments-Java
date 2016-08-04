package com.au.adportal.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue
	private int postid;
	@Column
	private int price;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private int location;
	@Column
	private int category;
	@Column
	private String userid;
	@Column
	private int status;
	@Column(name = "created_date", nullable = false)
	private Timestamp createdDate;
	
	public Post() {
	}
	public Post(int price, String title, String description, int location, int status, int category) {
		this.price = price;
		this.title = title;
		this.description = description;
		this.location = location;
		this.status = status;
		this.category = category;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return postid +":"+ title +":"+ description+":"+userid +":"+ location +":"+ category +":"+ price +":"+ status;
	}
	
}
