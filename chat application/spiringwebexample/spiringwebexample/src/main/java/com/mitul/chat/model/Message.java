package com.mitul.chat.model;

import java.util.Date;


public class Message {
    private String message;
    private Date created;
    private User user;

    public Message(String message, Date created, User user) {
        this.message = message;
        this.created = created;
        this.user = user;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
