package com.accolite.marshallingUnmarshalling;

import javax.xml.bind.annotation.XmlElement;

public class Employee {
	 private int id;
	 private String firstName;
	 private String lastName;
	 private long mobileNumber;
	 private String permanentaddress;
	 private int areapincode;
	 
	 @XmlElement
	 public int getId() {
	  return id;
	 }
	 public void setId(int id) {
	  this.id = id;
	 }
	 
	 @XmlElement
	 public String getFirstName() {
	  return firstName;
	 }
	 public void setFirstName(String firstName) {
	  this.firstName = firstName;
	 }
	 
	 @XmlElement
	 public String getLastName() {
	  return lastName;
	 }
	 public void setLastName(String lastName) {
	  this.lastName = lastName;
	 }
	 
	 @XmlElement
	 public long getmobileNumber() {
	  return mobileNumber;
	 }
	 public void setmobileNumber(long mobileNumber) {
	  this.mobileNumber = mobileNumber;
	 }
	 
	 @XmlElement
	 public String getpermanentAddress() {
	  return permanentaddress;
	 }
	 public void setpermanentAddress(String permanentaddress) {
	  this.permanentaddress = permanentaddress;
	 }
	 
	 @XmlElement
	 public int getareaPincode() {
	  return areapincode;
	 }
	 public void setareaPincode(int areapincode) {
	  this.areapincode = areapincode;
	
}
	 
}
