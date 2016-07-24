package com.accolite.rest;



public class Message {
private int mid;
private int cid;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getMsg() {
	return Msg;
}
public void setMsg(String msg) {
	Msg = msg;
}
private int  pid;
 private String Msg;
 

Message()
{
pid=0;
mid=0;
Msg=null;

cid=0;
}


}
