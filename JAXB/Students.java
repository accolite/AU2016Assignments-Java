import java.awt.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Students")
public class Students {

	@XmlElement(name = "Student", type = Student.class)
	private ArrayList<Student> Students = null;

	public Students() {
	}

	public ArrayList<Student> getStudents() {
		return Students;
	}

	public void setStudents(ArrayList<Student> Students) {
		this.Students = Students;
	}
}
