
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Students {
	@XmlElement(name="students")
	private List<StudentRecords> students = null;

	public List<StudentRecords> getStudents() {
		return students;
	}

	public void setStudents(List<StudentRecords> students) {
		this.students = students;
	}

}
