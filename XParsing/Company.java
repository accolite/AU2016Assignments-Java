package Assignment;

import java.util.List;  

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
  
@XmlRootElement  
public class Company {  
private int id;  
private List<Employee> employees;  
public Company() {}  
public Company(int id, List<Employee> employees) {  
    super();  
    this.id = id;  
    this.employees = employees;  
}  
@XmlAttribute  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}    
@XmlElement  
public List<Employee> getEmployees() {  
    return employees;  
}  
public void setEmployees(List<Employee> employees) {  
    this.employees = employees;  
}  
}  
