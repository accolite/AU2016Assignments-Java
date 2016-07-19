package Parsing;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement (name="Student")
public class Student {
	private List<Address> address;
	public Student(){
		
	}
	public Student(List<Address> address){
		super();
		this.address=address;
	}
	@XmlElement  
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
	
}
