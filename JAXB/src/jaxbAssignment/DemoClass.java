package jaxbAssignment;
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class DemoClass {
	private String firstname;
	private String lastname;
	private String nickname;
	private Integer marks;
	private Integer rollno;
	DemoClass(){}

	@XmlAttribute 
	public Integer getRollno() {
		return rollno;
	}


	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}


	public DemoClass(String firstname, String lastname, String nickname, Integer marks, Integer rollno) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.marks = marks;
		this.rollno = rollno;
	}
	@XmlElement
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@XmlElement
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@XmlElement
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@XmlElement
	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
}
