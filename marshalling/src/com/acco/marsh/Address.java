package com.acco.marsh;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {
   Name name;
   String email;
   long phn;
 
   @XmlElement 
   public Name getName() {
	   return name;
   		}
   public void setName(Name name) {
	   this.name = name;
   }
   @XmlElement 
   public String getEmail() {
	   return email;
   }
   public void setEmail(String email) {
	   this.email = email;
   }
   @XmlElement 
   public long getPhn() {
	   return phn;
   }
   public void setPhn(long phn) {
	   this.phn = phn;
   }
   
   public Address getAddress()
   {
	   return this;
   }
   
}
