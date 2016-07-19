package Parsing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Address {
	String name;
	String phone;
	String email;
	public Address(){
		
	}
	public Address(String name,String phone,String email)
	{
		this.name=name;
		this.phone=phone;
		this.email=email;
	}  
	@XmlElement  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement  
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@XmlElement  
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
