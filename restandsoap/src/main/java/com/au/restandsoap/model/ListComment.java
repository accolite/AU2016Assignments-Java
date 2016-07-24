package com.au.restandsoap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ListComment {
	List <Comment> listcomment;

	public List<Comment> getListcomment() {
		return listcomment;
	}

	public void setListcomment(List<Comment> listcomment) {
		this.listcomment = listcomment;
	}
	
}
