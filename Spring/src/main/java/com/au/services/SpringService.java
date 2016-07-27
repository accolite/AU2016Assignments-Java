package com.au.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.jdbctemplate.JDBCTemplateDao;
import com.au.jdbctemplate.Messages;
import com.au.jdbctemplate.Users;

@Service
public class SpringService {
      
    @Autowired
	private JDBCTemplateDao jdbct ;
    
   public  void insertUser(Users user){
    	jdbct.insertUser(user);
    }
   
   public  void insertMessage(Messages msg){
   	jdbct.insertMessage(msg);
   }
   
   public  void insertWord(String word){
	   	jdbct.insertWord(word);
  } 
	
  public String getMessages(){
	  ArrayList<Messages> list=new ArrayList<Messages>();  
	  list=jdbct.getAllMessages();
	  String str="";
	  for(int i=0;i<list.size();i++){
		  Messages msg=list.get(i);
		  str=str+msg.getUserName()+": "+msg.getMessageContent()+"<br>";
	  }
	  return str;
  } 
  public boolean verifyWords(String word){
	  ArrayList<String> list=new ArrayList<String>();  
	  list=jdbct.getAllWords();
	  for(int i=0;i<list.size();i++){
		  String msg=list.get(i);
		  if(msg.equals(word))
		  return true;
	  }
	  return false;
  } 
  public boolean verifyUser(String uname,String password){
	  Users user=jdbct.getUser(uname);
	  if(user.getPassword().equals(password))
		  return true;
	  else
	  return false;	  
  }
  
  public String getName(String uname){
	  Users user=jdbct.getUser(uname);
	  return user.getName();
  }
  
}
