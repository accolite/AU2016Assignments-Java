package pkg;
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
@XmlRootElement 
public class Address 
{  
    String ph_no;  
    String name;  
    String  birth;  
  
	public Address() {}  
	public Address(String ph_no, String name, String birth) 
	{  
	    this.ph_no = ph_no;  
	    this.name = name;  
	    this.birth = birth;  
	}  
	@XmlAttribute  
	public String getph_no() {  
	    return ph_no;  
	}  
	public void setph_no(String ph_no) {  
	    this.ph_no = ph_no;  
	}  
	@XmlElement  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	@XmlElement  
	public String getBirth() {  
	    return this.birth;  
	}  
	public void setSalary(String birth) {  
	    this.birth = birth;  
	}  
	    
}  


