package jaxbAssignment;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Example {
	private ArrayList<Student> student;
	@XmlElement
	public ArrayList<Student> getStudent() {
		return student;
	}

	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}

	public Example(ArrayList<Student> student) {
		super();
		this.student = student;
	}

	Example(){}
	
	

}
