package Assignment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Employee {  
private int id;  
private String fName;  
private String lName;  
private String nName;  
public Employee() {}  
public Employee(int id, String fName, String lName, String nName) {  
    super();  
    this.id = id;  
    this.fName = fName;  
    this.lName = lName;
    this.nName = nName;
}
@XmlAttribute  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}
@XmlElement  
public String getfName() {  
    return fName;  
}  
public void setfName(String fName) {  
    this.fName = fName;  
}  
@XmlElement  
public String getlName() {  
    return lName;  
}  
public void setlName(String lName) {  
    this.lName = lName;  
}  
@XmlElement  
public String getnName() {  
    return nName;  
}  
public void setnName(String nName) {  
    this.nName = nName;  
}  
  
}  
