package com.springchat.dao;


import java.util.HashSet;
import java.util.Set;

public class ActiveUsers {
 
 Set<String> activeUsersList;
 
 public ActiveUsers() {
  this.activeUsersList = new HashSet<String>();
 }

 public Set<String> getActiveUsersList() {
  return activeUsersList;
 }

 public void setActiveUsersList(Set<String> activeUsersList) {
  this.activeUsersList = activeUsersList;
 }
 
 public boolean addUserToActiveUsersList(String username){
  return this.activeUsersList.add(username);
 }

public boolean removeUserToActiveUsersList(String username) {
	return this.activeUsersList.remove(username);
}

}