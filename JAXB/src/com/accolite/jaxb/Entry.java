package com.accolite.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

	List <GoT> data;

	public List<GoT> getData() {
		return data;
	}

	public void setData(List<GoT> data) {
		this.data = data;
	}
	
}
