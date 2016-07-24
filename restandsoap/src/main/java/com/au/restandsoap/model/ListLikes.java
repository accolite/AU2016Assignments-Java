package com.au.restandsoap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ListLikes {
	List<Likes> listlikes;

	public List<Likes> getListlikes() {
		return listlikes;
	}

	public void setListlikes(List<Likes> listlikes) {
		this.listlikes = listlikes;
	}
	
}
