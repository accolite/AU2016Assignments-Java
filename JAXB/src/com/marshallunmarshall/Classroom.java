package com.marshallunmarshall;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Classroom {
	
	ArrayList<Student> classroom;
	Classroom(){
		
	}
	Classroom(ArrayList<Student> classroom)
	{
		this.classroom = classroom;
	}
	@XmlElement(name="Student")
	public ArrayList<Student> getClassroom() {
		return classroom;
	}
	public void setClassroom(ArrayList<Student> classroom) {
		this.classroom = classroom;
	}
}
