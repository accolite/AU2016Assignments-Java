package com.accolite.problem;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class AddList {
	List<Student> students;

	public List<Student> getList() {
		return students;
	}

	public void setList(List<Student> list) {
		this.students = list;
	}
	
	

}
