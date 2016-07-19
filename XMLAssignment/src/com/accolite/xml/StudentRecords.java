package com.accolite.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="students")
public class StudentRecords {

 public StudentRecords() {
  // TODO Auto-generated constructor stub
 }
  String firstname;
 String lastname;
 String email;
 String phonenumber;
 @XmlElement(name="lastname")
 public String getLastname() {
  return lastname;
 }

 public void setLastname(String lastname) {
  this.lastname = lastname;
 }
 @XmlElement(name="email")
 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }
 @XmlElement(name="phone")
 public String getPhonenumber() {
  return phonenumber;
 }

 public void setPhonenumber(String phonenumber) {
  this.phonenumber = phonenumber;
 }
 @XmlElement(name="firstname")
 public String getFirstname() {
  return firstname;
 }

 public void setFirstname(String firstname) {
  this.firstname = firstname;
 }



}