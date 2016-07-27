package com.Chat.Model;

import org.joda.time.format.DateTimeFormat;

public class Message {
String user;
String Message;
int MessageId;
DateTimeFormat time;
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public int getMessageId() {
	return MessageId;
}
public void setMessageId(int messageId) {
	MessageId = messageId;
}
public DateTimeFormat getTime() {
	return time;
}
public void setTime(DateTimeFormat time) {
	this.time = time;
}
}
