package com.accolite.problem;


import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Student{
 
	int id;
   String name;
   String branch;
   int age;
   DOB dob;
   
   public Student() {
	// TODO Auto-generated constructor stub
}
   public Student(String name,String branch,int age,DOB dob,int id) {
	   this.name=name;
	   this.branch=branch;
	   this.age=age;
	   this.dob=dob;
	   this.id=id;
	// TODO Auto-generated constructor stub
}
   
   public DOB getDob() {
	return dob;
   }
   
   public void setDob(DOB dob) {
		this.dob = dob;
	}
   
   public String getBranch() {
	return branch;
   }

  
   public void setBranch(String branch) {
		this.branch = branch;
	}



   public String getName(){
      return name;
   }

  
   public void setName(String name){
      this.name = name;
   }

   public int getAge(){
      return age;
   }

  
   public void setAge(int age){
      this.age = age;
   }

   public int getId(){
      return id;
   }

  
   public void setId(int id){
      this.id = id;
   }
}