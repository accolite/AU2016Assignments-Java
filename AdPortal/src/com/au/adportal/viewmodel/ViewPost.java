package com.au.adportal.viewmodel;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

import com.au.adportal.model.Location;
import com.au.adportal.model.Post;
import com.au.adportal.service.ServiceInterface;

public class ViewPost {
	Integer postid;
	String title;
	String description;
	String location;
	String category;
	String username;
	String userid;
	int price;
	int status;
	String datetime;
	private Timestamp createdDate;
	private SimpleDateFormat dateFormat;
	ArrayList<String> images;

	public ViewPost() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPostid() {

		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public String getTitle() {

		return title;
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

	public String getLocation() {

		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public String getCreatedDate() {
		return datetime;
	}

	public void setCreatedDate(Timestamp createdDate) {
		System.out.print(createdDate+"");
		//DateFormat format = new SimpleDateFormat("MMddyyHHmmss");
		Date date2 = new Date(createdDate.getTime());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			
			Date date = format.parse(createdDate+"");
			System.out.println(format.format(createdDate));
	        System.out.println(format.format(date));
			this.datetime=format.format(date).toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.datetime="";
			//return null;
		}
		
		//this.createdDate = createdDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
